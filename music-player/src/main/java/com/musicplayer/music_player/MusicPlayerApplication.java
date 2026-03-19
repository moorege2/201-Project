package com.musicplayer.music_player;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.musicplayer", "com.musicplayer.music_player", "com.musicapp.musicapp"})
@EnableMongoRepositories(basePackages = "com.musicplayer")
public class MusicPlayerApplication {

    public static void main(String[] args) {
        String mongoUri = System.getenv("MONGO_URI");
        if (mongoUri != null) {
            System.setProperty("spring.data.mongodb.uri", mongoUri);
        } else {
            System.setProperty("spring.data.mongodb.uri", 
                "mongodb+srv://moorege2:25foot23@cluster0.xuq2e43.mongodb.net/musicdb?retryWrites=true&w=majority");
        }
        SpringApplication.run(MusicPlayerApplication.class, args);
    }
}