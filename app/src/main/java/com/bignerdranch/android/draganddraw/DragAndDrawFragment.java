package com.bignerdranch.android.draganddraw;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Smaiyl on 2/2/2018.
 */

public class DragAndDrawFragment extends Fragment {

    public static DragAndDrawFragment newInstance(){


        return new DragAndDrawFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d("FRAGMENT","Fragment ran");

        View v = inflater.inflate(R.layout.fragment_drag_and_draw, container, false);
        return v;




    }



    }



