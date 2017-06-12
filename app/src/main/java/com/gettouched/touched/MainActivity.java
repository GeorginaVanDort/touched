package com.gettouched.touched;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Scroller;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    @Bind(R.id.circleImageView) ImageView circle;
    @Bind(R.id.rectanbleImageView) ImageView rectangle;
    @Bind(R.id.phoneImageView) ImageView phone;
    @Bind(R.id.warningImageView) ImageView warning;
    @Bind(R.id.starImageView) ImageView star;
//
//    private Context mContext;
//    private Scroller mScroller = new Scroller(mContext);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        circle.setOnClickListener(this);
        rectangle.setOnClickListener(this);
        phone.setOnClickListener(this);
        warning.setOnClickListener(this);
        star.setOnTouchListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == circle) {
            v.animate()
                    .alpha(0.7f)
                    .scaleX(0.5f)
                    .scaleY(0.5f)
                    .setDuration(1000);

        }
        if( v == phone) {
            circle.animate()
                    .alpha(1f)
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(10);
        }
    }

    public void fling (View v) {
        Animation fling = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.fling);
        v.startAnimation(fling);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v == star) {
            fling(star);
        }
        return false;
    }
}
