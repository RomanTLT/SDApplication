package com.softdesign.school.ui.activities;


//import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;


//import com.softdesign.school.R;
import com.softdesign.school.ui.fragments.ContactsFragment;
import com.softdesign.school.ui.fragments.ProfileFragment;
import com.softdesign.school.ui.fragments.SettingsFragment;
import com.softdesign.school.ui.fragments.TasksFragment;
import com.softdesign.school.ui.fragments.TeamFragment;
import com.softdesign.school.utils.Lg;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String VISIBLE_KEY = "visible";

    CheckBox mCheckBox;
    EditText mEditText;
    EditText mEditText2;
    FragmentManager mFragmentManager;
    android.support.v7.widget.Toolbar mToolBar;
    private int mToolbarColorScheme;  //цветовая схема  /
    private NavigationView mNavigationView;
    private DrawerLayout mNavigationDrawer;
    private Fragment mFragment;
    private FrameLayout mFrameContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Lg.e(this.getLocalClassName(), "------------------------------------");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("School lesson 1");
        Lg.e(this.getLocalClassName(), "on create");

        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigation_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);

        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mCheckBox.setOnClickListener(this);

        mEditText = (EditText) findViewById(R.id.edittext);
        mEditText2 = (EditText) findViewById(R.id.edittext2);
        mToolBar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);

        mToolbarColorScheme = 0;
        setupToolbar();
        setupDrawer();
        setTitle(this.getClass().getSimpleName());

        if (savedInstanceState == null) {
            int visibleState = savedInstanceState.getBoolean(VISIBLE_KEY) ? View.VISIBLE : View.INVISIBLE;
            mEditText.setVisibility(visibleState);
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, new ProfileFragment()).commit();
        }
    }

    private void setupToolbar() {
        Lg.e(this.getLocalClassName(), "on setup toolbar");
        setSupportActionBar(mToolBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Lg.e(this.getLocalClassName(), "menu itrm selected");
        if (item.getItemId() == android.R.id.home) {
            /*Toast.makeText(this, "Menu click!", Toast.LENGTH_SHORT).show();
              mToast.show() */
            mNavigationDrawer.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        Lg.e(this.getLocalClassName(), "event click");
        int id = v.getId();

        switch (id) {
            case R.id.checkBox: {
                Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();
                if (mCheckBox.isChecked()) {
                    mEditText2.setVisibility(View.INVISIBLE);
                } else {
                    mEditText2.setVisibility(View.VISIBLE);
                }
            }


            case R.id.item_red: {
                Toast.makeText(this, "You click the Red button!", Toast.LENGTH_SHORT).show();
                mToolBar.setBackgroundColor(Color.rgb(255, 0, 0));  //set toolbar color to red
                mToolbarColorScheme = 1;  //assigning variable state = 1 (red)
            }


            case R.id.item_green: {
                Toast.makeText(this, "You click the Green button!", Toast.LENGTH_SHORT).show();
                mToolBar.setBackgroundColor(Color.rgb(0, 255, 0));  //set toolbar color to green
                mToolbarColorScheme = 2;  //assigning variable state = 2 (green)
            }

            case R.id.item_blue: {
                Toast.makeText(this, "You click the Blue button!", Toast.LENGTH_SHORT).show();
                mToolBar.setBackgroundColor(Color.rgb(0, 0, 255));  //set toolbar color to blue
                mToolbarColorScheme = 3;  //assigning variable state = 3 (blue)
            }


            break;
        }

        Lg.e(this.getLocalClassName(), "event click handler end");

    }


    @Override
    protected void onStart() {
        super.onStart();
        Lg.e(this.getLocalClassName(), "on start");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Lg.e(this.getLocalClassName(), "on resume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Lg.e(this.getLocalClassName(), "on pause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Lg.e(this.getLocalClassName(), "on stop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Lg.e(this.getLocalClassName(), "on restart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Lg.e(this.getLocalClassName(), "on destroy");
    }



    private void setupDrawer() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_profile:
                        mFragment = new ProfileFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_profile).setChecked(true);
                        Toast.makeText(MainActivity.this, item.getTitle().toString());
                        break;
                    case R.id.drawer_contacts:
                        mFragment = new ContactsFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);
                        Toast.makeText(MainActivity.this, item.getTitle.toSting);
                        break;
                    case R.id.drawer_tasks:
                        mFragment = new TasksFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_tasks).setChecked(true);
                        Toast.makeText(MainActivity.this, item.getTitle.toSting);
                        break;
                    case R.id.drawer_team:
                        mFragment = new TeamFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_team).setChecked(true);
                        Toast.makeText(MainActivity.this, item.getTitle.toSting);
                        break;
                    case R.id.drawer_contacts:
                        mFragment = new SettingsFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_settings).setChecked(true);
                        Toast.makeText(MainActivity.this, item.getTitle.toSting);
                        break;
                }

                if (mFragment != null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, mFragment).addToBackStack(null).commit();
                }

                mNavigationDrawer.closeDrawers();
                return false;
            }
        });

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Lg.e(this.getLocalClassName(), "on saveinstantstate");
        outState.putBoolean(VISIBLE_KEY, mEditText2.getVisibility() == View.VISIBLE);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getLocalClassName(), "on restore instant state");

        int vivsibleState = savedInstanceState.getBoolean(VISIBLE_KEY) ? View.VISIBLE : View.INVISIBLE;
        mEditText.setVisibility(vivsibleState);

        switch (mToolbarColorScheme) {
            case 1: {
                mToolBar.setBackgroundColor(Color.rgb(255, 0, 0));  //set toolbar color to red
                //mToolbarColorScheme = 1;  //assigning variable state = 1 (red)
            }
            case 2: {
                mToolBar.setBackgroundColor(Color.rgb(0, 255, 0));  //set toolbar color to green
                //mToolbarColorScheme = 2;  //assigning variable state = 2 (green)
            }
            case 3: {
                mToolBar.setBackgroundColor(Color.rgb(0, 0, 255));  //set toolbar color to green
                //mToolbarColorScheme = 3;  //assigning variable state = 3 (blue)
            }

        }

    }
}
