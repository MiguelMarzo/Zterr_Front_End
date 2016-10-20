package org.zterr.frontend.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listViewTasks;
    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().hide();
        setupData();
        setupCustomList();
    }

    private void setupData() {
        users = new ArrayList<User>();
        users.add(new User(1, "USER1", "A", "email1@gmail.com"));
        users.add(new User(2, "USER2", "B", "email2@gmail.com"));
        users.add(new User(3, "USER3", "C", "email3@gmail.com"));
        users.add(new User(4, "USER4", "D", "email4@gmail.com"));
        users.add(new User(5, "USER5", "E", "email5@gmail.com"));
        users.add(new User(6, "USER6", "F", "email6@gmail.com"));
    }

    private void setupCustomList() {

        CustomizedListAdapter customizedListAdapter = new CustomizedListAdapter(this, users);

        listViewTasks = (ListView) findViewById(R.id.listViewUsers);

        listViewTasks.setAdapter(customizedListAdapter);


        listViewTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Intent intent = new Intent(this, DetailActivity.class);
                //intent.putExtra("extraValue", adapterView.getItemIdAtPosition(position));
                //startActivity(intent);
            }
        });
    }
}
