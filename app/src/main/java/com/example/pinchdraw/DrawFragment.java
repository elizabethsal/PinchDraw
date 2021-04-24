package com.example.pinchdraw;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DrawFragment extends Fragment {
    public static DrawFragment newInstance(){
        return new DrawFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);{
        View v = inflater.inflate(R.layout.activity_fragment, container,false);
        return v;
    }
}
