package com.samit.lld.designpatterns.behavioral.iterator.good;

import java.util.ArrayList;
import java.util.Collections;

public class ShuffledPlaylistIterator implements PlaylistIterator {
  private Playlist playlist;
  private int index;
  private ArrayList<String> shuffledSongs;

  public ShuffledPlaylistIterator(Playlist playlist) {
    this.playlist = playlist;
    this.shuffledSongs = new ArrayList<>(playlist.getSongs());
    Collections.shuffle(shuffledSongs); // Shuffle the songs randomly
    this.index = 0;
  }

  @Override
  public boolean hasNext() {
    return index < shuffledSongs.size();
  }

  @Override
  public String next() {
    return shuffledSongs.get(index++);
  }
}