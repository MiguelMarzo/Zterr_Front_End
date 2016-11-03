package org.zterr.frontend.android;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class SettingsActivity extends PreferenceActivity {
    Button botonmenu;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        setContentView(R.layout.activity_settings);


        botonmenu = (Button) this.findViewById(R.id.botonmenu);
        botonmenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent miIntent = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(miIntent);
                SettingsActivity.this.finish();
            }
        });
    }

}

