package org.zterr.frontend.android;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.textservice.TextInfo;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {
    private TextView eventName;
    private TextView eventDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setupActionBar();
        //String message = intent.getStringExtra("extraValue");
        eventName = (TextView) this.findViewById(R.id.textViewName);
        eventName.setText(getIntent().getExtras().getString("EventNameValue"));
        eventDate = (TextView) this.findViewById(R.id.textViewEventDate);
        eventDate.setText(getIntent().getExtras().getString("EventDateValue"));

    }

    private void setupActionBar(){
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Details");
        }
    }
}
