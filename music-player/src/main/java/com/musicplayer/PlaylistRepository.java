package com.musicplayer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PlaylistRepository extends MongoRepository<Playlist, String> {
    ArrayList<Playlist> findByName(String name);
    ArrayList<Playlist> findByIsPrivate(boolean isPrivate);
}