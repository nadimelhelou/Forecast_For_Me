package com.example.jadta.weatherapp;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class download extends AsyncTask<String, Void, String> {
    String result;
    static int temperatureincelsius;
    public static int getTemp(){
        return temperatureincelsius;
    }

    @Override
    protected String doInBackground(String... urls) {

        //Getting the JSON object from the API and returning it as a string
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?lat=42.355&lon=-71.059&appid=c2a7ba0de3afc0bcd21e6a0df7e2b05d");
            try {
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                result = stringBuilder.toString();
                return result;
            }
            catch (Exception e) {
                Log.e("MYAPP","error1",e);
            }
        } catch (Exception e) {
            Log.e("MYAPP","error2",e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        //Reading the string containing the JSON object and getting the temperature and the weather condition
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject temperatureInfo = new JSONObject(jsonObject.getString("main"));
            JSONArray weatherInfo = new JSONArray(jsonObject.getString("weather"));

            double temperature = Double.parseDouble(temperatureInfo.getString("temp"));
            JSONObject weatherinf = weatherInfo.getJSONObject(0);
            String weather = weatherinf.getString("main");

            int tempInteger = (int) (temperature*1.8-459.67);
            int tempIntegerCelsius = (int) (temperature-273.15);
            temperatureincelsius = tempIntegerCelsius;

            //Writing the temperature and the weather condition to the 2 TextViews in the main activity
            MainActivity.tempTextView.setText(String.valueOf(tempInteger)+"°F / "+String.valueOf(tempIntegerCelsius)+"°C");

            if (weather == "Drizzle" || weather == "Thunderstorm")
                weather = "Rain";
            if (weather == "Atmosphere")
                weather = "Wind";

            MainActivity.weatherTextView.setText(weather);
            MainActivity.setWeatherDescription(weather);

            //Setting the background image of the main activity depending on the weather condition
            switch(weather) {
                case "Clouds" :
                    MainActivity.backgroundImageView.setBackgroundResource(R.drawable.cloudy);
                    break;

                case "Rain" :
                    MainActivity.backgroundImageView.setBackgroundResource(R.drawable.rainy);
                    break;

                case "Clear" :
                    MainActivity.backgroundImageView.setBackgroundResource(R.drawable.clear);
                    break;

                case "Snow" :
                    MainActivity.backgroundImageView.setBackgroundResource(R.drawable.snowy);
                    break;

                case "Wind" :
                    MainActivity.backgroundImageView.setBackgroundResource(R.drawable.windy);
                    break;
            }

        } catch (Exception e) {
            Log.e("MYAPP","error3",e);
        }

    }
}
