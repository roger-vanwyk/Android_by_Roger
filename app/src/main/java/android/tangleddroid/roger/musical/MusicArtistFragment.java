package android.tangleddroid.roger.musical;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import android.tangleddroid.roger.R;

import java.util.ArrayList;

/**
 * Copyright (c) 2019 by Roger van Wyk.
 */
public class MusicArtistFragment extends Fragment {
    ArrayAdapter<MusicArtist> mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View artist = inflater.inflate(R.layout.frag_artist, container, false);

        final ArrayList<MusicArtist> items = new ArrayList<MusicArtist>();
        MusicSong musicSong1 = new MusicSong(getString(R.string.song_1), getString(R.string.artist_1), getString(R.string.album_1));
        MusicSong musicSong2 = new MusicSong(getString(R.string.song_2), getString(R.string.artist_2), getString(R.string.album_2));
        MusicSong musicSong3 = new MusicSong(getString(R.string.song_3), getString(R.string.artist_1), getString(R.string.album_1));
        MusicSong musicSong4 = new MusicSong(getString(R.string.song_4), getString(R.string.artist_2), getString(R.string.album_2));
        MusicAlbum musicAlbum1 = new MusicAlbum(getString(R.string.album_1), new MusicSong[]{musicSong1, musicSong3});
        MusicAlbum musicAlbum2 = new MusicAlbum(getString(R.string.album_2), new MusicSong[]{musicSong2, musicSong4});
        MusicArtist musicArtist1 = new MusicArtist(getString(R.string.artist_1), new MusicSong[]{musicSong1, musicSong3}, new MusicAlbum[]{musicAlbum1});
        MusicArtist musicArtist2 = new MusicArtist(getString(R.string.artist_2), new MusicSong[]{musicSong2, musicSong4}, new MusicAlbum[]{musicAlbum2});
        items.add(musicArtist1);
        items.add(musicArtist2);


        ListView listView = (ListView) artist.findViewById(R.id.listView);

        mAdapter = new ArrayAdapter<MusicArtist>(getActivity(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                                                Intent intent = new Intent(getActivity(), MusicViewerActivity.class);
                                                intent.putExtra("artist", items.get(position).getArtistName());
                                                intent.putExtra("albums", items.get(position).getAlbumNames());
                                                intent.putExtra("songs", items.get(position).getSongNames());
                                                intent.putExtra("fragment", "Artist");
                                                startActivity(intent);
                                            }
                                        }
        );
        return artist;
    }
}
