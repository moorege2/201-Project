package com.musicplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistRepository playlistRepository;

    // ===== Get all playlists =====
    @GetMapping("/")
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    // ===== Get playlist by ID =====
    @GetMapping("/{id}")
    public Optional<Playlist> getPlaylistById(@PathVariable String id) {
        return playlistRepository.findById(id);
    }

    // ===== Find playlists by name =====
    @GetMapping("/search")
    public List<Playlist> getPlaylistsByName(@RequestParam String name) {
        return playlistRepository.findByName(name);
    }

    // ===== Get playlists by privacy =====
    @GetMapping("/private")
    public List<Playlist> getPlaylistsByPrivacy(@RequestParam boolean isPrivate) {
        return playlistRepository.findByIsPrivate(isPrivate);
    }

    // ===== Create a new playlist =====
    @PostMapping("/")
    public Playlist createPlaylist(@RequestBody Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    // ===== Update an existing playlist =====
    @PutMapping("/{id}")
    public Playlist updatePlaylist(@PathVariable String id, @RequestBody Playlist updatedPlaylist) {
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

    // ===== Delete a playlist =====
    @DeleteMapping("/{id}")
    public String deletePlaylist(@PathVariable String id) {
        playlistRepository.deleteById(id);
        return "Playlist with id " + id + " deleted!";
    }
}