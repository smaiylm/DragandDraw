package com.bignerdranch.android.draganddraw;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DragAndDrawActivity extends SingleFragmentActivity {    //Chapter 7 - SingleFragment Activity

    @Override
    protected Fragment createFragment() {
        Log.d("Activity", "activity ran");
        return DragAndDrawFragment.newInstance();
    }

}
