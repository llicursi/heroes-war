package com.ibm.bluehack.herowars;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class DuelActivity extends AppCompatActivity {

    private LinearLayout relativeLayout ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_duel);
        relativeLayout = (LinearLayout) findViewById(R.id.cardLayout);
        Button intBtn = (Button) findViewById(R.id.int_btn);
        intBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // previously invisible view
                final View myView = findViewById(R.id.derrota_view);

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
                        callNextActivity();

                        myView.setVisibility(View.VISIBLE);
                        final View wonderView = findViewById(R.id.wonder_derrota_view);
                        wonderView.setVisibility(View.VISIBLE);
                    }
                };
                inital.start();
            }
        });
        defineCardBackground();

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void defineCardBackground() {
        String uri = "@drawable/card_renato";
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        relativeLayout.setBackground(res);

    }

    private void callNextActivity() {
        System.out.println("Ent callNextActivity");
        final Intent intent = new Intent(this, MenuActivity.class);

        CountDownTimer inital = new CountDownTimer(5000, 5000) {
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

    @Override
    public void onBackPressed() {

    }
}
