package com.musicplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlists")
@CrossOrigin(origins = "*")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    // ===== Get all playlists =====
    @GetMapping("/")
    public List<Playlist> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

    // ===== Get playlist by ID =====
    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable String id) {
        return playlistService.getPlaylistById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ===== Find playlists by name =====
    @GetMapping("/search")
    public List<Playlist> getPlaylistsByName(@RequestParam String name) {
        return playlistService.getPlaylistsByName(name);
    }

    // ===== Get playlists by privacy =====
    @GetMapping("/private")
    public List<Playlist> getPlaylistsByPrivacy(@RequestParam boolean isPrivate) {
        return playlistService.getPlaylistsByPrivacy(isPrivate);
    }

    // ===== Get public playlists for a user =====
    @GetMapping("/user/{username}/public")
    public List<Playlist> getPublicPlaylistsForUser(@PathVariable String username) {
        return playlistService.getPublicPlaylistsForUser(username);
    }

    // ===== Create a new playlist =====
    @PostMapping("/")
    public Playlist createPlaylist(@RequestBody Playlist playlist,
                                   @RequestParam String username) {
        return playlistService.createPlaylist(playlist, username);
    }

    // ===== Update an existing playlist =====
    @PutMapping("/{id}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable String id,
                                                    @RequestBody Playlist updatedPlaylist) {
        return ResponseEntity.ok(playlistService.updatePlaylist(id, updatedPlaylist));
    }

    // ===== Add a song to a playlist =====
    @PutMapping("/{id}/songs/{songId}")
    public ResponseEntity<Playlist> addSong(@PathVariable String id,
                                             @PathVariable String songId) {
        return playlistService.addSongToPlaylist(id, songId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ===== Remove a song from a playlist =====
    @DeleteMapping("/{id}/songs/{songId}")
    public ResponseEntity<Playlist> removeSong(@PathVariable String id,
                                                @PathVariable String songId) {
        return playlistService.removeSongFromPlaylist(id, songId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ===== Delete a playlist =====
    @DeleteMapping("/{id}")
    public String deletePlaylist(@PathVariable String id,
                                  @RequestParam String username) {
        return playlistService.deletePlaylist(id, username);
    }
}