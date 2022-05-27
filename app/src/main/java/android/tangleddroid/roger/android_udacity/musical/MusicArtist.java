package android.tangleddroid.roger.android_udacity.musical;

/**
 * Copyright (c) 2019 by Roger van Wyk.
 */
public class MusicArtist {
    private String mArtistName;
    private MusicSong[] mMusicSongs;
    private MusicAlbum[] mMusicAlbums;

    public MusicArtist(String artistName, MusicSong[] musicSongs, MusicAlbum[] musicAlbums) {
        mArtistName = artistName;
        mMusicSongs = musicSongs;
        mMusicAlbums = musicAlbums;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public void setArtistName(String artistName) {
        mArtistName = artistName;
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

    public MusicAlbum[] getAlbums() {
        return mMusicAlbums;
    }

    public void setAlbums(MusicAlbum[] musicAlbums) {
        mMusicAlbums = musicAlbums;
    }

    public String[] getAlbumNames() {
        int len = mMusicAlbums.length;
        String[] albumNames = new String[len];
        for(int i=0; i<len; i++) {
            albumNames[i] = mMusicAlbums[i].getAlbumName();
        }
        return albumNames;
    }

    @Override
    public String toString() {
        return mArtistName;
    }
}
