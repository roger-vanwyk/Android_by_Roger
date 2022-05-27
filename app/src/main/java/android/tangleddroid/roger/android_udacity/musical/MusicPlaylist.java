package android.tangleddroid.roger.android_udacity.musical;

/**
 * Copyright (c) 2019 by Roger van Wyk.
 */
public class MusicPlaylist {
    private String mPlaylistName;
    private MusicSong[] mMusicSongs;

    public MusicPlaylist(String playlistName) {
        mPlaylistName = playlistName;
    }

    public MusicPlaylist(String playlistName, MusicSong[] musicSongs) {
        mPlaylistName = playlistName;
        mMusicSongs = musicSongs;
    }

    public String getPlaylistName() {
        return mPlaylistName;
    }

    public void setPlaylistName(String playlistName) {
        mPlaylistName = playlistName;
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
        return mPlaylistName;
    }
}
