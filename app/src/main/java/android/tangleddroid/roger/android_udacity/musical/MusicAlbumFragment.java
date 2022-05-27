package android.tangleddroid.roger.android_udacity.musical;

import android.content.Intent;
import android.os.Bundle;
import android.tangleddroid.roger.R;
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
public class MusicAlbumFragment extends Fragment {
    ArrayAdapter<MusicAlbum> mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View album = inflater.inflate(R.layout.fragment_album, container, false);

        final ArrayList<MusicAlbum> items = new ArrayList<MusicAlbum>();
        MusicSong musicSong1 = new MusicSong(getString(R.string.song_1), getString(R.string.artist_1), getString(R.string.album_1));
        MusicSong musicSong2 = new MusicSong(getString(R.string.song_2), getString(R.string.artist_2), getString(R.string.album_2));
        MusicSong musicSong3 = new MusicSong(getString(R.string.song_3), getString(R.string.artist_1), getString(R.string.album_1));
        MusicSong musicSong4 = new MusicSong(getString(R.string.song_4), getString(R.string.artist_2), getString(R.string.album_2));
        MusicAlbum musicAlbum1 = new MusicAlbum(getString(R.string.album_1), new MusicSong[]{musicSong1, musicSong3});
        MusicAlbum musicAlbum2 = new MusicAlbum(getString(R.string.album_2), new MusicSong[]{musicSong2, musicSong4});
        items.add(musicAlbum1);
        items.add(musicAlbum2);

        ListView listView = (ListView) album.findViewById(R.id.listView);

        mAdapter = new ArrayAdapter<MusicAlbum>(getActivity(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                                                Intent intent = new Intent(getActivity(), MusicViewerActivity.class);
                                                intent.putExtra("album", items.get(position).getAlbumName());
                                                intent.putExtra("songs", items.get(position).getSongNames());
                                                intent.putExtra("fragment", "Album");
                                                startActivity(intent);
                                            }
                                        }
        );
        return album;
    }
}
