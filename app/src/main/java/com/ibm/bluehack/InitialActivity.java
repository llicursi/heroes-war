package com.ibm.bluehack;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.ibm.bluehack.herowars.FactionChoiceActivity;
import com.ibm.bluehack.herowars.MenuActivity;
import com.ibm.bluehack.herowars.R;
import com.ibm.bluehack.herowars.SlideIntroActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class InitialActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_initial);
        final Intent intent = new Intent(this, FactionChoiceActivity.class);

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

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }



    @Override
    public void onEnterAnimationComplete() {

    }
}
