package pe.edu.ulima.tesis_app_android.ui.mainMenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import pe.edu.ulima.tesis_app_android.R;
import pe.edu.ulima.tesis_app_android.services.Services;
import pe.edu.ulima.tesis_app_android.ui.mainMenu.fragment.ReportTabFragment;
import pe.edu.ulima.tesis_app_android.ui.mainMenu.fragment.ReportTabFragment1;
import pe.edu.ulima.tesis_app_android.ui.mainMenu.fragment.ReportTabFragment2;
import pe.edu.ulima.tesis_app_android.ui.mainMenu.fragment.ReportTabFragment3;
import pe.edu.ulima.tesis_app_android.ui.mainMenu.fragment.ReportTabFragment4;

public class MainMenuActivity extends AppCompatActivity {
    private MaterialViewPager mViewPager;
    //private DrawerLayout mDrawer;
    //private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;
    Services servicies;
    String[] titles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        setTitle("");

        servicies = new Services();
        titles = servicies.getTitle();
        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        toolbar = mViewPager.getToolbar();
        //mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (toolbar != null) {
            setSupportActionBar(toolbar);

            final ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayShowTitleEnabled(true);
                actionBar.setDisplayUseLogoEnabled(false);
                actionBar.setHomeButtonEnabled(true);
            }
        }

        //mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, 0, 0);
        //mDrawer.setDrawerListener(mDrawerToggle);

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 5) {
                    case 0:
                        return ReportTabFragment.newInstance();
                    case 1:
                        return ReportTabFragment1.newInstance();
                    case 2:
                        return ReportTabFragment2.newInstance();
                    case 3:
                        return ReportTabFragment3.newInstance();
                    case 4:
                        return ReportTabFragment4.newInstance();
                    default:
                        return ReportTabFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 5) {
                    case 0:
                        return titles[0];
                    case 1:
                        return titles[1];
                    case 2:
                        return titles[2];
                    case 3:
                        return titles[3];
                    case 4:
                        return titles[4];
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.MaterialViewPagerListener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.tab0,
                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.tab1,
                                "https://fs01.androidpit.info/a/63/0e/android-l-wallpapers-630ea6-h900.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.tab2,
                                "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.tab3,
                                "https://fs01.androidpit.info/a/63/0e/android-l-wallpapers-630ea6-h900.jpg");
                    case 4:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.tab4,
                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        mViewPager.getViewPager().setCurrentItem(1);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //mDrawerToggle.syncState();
    }

}
