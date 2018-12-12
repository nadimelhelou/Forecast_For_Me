package com.example.jadta.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Restaurants extends AppCompatActivity {

    private Button backButtonRes;
    private ImageView rec1PicRes;
    private ImageView rec2PicRes;
    private ImageView rec3PicRes;
    private ImageView rec4PicRes;
    private TextView titleRes;
    private TextView rec1TextRes;
    private TextView rec2TextRes;
    private TextView rec3TextRes;
    private TextView rec4TextRes;
    private TextView messageRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        //Initializing the buttons, ImageViews and TextViews
        backButtonRes=(Button) findViewById(R.id.backButtonRes);
        rec1PicRes=(ImageView) findViewById(R.id.rec1PicRes);
        rec2PicRes=(ImageView) findViewById(R.id.rec2PicRes);
        rec3PicRes=(ImageView) findViewById(R.id.rec3PicRes);
        rec4PicRes=(ImageView) findViewById(R.id.rec4PicRes);
        titleRes=(TextView) findViewById(R.id.titleRes);
        rec1TextRes=(TextView) findViewById(R.id.rec1TextRes);
        rec2TextRes=(TextView) findViewById(R.id.rec2TextRes);
        rec3TextRes=(TextView) findViewById(R.id.rec3TextRes);
        rec4TextRes=(TextView) findViewById(R.id.rec4TextRes);
        messageRes= (TextView) findViewById(R.id.messageRes);

        String currentWeather = MainActivity.getWeatherDescription();

        titleRes.setText("Restaurants");

        //Writes the recommendations and shows the right pictures depending on the weather

        rec1PicRes.setBackgroundResource(R.drawable.newbury);
        rec2PicRes.setBackgroundResource(R.drawable.quincymarket);
        rec3PicRes.setBackgroundResource(R.drawable.allston);
        rec4PicRes.setBackgroundResource(R.drawable.northend);

        rec1TextRes.setText("Newbury Street\nBoston's most enchanting street with a great variety of fabulous restaurants.\nTry Piattini, Stephanie's, or Joe's American Bar and Grill!");
        rec2TextRes.setText("Quincy Market\nA historic market complex near Faneuil Hall that is known for its endless small restaurant options.\nTry Wagamama, Mmmac N' Cheese, or Regina Pizzeria!");
        rec3TextRes.setText("Allston\nA very lively neighborhood packed with great restaurants and bars.\nTry Dumpling Kingdom, Five Guys, or Coreanos!");
        rec4TextRes.setText("North End\nBoston's Little Italy, a maze of narrow streets with some of the city's oldest buildings. It is the home of many famous Italian restaurants.\nTry Giacomo's or Quattro!");

        switch(currentWeather){
            case "Clear":{
                messageRes.setText("Don't forget to walk around and explore these amazing areas and enjoy good weather while it lasts!");
                break;
            }
            case "Clouds":{
                messageRes.setText("Don't forget to walk around and explore these amazing areas!");
                break;
            }
            case "Wind":{
                messageRes.setText("Don't forget to walk around and explore these amazing areas!");
                break;
            }
            case "Rain":{
                messageRes.setText("Pack an umbrella if you plan to explore these amazing areas!");
                break;
            }
            case "Snow":{
                messageRes.setText("Bring out the big coat if you plan to explore these amazing areas!");
                break;
            }
        }

        backButtonRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainPage();
            }
        });
    }
    public void openMainPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
