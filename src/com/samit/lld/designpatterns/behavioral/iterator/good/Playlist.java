package com.samit.lld.designpatterns.behavioral.iterator.good;

import java.util.ArrayList;

public class Playlist {
  private final ArrayList<String> songs;

  public Playlist() {
    songs = new ArrayList<>();
  }

  public void addSong(String song) {
    songs.add(song);
  }

  public PlaylistIterator iterator(String type) {
      return switch (type) {
          case "simple" -> new SimplePlaylistIterator(this);
          case "shuffled" -> new ShuffledPlaylistIterator(this);
          case "favorites" -> new FavoritesPlaylistIterator(this);
          default -> null;
      };
  }

  public ArrayList<String> getSongs() {
    return songs;
  }
}