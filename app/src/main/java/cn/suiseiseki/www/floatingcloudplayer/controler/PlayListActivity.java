package cn.suiseiseki.www.floatingcloudplayer.controler;

import android.app.Fragment;

import cn.suiseiseki.www.floatingcloudplayer.model.PlayList;

/**
 * Created by Suiseiseki/shuikeyi on 2016/3/14.
 */
public class PlayListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment()
    {
        return new PlayListFragment();
    }
}
