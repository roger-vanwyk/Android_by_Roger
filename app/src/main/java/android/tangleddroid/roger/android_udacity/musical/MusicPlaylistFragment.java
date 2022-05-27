package android.tangleddroid.roger.android_udacity.musical;

import android.content.Intent;
import android.os.Bundle;
import android.tangleddroid.roger.R;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * Copyright (c) 2019 by Roger van Wyk.
 */
public class MusicPlaylistFragment extends Fragment {
    ArrayAdapter<MusicPlaylist> mAdapter;
//    String[] items = {"Playlist 1", "Playlist 2"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View playlist = inflater.inflate(R.layout.fragment_playlist, container, false);
        ListView listView = (ListView) playlist.findViewById(R.id.listView);

        final ArrayList<MusicPlaylist> items = new ArrayList<MusicPlaylist>();
        MusicSong musicSong1 = new MusicSong(getString(R.string.song_1), getString(R.string.artist_1), getString(R.string.album_1));
        MusicSong musicSong2 = new MusicSong(getString(R.string.song_2), getString(R.string.artist_2), getString(R.string.album_2));
        MusicSong musicSong3 = new MusicSong(getString(R.string.song_3), getString(R.string.artist_1), getString(R.string.album_1));
        MusicSong musicSong4 = new MusicSong(getString(R.string.song_4), getString(R.string.artist_2), getString(R.string.album_2));
        MusicAlbum musicAlbum1 = new MusicAlbum(getString(R.string.album_1), new MusicSong[]{musicSong1, musicSong3});
        MusicAlbum musicAlbum2 = new MusicAlbum(getString(R.string.album_2), new MusicSong[]{musicSong2, musicSong4});
        MusicPlaylist musicPlaylist1 = new MusicPlaylist(getString(R.string.playlist_1), new MusicSong[]{musicSong3, musicSong4});
        MusicPlaylist musicPlaylist2 = new MusicPlaylist(getString(R.string.playlist_2), new MusicSong[]{musicSong2, musicSong4});
        musicSong2.setPlaylist(new MusicPlaylist[]{musicPlaylist2});
        musicSong3.setPlaylist(new MusicPlaylist[]{musicPlaylist1});
        musicSong4.setPlaylist(new MusicPlaylist[]{musicPlaylist1, musicPlaylist2});
        items.add(musicPlaylist1);
        items.add(musicPlaylist2);

        mAdapter = new ArrayAdapter<MusicPlaylist>(getActivity(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                                            Intent intent = new Intent(getActivity(), MusicViewerActivity.class);
                                            intent.putExtra("playlist", items.get(position).getPlaylistName());
                                            intent.putExtra("songs", items.get(position).getSongNames());
                                            Log.v("playlist songs", items.get(position).getSongNames()[0]);
                                            intent.putExtra("fragment", "Playlist");
                                            startActivity(intent);
                                        }
                                    }
        );
        return playlist;
    }
}
