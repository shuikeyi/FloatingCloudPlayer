package cn.suiseiseki.www.floatingcloud.control;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import cn.suiseiseki.www.floatingcloud.R;


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
    protected  int getLayoutResId()
    {
        return R.layout.activity_list_manage;
    }

    /**
     * Manager the fragment in activity
     * @param savedInstanceState:
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        FragmentManager fragmentManager = getFragmentManager();
        // define the container of Fragment
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
        // check the existence of Fragment
        if(fragment == null) {
            fragment = createFragment();
            // add Fragment into Container
            fragmentManager.beginTransaction().add(R.id.fragmentContainer,fragment).commit();
        }
    }

}
