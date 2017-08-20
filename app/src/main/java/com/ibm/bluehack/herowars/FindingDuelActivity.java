package com.ibm.bluehack.herowars;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.RelativeLayout;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FindingDuelActivity extends AppCompatActivity {

    private int getRandonBackground(){
        return 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_find_duel);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.duel_layout_back);
        final Intent intent = new Intent(this, DuelActivity.class);
        CountDownTimer inital = new CountDownTimer(1800, 1800) {
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

}
