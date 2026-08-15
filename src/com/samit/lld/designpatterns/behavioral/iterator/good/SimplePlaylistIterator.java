package com.samit.lld.designpatterns.behavioral.iterator.good;

public class SimplePlaylistIterator implements PlaylistIterator {
  private final Playlist playlist;
  private int index;

  public SimplePlaylistIterator(Playlist playlist) {
    this.playlist = playlist;
    this.index = 0;
  }

  @Override
  public boolean hasNext() {
    return index < playlist.getSongs().size();
  }

  @Override
  public String next() {
    return playlist.getSongs().get(index++);
  }
}