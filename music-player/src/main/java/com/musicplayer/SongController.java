package com.musicplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    @Autowired
    private SongRepository songRepository;

    // Get all songs
    @GetMapping
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    // Get songs by artist
    @GetMapping("/artist/{artist}")
    public ArrayList<Song> getByArtist(@PathVariable String artist) {
        return songRepository.findByArtist(artist);
    }

    // Get songs by genre
    @GetMapping("/genre/{genre}")
    public ArrayList<Song> getByGenre(@PathVariable String genre) {
        return songRepository.findByGenre(genre);
    }

    // Get songs by mood
    @GetMapping("/mood/{mood}")
    public ArrayList<Song> getByMood(@PathVariable String mood) {
        return songRepository.findByMood(mood);
    }

    // Add a new song
    @PostMapping
    public Song addSong(@RequestBody Song newSong) {
        return songRepository.save(newSong);
    }
}