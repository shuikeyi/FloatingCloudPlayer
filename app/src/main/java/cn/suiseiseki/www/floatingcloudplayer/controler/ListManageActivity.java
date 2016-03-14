package cn.suiseiseki.www.floatingcloudplayer.controler;

import android.app.Fragment;


public class ListManageActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment()
    {
        return new ListManageFragment();
    }



}
