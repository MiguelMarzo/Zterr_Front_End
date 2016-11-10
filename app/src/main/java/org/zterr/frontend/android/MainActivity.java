package org.zterr.frontend.android;

import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listViewTasks;
    private ArrayList<Event> events = new ArrayList<Event>();

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setupActionBar();
        //setupData();
        setupCustomList();
        JsonAsyncTask jsonAsynTask = new JsonAsyncTask(this);
        jsonAsynTask.execute("http://zterr.org/web/admin/api/event");



        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("ZTERR");
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                Log.d("DAVIDDEBUG","About selected");
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_settings:
                Log.d("DAVIDDEBUG","Settings selected");
                Intent intent2 = new Intent(this, SettingsActivity.class);
                startActivity(intent2);
                return true;
          /*  case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;*/
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

//    private void setupData() {
//        events = new ArrayList<Event>();
//        WebRequest webRequest = new WebRequest();
//
//        //if (webRequest.get("http://zterr.org/web/admin/api/event")) {
//           // Log.d("DAVIDDEBUG","OK Total: " + webRequest.getResponseString());
//       // } else {
//           // Log.d("DAVIDDEBUG","Error: " + webRequest.getExceptionMessage());
//        //}
//       try{
//            String json = "[{'id':1,'name':'Bolsa de comida','description':'Consigues una bolsa de comida','event_date':'2016-10-01T16:48:00+0200','latitude':0,'longitude':0},{'id':2,'name':'Horda Zombie','description':'Aparecen varios zombies ante ti','event_date':'2016-10-01T16:48:00+0200','latitude':0,'longitude':0},{'id':3,'name':'Bolsa de comida','description':'Consigues una bolsa de comida','event_date':'2016-10-01T16:48:16+0200','latitude':0,'longitude':0},{'id':4,'name':'Horda Zombie','description':'Aparecen varios zombies ante ti','event_date':'2016-10-01T16:48:16+0200','latitude':0,'longitude':0}]";
//            //JSONArray jsonResponse = new JSONArray(json);
//
//            JSONArray events = new JSONArray(json);
//            for (int i = 0; i < events.length(); i++) {
//                Event event = new Event();
//                event.setId(events.getJSONObject(i).getInt("id"));
//                event.setName(events.getJSONObject(i).getString("name"));
//                event.setDescription(events.getJSONObject(i).getString("description"));
//                event.setEvent_date(events.getJSONObject(i).getString("event_date"));
//                event.setLatitude(events.getJSONObject(i).getInt("latitude"));
//                event.setLongitude(events.getJSONObject(i).getInt("longitude"));
//                this.events.add(event);
//            }
//
//        }catch(JSONException e) {
//           throw new RuntimeException(e);
//       }
//    }

    private void setupCustomList() {

        CustomizedListAdapter customizedListAdapter = new CustomizedListAdapter(this, events);

        listViewTasks = (ListView) findViewById(R.id.listViewEvents);

        listViewTasks.setAdapter(customizedListAdapter);


        listViewTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("EventNameValue", events.get(position).getName());
                intent.putExtra("EventDescriptionValue", events.get(position).getDescription());
                startActivity(intent);
            }
        });
    }
    public ArrayList<Event> getEvents() {
        return events;
    }


}
