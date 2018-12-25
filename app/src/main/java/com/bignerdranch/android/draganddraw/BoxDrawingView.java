package com.bignerdranch.android.draganddraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Smaiyl on 2/2/2018.
 */


//x= math.random() * width (math.random is between 0 and 1)
    //y = math.random() * height
public class BoxDrawingView extends View {
    private static final String TAG = "BoxDrawingView";




    private Box mCurrentBox;
    private List<Box> mBoxen = new ArrayList<>();
    private Paint mBoxPaint;
    private Paint mBackgroundPaint;
    public int score;



    public BoxDrawingView(Context context){

        this(context, null);
    }


    public BoxDrawingView(Context context, AttributeSet attrs){
        super(context, attrs);




        Log.d("BOXVIEW", "fragment view ran");
        //Paint the boxes a nice semitransparent red (ARGB) - aRGB - 'a' refers to transparency

        mBoxPaint = new Paint ();
        mBoxPaint.setColor(0x22ff0000);



        //Paint the background off-white

        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(0xfff8efe0);





            for(int i = 0; i< 10; i++){   //draws 10 boxes - the amount of boxes always stays the same throughout the game

                mBoxen.add(new Box(new PointF((float)Math.random() * getWidth(), 0)));
                //make boxes
            }







    }

    public void checkCollision(PointF curr){
        for(Box box : mBoxen){  //if any of the 10 created boxes ever collide with the user's finger
            if((curr.x >= box.getOriginX() && curr.x <= (box.getOriginX()+200)) && (curr.y >= box.getOriginY() && curr.y <= (box.getOriginY()+200))){
                stop();  //the player dies if there is an overlap
            }
        }
    }


    @Override
    protected void onDraw (Canvas canvas){

        //Fill the background

        canvas.drawPaint(mBackgroundPaint);

        for(Box box : mBoxen){
            if(box.getOriginY() >= (getHeight()+200)){
                box.setOriginY(0);
            }
        }

        for (Box box: mBoxen){
//drawing boxes with set dimensions
            float left = Math.min(box.getOrigin().x, box.getOrigin().x+200);
            float right = Math.min(box.getOrigin().x, box.getOrigin().x+200);
            float top = Math.min(box.getOrigin().y, box.getOrigin().y+200);
            float bottom = Math.min(box.getOrigin().y, box.getOrigin().y+200);


            canvas.drawRect(left, top, right, bottom, mBoxPaint);

        }




    }










    @Override
    public boolean onTouchEvent(MotionEvent event){
        PointF current = new PointF (event.getX(), event.getY());
        String action = "";
//switches are like "if" statements
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN";

                checkCollision(current);
                break;


            case MotionEvent.ACTION_MOVE:
                action = "ACTION_MOVE";

                checkCollision(current);  //check if the finger of the user is at the same place as a box

                for (Box box : mBoxen){
                    box.goDown();    //boxes going down in y value
                }
                invalidate();
                score++;     //score based on how long the person stays alive - how many times the screen was re-drawn

                break;


            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";
                stop();
                break;

            case MotionEvent.ACTION_CANCEL:
                action = "ACTION_CANCEL";
                stop();
              //  mCurrentBox = null;
                break;





        }

        //Time-managing method










        Log.i(TAG, action + " at x=" + current.x + ", y =" + current.y);



        return true;
    }


    public void stop(){    //stopping the application

        Toast.makeText(getContext(),
                "Game over. Your score is :" + score,    //score is based on how long the player was alive - how many times the screen was re-drawn
                Toast.LENGTH_SHORT).show();


    }





}
