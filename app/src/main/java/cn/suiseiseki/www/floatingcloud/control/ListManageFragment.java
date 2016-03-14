package cn.suiseiseki.www.floatingcloud.control;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.suiseiseki.www.floatingcloud.R;
import cn.suiseiseki.www.floatingcloud.model.PlayList;
import cn.suiseiseki.www.floatingcloud.model.PlayListLab;

/**
 * Created by Suiseiseki on 2016/3/14.
 */
public class ListManageFragment extends ListFragment {
    public static final String EXTRA_PLAYLIST_ID = "cn.suiseiseki.floatingclound.playlist.id";
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
     * Module to start a Playlist,May has a CallBack to let Activity to handle something
     */
    public interface CallBack
    {
        void onPlayListClick(PlayList list);
    }
    private CallBack mCallBack;
    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mCallBack = (CallBack)activity;
    }
    public void onDetach()
    {
        mCallBack = null;
        super.onDetach();
    }
    @Override
    public void onListItemClick(ListView l,View v,int position,long id)
    {
        PlayList playList = ((PlaylistAdapter)getListAdapter()).getItem(position);
        mCallBack.onPlayListClick(playList);
    }
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent intent)
    {
        ((PlaylistAdapter)getListAdapter()).notifyDataSetChanged();
    }






}
