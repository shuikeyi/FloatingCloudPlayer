package cn.suiseiseki.www.floatingcloudplayer;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by Suiseiseki/shuikeyi
 * A abstract class for Activity Only has one Fragment
 */
public abstract class SingleFragmentActivity extends Activity{

    /**
     * May create a fragment that activity uses
     */
    protected abstract Fragment createFragment();
    /**
     * Activity may has its own layout
     */
    protected  abstract int getLayoutResId();

    /**
     * Manager the fragment in activity
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

    }

}
