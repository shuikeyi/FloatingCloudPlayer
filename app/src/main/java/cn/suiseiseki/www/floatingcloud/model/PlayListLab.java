package cn.suiseiseki.www.floatingcloud.model;

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
        test();
    }

    /**
     *
     */
    private void test()
    {
        PlayList testList = new PlayList();
        testList.setName("Mylist");
        Music music1 = new Music();
        music1.setTitle("haha");
        music1.setAlbum("yue");
        music1.setArtist("T.I");
        Music music2 = new Music();
        music2.setTitle("sale");
        music2.setAlbum("alr");
        testList.addMusic(music1);
        testList.addMusic(music2);
        mPlayLists.add(testList);
        for(int i=1;i<5;i++)
        {
            mPlayLists.add(new PlayList("Playlist"+(i+1)));
        }
    }

    // open a only method to get the single instance
    public static PlayListLab getInstance(Context context)
    {
        if(mPlayListLab == null) {
            mPlayListLab = new PlayListLab(context.getApplicationContext());
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
