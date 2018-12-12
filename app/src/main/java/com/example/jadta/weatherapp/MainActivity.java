package com.example.jadta.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    static String weatherDescription;
    private long mLastClickTime = 0;

    static String getWeatherDescription(){
        return weatherDescription;
    }

    static void setWeatherDescription(String input){
        weatherDescription = input;
    }

    static TextView tempTextView;
    static TextView weatherTextView;
    static ImageView backgroundImageView;
    private Button buttonRestaurants;
    private Button buttonShopping;
    private Button buttonActivities;
    private Button buttonTourism;


    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backgroundImageView= (ImageView) findViewById(R.id.background1);
        buttonRestaurants = (Button) findViewById(R.id.buttonRestaurants);
        buttonShopping= (Button) findViewById(R.id.buttonShopping);
        buttonActivities= (Button) findViewById(R.id.buttonActivities);
        buttonTourism= (Button) findViewById(R.id.buttonTourism);

        buttonTourism.setEnabled(true);
        buttonActivities.setEnabled(true);
        buttonRestaurants.setEnabled(true);
        buttonShopping.setEnabled(true);


        //Setting OnClickListeners for all buttons (and preventing multiple consecutive clicks)
        buttonRestaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 3000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                if (download.getTemp()<=-15)
                    openStayHome();
                else
                    openRestaurants();
            }
        });

        buttonShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 3000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                if (download.getTemp()<=-15)
                    openStayHome();
                else
                    openShopping();
            }
        });

        buttonActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 3000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                if (download.getTemp()<=-15)
                    openStayHome();
                else
                    openActivities();
            }
        });

        buttonTourism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 3000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                if (download.getTemp()<=-15)
                    openStayHome();
                else
                    openTourism();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        tempTextView = findViewById(R.id.tempTextView);
        weatherTextView = findViewById(R.id.weatherTextView);

        download download = new download();
        download.execute("http://api.openweathermap.org/data/2.5/weather?lat=42.355&lon=-71.059&appid=c2a7ba0de3afc0bcd21e6a0df7e2b05d");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();



    public void openRestaurants(){
        //Opens the Restaurants page
        Intent intent = new Intent(this, Restaurants.class);
        startActivity(intent);
    }

    public void openShopping(){
        //Opens the Shopping page
        Intent intent = new Intent(this, Shopping.class);
        startActivity(intent);
    }

    public void openActivities(){
        //Opens the Activities page
        Intent intent = new Intent(this, Activities.class);
        startActivity(intent);
    }

    public void openTourism(){
        //Opens tbe Tourism page
        Intent intent = new Intent(this, Tourism.class);
        startActivity(intent);
    }

    public void openStayHome(){
        //Opens the activity that says "stay at home"
        Intent intent = new Intent(this, StayHome.class);
        startActivity(intent);
    }

}