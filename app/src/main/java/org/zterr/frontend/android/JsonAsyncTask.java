package org.zterr.frontend.android;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * Created by PELLO_ALTADILL on 05/11/2016.
 */
public class JsonAsyncTask extends AsyncTask<String,String,Void> {

    private MainActivity mainActivity;

    private WebRequest webRequest;
    /**
     * Default constructor
     * @param mainActivity
     */
    public JsonAsyncTask(MainActivity mainActivity) {
        webRequest = new WebRequest();
        attach(mainActivity);
    }

    /**
     * sets mainActivity reference
     * @param mainActivity
     */
    public void attach(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    /**
     * when task is finished this reference is not needed any longer
     */
    public void detach () {
        this.mainActivity = null;
    }

    /**
     * This is called before doInBackground and is a perfect place
     * to prepare the progress Bar.
     */
    @Override
    protected void onPreExecute () {
        Toast.makeText(this.mainActivity, "Starting Async Task", Toast.LENGTH_SHORT).show();
       // this.mainActivity.getProgressBar1().setVisibility(1);
       // this.mainActivity.getEvents();
    }

    /**
     * This is where the task begins and runs
     * String... url declares variable arguments list,
     * and we can get values using indexes: url[0], url[1],...
     * Whenever we consider that we make som progress we can
     * notify through publishProgress()
     */
    @Override
    protected Void doInBackground(String... url) {
        Log.d("PELLODEBUG","URL passed to AsyncTask: " + url[0]);
        //String jsonData ="{'data': {'technologies':[{name : 'Backbone', description : 'JS MVC Framework' , difficulty: 6}, {name : 'Angular', description: 'JS MVC Framework' ,difficulty: 8}, {name : 'CouchDB', description: 'noSQL Database' ,dificultty: 9} ]}, 'responseDetails': null, 'responseStatus': 200} ";
        String jsonData = "";
        try {
            if (webRequest.get(url[0])) {
                Log.d("PELLODEBUG","Code:" + webRequest.getResponseCode() + "\nReceived data: " + webRequest.getResponseString());
                this.parseJson(webRequest.getResponseString());

            } else {
                Log.e("PELLODEBUG","Error in request: " + webRequest.getExceptionMessage());
            }
        } catch (Exception e) {
            Log.d("PELLODEBUG","Exception processing JSON: " + e.getMessage());
        }
        // With this call we notify to progressUpdate
        Log.d("PELLODEBUG","doInBackbround publishes progress");

        // TODO Auto-generated method stub
        return null;
    }

    /**
     * This method is called when we call this.publishProgress
     * and can be used to update contents,progress bars,... in the Activity
     */
    @Override
    protected void onProgressUpdate(String... item) {
        Log.d("PELLODEBUG","onProgressUpdate> json data. Name " + item[0] + " . Desc: " + item[1]);

        //this.mainActivity.getEvents().add(event);
    }

    @Override
    protected void onPostExecute(Void unused) {
        Toast.makeText(this.mainActivity, "Finished Async Task", Toast.LENGTH_SHORT).show();
        Log.d("PELLODEBUG","onPostExecute was called: ");
        //this.mainActivity.getProgressBar1().setVisibility(ProgressBar.INVISIBLE);

    }

    /**
     *
     * @param cadenaJSON
     * @return
     * @throws IllegalStateException
     * @throws IOException
     * @throws JSONException
     * @throws NoSuchAlgorithmException
     */
    public void parseJson (String cadenaJSON) throws IllegalStateException,
            IOException, JSONException, NoSuchAlgorithmException {

        Integer id = 0;
        String name = "";
        String description = "";
        String eventdate = "";
        Integer latitude = 0;
        Integer longitude = 0;

        // and from that object we get the array of data we need
        JSONArray events = new JSONArray(cadenaJSON);

        Log.d("JSON parser> # records:" + events.length(),"PELLODEBUG");

        // and now, for each record we process data.
        for (int i = 0; i < events.length(); i++) {
            Log.d("PELLODEBUG","JSON parser> json record data: " + i + "] " + events.get(i).toString());
            // We get name and description
            Event event = new Event();
            event.setId(events.getJSONObject(i).getInt("id"));
            event.setName(events.getJSONObject(i).getString("name"));
            event.setDescription(events.getJSONObject(i).getString("description"));
            event.setEvent_date(events.getJSONObject(i).getString("event_date"));
            event.setLatitude(events.getJSONObject(i).getInt("latitude"));
            event.setLongitude(events.getJSONObject(i).getInt("longitude"));
            this.mainActivity.getEvents().add(event);

            //this.publishProgress(id, name, description, eventdate, latitude, longitude);

        }

        Log.d("JSON parser> finished","PELLODEBUG");

    }

}
