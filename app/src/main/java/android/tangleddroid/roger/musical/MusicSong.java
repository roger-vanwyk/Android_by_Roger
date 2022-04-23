package android.tangleddroid.roger.musical;

/**
 * Copyright (c) 2019 by Roger van Wyk.
 */
public class MusicSong {
    private String mName;
    private String mArtist;
    private String mAlbum;
    private MusicPlaylist[] mMusicPlaylist;

    public MusicSong(String name, String artist, String album) {
        this.mName = name;
        this.mArtist = artist;
        this.mAlbum = album;
    }

    public MusicSong(String name, String artist, String album, MusicPlaylist[] musicPlaylist) {
        this.mName = name;
        this.mArtist = artist;
        this.mAlbum = album;
        this.mMusicPlaylist = musicPlaylist;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String artist) {
        mArtist = artist;
    }

    public String getAlbum() {
        return mAlbum;
    }

    public void setAlbum(String album) {
        mAlbum = album;
    }

    public MusicPlaylist[] getPlaylist() {
        return mMusicPlaylist;
    }

    public void setPlaylist(MusicPlaylist[] musicPlaylist) {
        mMusicPlaylist = musicPlaylist;
    }

    @Override
    public String toString() {
        return mName + " (by " +  mArtist + " from " + mAlbum + ")";
    }
}
