package com.android.sachin.rxjava;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.StreamHandler;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sachin on 3/12/16.
 */

public class Loader2 /*extends AsyncTask<Void,Void,Void>*/{



    public static String json="";
    public String url="";
    public List<String> list;
    /*@Override
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

        Log.e("on_post2",json);

    }*/

    public void performOperation2() {



        list = Arrays.asList("http://api.geonames.org/citiesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&lang=de&username=demo");
       // Observable<List<String>> listObservable = Observable.just(list);

        /*JSONParserHttpURL jsonParser = new JSONParserHttpURL();
        for(int i=0; i<list.size();i++)
            url = list.get(i);
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
*/
        getResponse()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {

            @Override
            public void onCompleted() {
                Log.e("on_completed", json);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("on_error", e.toString());
            }

            @Override
            public void onNext(String list) {
                Log.e("on_next", json);

            }
        });
    }


    public Observable<String> getResponse(){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                    JSONParserHttpURL jsonParser = new JSONParserHttpURL();
                    for(int i=0; i<list.size();i++)
                        url = list.get(i);
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

                     subscriber.onNext(json);
                     subscriber.onCompleted();

            }
        });
    }
}
