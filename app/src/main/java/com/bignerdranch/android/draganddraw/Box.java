package com.bignerdranch.android.draganddraw;

import android.graphics.PointF;

/**
 * Created by Smaiyl on 2/2/2018.
 */

public class Box {
    private PointF mOrigin;




    public Box(PointF origin){
        mOrigin = origin;



    }





    public PointF getOrigin () {

        return mOrigin; //
    }

    public void setOriginX(int x){
         mOrigin.x = x;
    }

    public float getOriginX(){
        return mOrigin.x;
    }

    public void setOriginY(int y){
        mOrigin.y= y;
    }

    public float getOriginY(){
        return mOrigin.y;
    }

    public void goDown(){    //go down every time it is redrawn
        mOrigin.y -= 10;
    }     //the boxes move down so the user has to avoid them


}
