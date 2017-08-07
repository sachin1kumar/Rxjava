package com.android.sachin.rxjava;

import android.os.AsyncTask;
import android.util.Log;

import com.google.firebase.perf.metrics.AddTrace;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sachin on 3/12/16.
 */

public class Loader1 extends AsyncTask<Void,Void,Void> {

    public static String json="";
    @Override
    @AddTrace(name="AsyncTask",enabled = true)
    protected Void doInBackground(Void... params) {

        getJson();

        return null;
    }


    private static String getJson() {


        JSONParserHttpURL jsonParser = new JSONParserHttpURL();
        String url = "http://api.geonames.org/citiesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&lang=de&username=demo";
        //http://api.geonames.org/citiesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&lang=de&username=demo
        List<NameValuePair> param = new ArrayList<>();
        param.add(new BasicNameValuePair("north", "44"));
        param.add(new BasicNameValuePair("south", "-9.9"));
        param.add(new BasicNameValuePair("east","-22"));
        param.add(new BasicNameValuePair("west", "55.2"));
        param.add(new BasicNameValuePair("lang", "de"));
        param.add(new BasicNameValuePair("username", "demo"));
        JSONObject jsonObject= jsonParser.makeHttpRequest(url, "POST", param);

        json = jsonObject.toString();
        return json;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        Log.e("on_post1",json);

    }
}
