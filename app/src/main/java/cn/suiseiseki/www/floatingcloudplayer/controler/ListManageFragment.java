package cn.suiseiseki.www.floatingcloudplayer.controler;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cn.suiseiseki.www.floatingcloudplayer.R;
import cn.suiseiseki.www.floatingcloudplayer.model.PlayList;
import cn.suiseiseki.www.floatingcloudplayer.model.PlayListLab;

/**
 * Created by Suiseiseki on 2016/3/14.
 */
public class ListManageFragment extends ListFragment {
    //define a PlayListLab to manage PlayLists
    private ArrayList<PlayList> mPlayLists;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // initialization mPlayListLab
        mPlayLists= PlayListLab.getInstance(getActivity()).getPlayLists();
        // set a Adapter
        PlaylistAdapter playlistAdapter = new PlaylistAdapter(mPlayLists);
        setListAdapter(playlistAdapter);
    }

    /**
     * Define a inner class adapter for playlistManager
     */
    private class PlaylistAdapter extends ArrayAdapter<PlayList>
    {
        public PlaylistAdapter(ArrayList<PlayList> list)
        {
            super(getActivity(),0,list);
        }
        @Override
        public View getView(int position,View convertView,ViewGroup parent)
        {
            // get a inflater and get a view
            if(convertView == null)
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_playlists,null);
            // setting the view for this playlist
            PlayList playList = getItem(position);
            Log.d("Test", playList.getName());
            TextView playListNameTextView = (TextView)convertView.findViewById(R.id.textview_name_list_item_playlist);
            playListNameTextView.setText(playList.getName());
            TextView playListMusicNumberTextView = (TextView)convertView.findViewById(R.id.textview_number_list_item_playlist);
            playListMusicNumberTextView.setText(Integer.toString(playList.getMusicsNumber())+" songs");
            return convertView;
        }
    }
    /**
     *
     */






}
