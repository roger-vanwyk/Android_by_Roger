package android.tangleddroid.roger.android_udacity.musical;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

@SuppressWarnings("ALL")
public class MusicTabPagerAdapter extends FragmentStatePagerAdapter {
    public MusicTabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                //Fragment for PlaylistFragment Tab
                return new MusicSongFragment();
            case 1:
                //Fragment for ArtistFragment Tab
                return new MusicArtistFragment();
            case 2:
                return new MusicSongFragment();
            case 3:
                return new MusicAlbumFragment();
        }
        return new MusicPlaylistFragment();

    }

    @Override
    public int getCount() {
        return 4; //No of Tabs
    }
}
