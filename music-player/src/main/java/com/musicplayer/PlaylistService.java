package com.musicplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private UserRepository userRepository;

    // ===== Get all playlists =====
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    // ===== Get playlist by ID =====
    public Optional<Playlist> getPlaylistById(String id) {
        return playlistRepository.findById(id);
    }

    // ===== Search playlists by name =====
    public List<Playlist> getPlaylistsByName(String name) {
        return playlistRepository.findByName(name);
    }

    // ===== Get public or private playlists =====
    public List<Playlist> getPlaylistsByPrivacy(boolean isPrivate) {
        return playlistRepository.findByIsPrivate(isPrivate);
    }

    // ===== Get all public playlists belonging to a user =====
    public List<Playlist> getPublicPlaylistsForUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null || user.getPlaylistIds() == null || user.getPlaylistIds().isEmpty()) {
            return Collections.emptyList();
        }
        // Fetch each playlist by ID and filter to only public ones
        return user.getPlaylistIds().stream()
                .map(id -> playlistRepository.findById(id))
                .filter(opt -> opt.isPresent() && !opt.get().isPrivate())
                .map(Optional::get)
                .sorted()  // uses Playlist.compareTo() — alphabetical by name
                .toList();
    }

    // create a new playlist
    public Playlist createPlaylist(Playlist playlist, String username) {
        Playlist saved = playlistRepository.save(playlist);

        // add the new playlist ID to the user's playlistIds list
        User user = userRepository.findByUsername(username);
        if (user != null) {
            if (user.getPlaylistIds() == null) {
                user.setPlaylistIds(new java.util.ArrayList<>());
            }
            user.getPlaylistIds().add(saved.getId());
            userRepository.save(user);
        }

        return saved;
    }

    // update playlist
    public Playlist updatePlaylist(String id, Playlist updatedPlaylist) {
        return playlistRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedPlaylist.getName());
                    existing.setPrivate(updatedPlaylist.isPrivate());
                    existing.setSongIds(updatedPlaylist.getSongIds());
                    return playlistRepository.save(existing);
                })
                .orElseGet(() -> {
                    updatedPlaylist.setId(id);
                    return playlistRepository.save(updatedPlaylist);
                });
    }

    // add song to playlist
    public Optional<Playlist> addSongToPlaylist(String playlistId, String songId) {
        return playlistRepository.findById(playlistId).map(playlist -> {
            if (playlist.getSongIds() == null) {
                playlist.setSongIds(new java.util.ArrayList<>());
            }
            if (!playlist.getSongIds().contains(songId)) {
                playlist.getSongIds().add(songId);
            }
            return playlistRepository.save(playlist);
        });
    }

    // remove a song
    public Optional<Playlist> removeSongFromPlaylist(String playlistId, String songId) {
        return playlistRepository.findById(playlistId).map(playlist -> {
            if (playlist.getSongIds() != null) {
                playlist.getSongIds().remove(songId);
            }
            return playlistRepository.save(playlist);
        });
    }

    // delete a playlist and remove from list
    public String deletePlaylist(String id, String username) {
        playlistRepository.deleteById(id);

        User user = userRepository.findByUsername(username);
        if (user != null && user.getPlaylistIds() != null) {
            user.getPlaylistIds().remove(id);
            userRepository.save(user);
        }

        return "Playlist " + id + " deleted.";
    }
}