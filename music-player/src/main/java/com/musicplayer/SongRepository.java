package com.musicplayer;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;


@Repository
public interface SongRepository extends MongoRepository<Song, String> {
    ArrayList<Song> findByArtistContainingIgnoreCase(String artist);
    ArrayList<Song> findByTitleContainingIgnoreCase(String title);
    ArrayList<Song> findByGenreContainingIgnoreCase(String genre);
    ArrayList<Song> findByMoodContainingIgnoreCase(String mood);

    
}
