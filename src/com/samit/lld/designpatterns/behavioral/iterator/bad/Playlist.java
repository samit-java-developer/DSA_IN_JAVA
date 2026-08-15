package com.samit.lld.designpatterns.behavioral.iterator.bad;

import java.util.ArrayList;

public class Playlist {
    private final ArrayList<String> songs;

  public ArrayList<String> getSongs() {
    return songs;
  }

//  public void setSongs(ArrayList<String> songs){
//    this.songs=songs;
//  }  We can't do because songs right now you made as final.

  public Playlist() {
        songs = new ArrayList<>();
    }

    public void addSong(String song) {
        songs.add(song);
    }

    public void playPlaylist() {
        for (String song : songs) {
            System.out.println("Playing song: " + song);
        }
    }

    //Now, let’s see how things get ugly when we start adding new features.
    //Here’s an example of what the code might look like when we add a shuffle feature:
    public void playPlaylist(boolean shuffle) {
        if (shuffle) {
            // Shuffle the songs and then play
            System.out.println("Shuffling playlist...");
            // Shuffle logic here...
        } else {
            for (int i = 0; i < songs.size(); i++) {
                System.out.println("Playing song: " + songs.get(i));
            }
        }
        //Now, the playPlaylist() method has become cluttered with additional functionality for shuffling. If we want to add more features, like repeat functionality or filtering songs, the method will become even messier.
    }
}