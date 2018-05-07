package com.quanganh.magicalhat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    RotateAnimation rotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotation();
            }
        });
    }
    private static float lastDegree = 0;
    private void rotation(){
        int circleNum = (int) (new Random().nextInt(10));
        rotateAnimation = new RotateAnimation(lastDegree, (lastDegree + 360*2+45*circleNum)*1.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
        lastDegree += 360*2+45*circleNum;
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(4000);
        imageView.startAnimation(rotateAnimation);

    }
}
