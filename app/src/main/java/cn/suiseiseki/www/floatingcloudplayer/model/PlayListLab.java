package cn.suiseiseki.www.floatingcloudplayer.model;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Suiseiseki on 2016/3/14.
 */
public class PlayListLab {
    private static PlayListLab mPlayListLab;
    private Context mAppContext;
    private static final String TAG = "PlayListLab";
    private PlayListLab(Context context)
    {
        mAppContext = context;
        mPlayLists = new ArrayList<PlayList>();
        for(int i=0;i<25;i++)
        {
            mPlayLists.add(new PlayList("Playlist"+(i+1)));
        }
    }
    // open a only method to get the single instance
    public static PlayListLab getInstance(Context context)
    {
        if(mPlayListLab == null) {
            mPlayListLab = new PlayListLab(context);
        }
        return mPlayListLab;
    }
    /**
     * use a Arraylist to storage playlists and manager them
     */
    private ArrayList<PlayList> mPlayLists;
    public void addPlayList(PlayList playList)
    {
        mPlayLists.add(playList);
    }
    public void deletePlayList(PlayList playlist)
    {
        mPlayLists.remove(playlist);
    }
    public PlayList getPlayList(String playListName)
    {
        for(PlayList playList:mPlayLists)
        {
            if(playList.getName().equals(playListName))
                return playList;
        }
        return null;
    }
    public PlayList getPlayList(int id)
    {
        for(PlayList playList:mPlayLists)
        {
            if(id == playList.getId())
                return playList;
        }
        return null;
    }
    public ArrayList<PlayList> getPlayLists()
    {
        return mPlayLists;
    }
    /**
     * Test method to add PlayLists
     */

}
