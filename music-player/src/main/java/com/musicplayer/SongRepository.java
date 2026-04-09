package com.musicplayer;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;


@Repository
public interface SongRepository extends MongoRepository<Song, String> {
    ArrayList<Song> findByArtistIgnoreCase(String artist);
    ArrayList<Song> findByTitleIgnoreCase(String title);
    ArrayList<Song> findByGenreIgnoreCase(String genre);
    ArrayList<Song> findByMoodIgnoreCase(String mood);

    
}
