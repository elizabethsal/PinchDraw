package com.example.pinchdraw;

import android.os.Bundle;

import androidx.fragment.app.Fragment;



public class DrawActivity extends FragmentActivity {

    @Override
    protected Fragment createFragment() {
        return DrawFragment.newInstance();



/*
    @Override
    protected Fragment createFragment() {
        return DrawFragment.newInstance();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
*/
    }
    }


