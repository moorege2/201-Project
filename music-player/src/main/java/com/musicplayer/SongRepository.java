package com.musicplayer;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;


@Repository
public interface SongRepository extends MongoRepository<Song, String> {
    ArrayList<Song> findByArtist(String artist);
    ArrayList<Song> findByTitle(String title);
    ArrayList<Song> findByGenre(String genre);
    ArrayList<Song> findByMood(String mood);

    
}
