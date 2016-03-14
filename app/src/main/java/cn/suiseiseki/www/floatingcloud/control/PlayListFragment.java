package cn.suiseiseki.www.floatingcloud.control;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cn.suiseiseki.www.floatingcloud.R;
import cn.suiseiseki.www.floatingcloud.model.Music;
import cn.suiseiseki.www.floatingcloud.model.PlayList;
import cn.suiseiseki.www.floatingcloud.model.PlayListLab;

/**
 * Created by Suiseiseki/shuikeyi on 2016/3/14.
 */
public class PlayListFragment extends ListFragment {
     public static final int REQUEST_PLAYLIST_ID = 3;
     public static final String PLAYLIST_ID = "cn.suiseiseki.floatingcloud.playlist+id";
    /**
     * Use Arguments to receive Playlist id
     */
    public static PlayListFragment newInstance(int playlistId)
    {
        Bundle bundle = new Bundle();
        bundle.putInt(PLAYLIST_ID, playlistId);
        PlayListFragment fragment = new PlayListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    /**
     * has a PlayList object
     * Define a Adapter for Musics in PlayList
     */
    private PlayList mPlayList;
    private class MusicAdapter extends ArrayAdapter<Music>
    {
        public MusicAdapter(ArrayList<Music> list)
        {
            super(getActivity(),0,list);
        }
        @Override
        public View getView(int position,View convertView,ViewGroup parent)
        {
            View v = getActivity().getLayoutInflater().inflate(R.layout.list_items_songs,null);
            TextView songnameTextView = (TextView)v.findViewById(R.id.textview_song_name_list_item);
            TextView artistTextView = (TextView)v.findViewById(R.id.textview_artist_list_item);
            TextView albumTextView = (TextView)v.findViewById(R.id.textview_album_list_item);
            Music music = getItem(position);
            songnameTextView.setText(music.getTitle());
            albumTextView.setText(music.getAlbum());
            artistTextView.setText(music.getArtist());
            return  v;
        }
    }
    /**
     * Use Argument to Rebuild PlayList
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        int id = getArguments().getInt(PLAYLIST_ID,0);
        mPlayList = PlayListLab.getInstance(getActivity()).getPlayList(id);
        MusicAdapter musicAdapter = new MusicAdapter(mPlayList.getMusics());
        setListAdapter(musicAdapter);
    }


}
