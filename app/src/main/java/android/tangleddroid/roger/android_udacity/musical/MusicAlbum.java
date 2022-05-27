package android.tangleddroid.roger.android_udacity.musical;

/**
 * Copyright (c) 2019 by Roger van Wyk.
 */
public class MusicAlbum {
    private String mAlbumName;
    private MusicSong[] mMusicSongs;

    public MusicAlbum(String albumName, MusicSong[] musicSongs) {
        mAlbumName= albumName;
        mMusicSongs = musicSongs;
    }

    public String getAlbumName() {
        return mAlbumName;
    }

    public void setAlbumName(String albumName) {
        mAlbumName = albumName;
    }

    public MusicSong[] getSongs() {
        return mMusicSongs;
    }

    public void setSongs(MusicSong[] musicSongs) {
        mMusicSongs = musicSongs;
    }

    public String[] getSongNames() {
        int len = mMusicSongs.length;
        String[] songNames = new String[len];
        for(int i=0; i<len; i++) {
            songNames[i] = mMusicSongs[i].getName();
        }
        return songNames;
    }

    @Override
    public String toString() {
        return mAlbumName;
    }
}
