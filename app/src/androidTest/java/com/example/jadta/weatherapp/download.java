package com.example.jadta.weatherapp;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class download extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {

        String result = "";
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL(urls[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int data = reader.read();

            while (data != -1){
                char current = (char) data;
                result += current;
                data = reader.read();
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject weatherInfo = new JSONObject(jsonObject.getString("main"));
            double temperature = Double.parseDouble(weatherInfo.getString("temp"));
            int tempInteger = (int) (temperature*1.8-459.67);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
