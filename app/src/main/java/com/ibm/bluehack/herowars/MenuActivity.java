package com.ibm.bluehack.herowars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MenuActivity extends AppCompatActivity {

    private Button duelButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);
        duelButton = (Button) findViewById(R.id.duel_button);

        initButtonsEvents();

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void initButtonsEvents() {
        final Intent duelIntent = new Intent(this, FindingDuelActivity.class);
        final Intent fotoIntent = new Intent(this, FindingDuelActivity.class);

        duelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(duelIntent);
            }
        });

    }

    @Override
    public void onBackPressed() {

    }
}
