package com.softdesign.school;


import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.
//import android.app.ActionBar;
//import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
//import android.widget.Toolbar;
//import android.support.v7.widget.Toolbar;

import com.softdesign.school.utils.Lg;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String VISIBLE_KEY = "visible";

    CheckBox mCheckBox;
    EditText mEditText;
    EditText mEditText2;
    android.support.v7.widget.Toolbar mToolBar;
    private int  mToolbarColorState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Lg.e(this.getLocalClassName(), "------------------------------------");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("School lesson 1");
        Lg.e(this.getLocalClassName(), "on create");

        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mCheckBox.setOnClickListener(this);

        mEditText = (EditText) findViewById(R.id.edittext);
        mEditText2 = (EditText) findViewById(R.id.edittext2);
        mToolBar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        mToolbarColorState = 0;

        setupToolbar();
    }

    private void setupToolbar(){
        setSupportActionBar(mToolBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(this, "Menu click!", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
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
                mToolbarColorState = 1;  //assigning variable state = 1 (red)
            }


            case R.id.item_green: {
                Toast.makeText(this, "You click the Green button!", Toast.LENGTH_SHORT).show();
                mToolBar.setBackgroundColor(Color.rgb(0, 255, 0));  //set toolbar color to green
                mToolbarColorState = 2;  //assigning variable state = 2 (green)
            }

            case R.id.item_blue: {
                Toast.makeText(this, "You click the Blue button!", Toast.LENGTH_SHORT).show();
                mToolBar.setBackgroundColor(Color.rgb(0, 0, 255));  //set toolbar color to blue
                mToolbarColorState = 3;  //assigning variable state = 3 (blue)
            }


            break;
        }

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

        switch (mToolbarColorState){
            case 1: {
                mToolBar.setBackgroundColor(Color.rgb(255, 0, 0));  //set toolbar color to red
                //mToolbarColorState = 1;  //assigning variable state = 1 (red)
            }
            case 2: {
                mToolBar.setBackgroundColor(Color.rgb(0, 255, 0));  //set toolbar color to green
                //mToolbarColorState = 2;  //assigning variable state = 2 (green)
            }
            case 3: {
                mToolBar.setBackgroundColor(Color.rgb(0, 0, 255));  //set toolbar color to green
               //mToolbarColorState = 3;  //assigning variable state = 3 (blue)
            }

        }

    }
}
