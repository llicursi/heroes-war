package com.ibm.bluehack.herowars;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SlideIntroActivity extends AppCompatActivity {

    private int getRandonBackground(){
        return 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_slide_intro);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void onEnterAnimationComplete() {
        initAnimation();
    }

    private void initAnimation() {

        // previously invisible view
        final View myView = findViewById(R.id.slideView1);

        // get the center for the clipping circle
        int cx = myView.getWidth() / 2;
        int cy = myView.getHeight() / 2;

        // get the final radius for the clipping circle
        float finalRadius = (float) Math.hypot(cx, cy);


        // create the animator for this view (the start radius is zero)
        final Animator anim =  ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);


        CountDownTimer inital = new CountDownTimer(300, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                // does nothing
            }

            @Override
            public void onFinish() {
                // make the view visible and start the animation

                myView.setVisibility(View.VISIBLE);
                anim.start();
                changeTextAnimation();
            }
        };
        inital.start();
    }

    private void changeTextAnimation() {

        System.out.println("Ent changeTextAnimation");
        // previously invisible view
        final TextView myView = (TextView) findViewById(R.id.textView2);
        // create the animator for this view (the start radius is zero)
        final AlphaAnimation animSome = new AlphaAnimation(1f, 0f);


        final CountDownTimer third = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // does nothing
            }

            @Override
            public void onFinish() {
                myView.setText("Colabore para seu time conseguir o super trunfo. Aumente a popularidade dos herois do seu time ao compartilhar fotos de cosplay do evento no twitter");
                showTextAnimation();
            }
        };


        CountDownTimer second = new CountDownTimer(1300, 1300) {
            @Override
            public void onTick(long millisUntilFinished) {
                // does nothing
            }

            @Override
            public void onFinish() {
                // make the view visible and start the animation
               third.start();
            }
        };
        second.start();
    }
    private void showTextAnimation() {
        System.out.println("Ent showTextAnimation");
        // previously invisible view
        final TextView myView = (TextView) findViewById(R.id.textView2);
        // create the animator for this view (the start radius is zero)
        final AlphaAnimation anim = new AlphaAnimation(0f, 1f);
        myView.setAnimation(anim);

        final CountDownTimer second = new CountDownTimer(2000, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // does nothing
            }

            @Override
            public void onFinish() {
                callNextActivity();
            }
        };

        CountDownTimer inital = new CountDownTimer(300, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                // does nothing
            }

            @Override
            public void onFinish() {
                // make the view visible and start the animation
                anim.start();
                second.start();
            }
        };
        inital.start();
    }

    private void callNextActivity() {
        System.out.println("Ent callNextActivity");
        final Intent intent = new Intent(this, MenuActivity.class);

        CountDownTimer inital = new CountDownTimer(800, 800) {
            @Override
            public void onTick(long millisUntilFinished) {
                // does nothing
            }

            @Override
            public void onFinish() {
                startActivity(intent);
            }
        };

        inital.start();


    }


}
