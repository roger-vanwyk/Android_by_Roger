package android.tangleddroid.roger.musical;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.tangleddroid.roger.R;

import java.util.ArrayList;

/**
 * Copyright (c) 2019 by Roger van Wyk.
 */
public class MusicAlbumActivity extends AppCompatActivity {
    ArrayAdapter<MusicSong> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        String albumName = getIntent().getStringExtra("album");
        getSupportActionBar().setTitle(albumName);

        final ArrayList<MusicSong> items = new ArrayList<MusicSong>();
        MusicSong musicSong1 = new MusicSong(getString(R.string.song_1), getString(R.string.artist_1), getString(R.string.album_1));
        MusicSong musicSong2 = new MusicSong(getString(R.string.song_2), getString(R.string.artist_2), getString(R.string.album_2));
        MusicSong musicSong3 = new MusicSong(getString(R.string.song_3), getString(R.string.artist_1), getString(R.string.album_1));
        MusicSong musicSong4 = new MusicSong(getString(R.string.song_4), getString(R.string.artist_2), getString(R.string.album_2));
        MusicAlbum musicAlbum1 = new MusicAlbum(getString(R.string.album_1), new MusicSong[]{musicSong1, musicSong3});
        MusicAlbum musicAlbum2 = new MusicAlbum(getString(R.string.album_2), new MusicSong[]{musicSong2, musicSong4});
        if(albumName.equals(musicAlbum1.getAlbumName())) {
            MusicSong[] musicSongs = musicAlbum1.getSongs();
            for(MusicSong s: musicSongs) {
                items.add(s);
            }
        }
        if(albumName.equals(musicAlbum2.getAlbumName())) {
            MusicSong[] musicSongs = musicAlbum2.getSongs();
            for(MusicSong s: musicSongs) {
                items.add(s);
            }
        }

        ListView listView = (ListView) findViewById(R.id.listView);

        mAdapter = new ArrayAdapter<MusicSong>(MusicAlbumActivity.this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                                                Intent intent = new Intent(MusicAlbumActivity.this, MusicNowPlayingActivity.class);
                                                intent.putExtra("song", items.get(position).getName());
                                                startActivity(intent);
                                            }
                                        }
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
