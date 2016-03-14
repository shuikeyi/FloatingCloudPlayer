package cn.suiseiseki.www.floatingcloudplayer.model;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Suiseiseki/shuikeyi on 2016/3/14.
 */
public class PlayList {
    private static int playListIdCounter = 0;
    /**
     *     A list of Music that list contains
     *    getMusicsNumber:May return the count of Music in the list
     */
    private ArrayList<Music> mMusics;
    public int getMusicsNumber()
    {
        if(mMusics == null)
            return 0;
        else
            return mMusics.size();
    }
    public void addMusic(Music music)
    {
        mMusics.add(music);
    }
    public void addAllMusic(Set<Music> musicSet)
    {
        mMusics.addAll(musicSet);
    }
    public void removeMusic(Music music)
    {
        mMusics.remove(music);
    }
    public void clear()
    {
        mMusics.clear();
    }
    /**
     * mName:The name of a PlayList
     * mId:The id of a PlayList
     */
    private String mName;
    private int mId;
    public int getId() {
        return mId;
    }
    public void setId(int id)
    {
        mId = id;
    }
    public PlayList()
    {
        mId = playListIdCounter++;
    }
    public String getName() {
        return mName;
    }
    public void setName(String mName) {
        this.mName = mName;
    }
    /**
     * Constructor for PlayList
     */
    public PlayList(String name)
    {
        this();
        mName = name;
    }
    public String toString()
    {
        return this.mName;
    }

}
