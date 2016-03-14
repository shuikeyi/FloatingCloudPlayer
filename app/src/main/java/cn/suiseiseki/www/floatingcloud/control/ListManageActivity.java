package cn.suiseiseki.www.floatingcloud.control;

import android.app.Fragment;
import android.content.Intent;

import java.util.List;

import cn.suiseiseki.www.floatingcloud.model.PlayList;


public class ListManageActivity extends SingleFragmentActivity implements ListManageFragment.CallBack{
    @Override
    protected Fragment createFragment()
    {
        return new ListManageFragment();
    }

    /**
     *
     * Start a playList
     */
    @Override
    public void onPlayListClick(PlayList playList)
    {
        Intent i = new Intent(ListManageActivity.this,PlayListActivity.class);
        i.putExtra(ListManageFragment.EXTRA_PLAYLIST_ID,playList.getId());
        startActivityForResult(i, PlayListFragment.REQUEST_PLAYLIST_ID);
    }



}
