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
public class FactionChoiceActivity extends AppCompatActivity {

    private Button marvelButton ;
    private Button dcButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_faction_choice);

        marvelButton = (Button) findViewById(R.id.marvel_btn);
        dcButton = (Button) findViewById(R.id.dc_btn);

        initButtonsEvents();

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void initButtonsEvents() {
        final Intent intent = new Intent(this, SlideIntroActivity.class);

        marvelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        dcButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }

}
