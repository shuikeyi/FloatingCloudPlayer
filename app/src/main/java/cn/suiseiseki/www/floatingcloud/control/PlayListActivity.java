package cn.suiseiseki.www.floatingcloud.control;

import android.app.Fragment;


/**
 * Created by Suiseiseki/shuikeyi on 2016/3/14.
 */
public class PlayListActivity extends SingleFragmentActivity {
    /**
     *
     * Use Arguments to send information of PlayList Clicked
     */
    @Override
    protected Fragment createFragment()
    {
        int id = getIntent().getIntExtra(ListManageFragment.EXTRA_PLAYLIST_ID,0);
        return PlayListFragment.newInstance(id);
    }
}
