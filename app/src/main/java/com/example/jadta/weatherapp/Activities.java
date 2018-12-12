package com.example.jadta.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activities extends AppCompatActivity {

    private Button backButtonAct;
    private ImageView rec1PicAct;
    private ImageView rec2PicAct;
    private ImageView rec3PicAct;
    private ImageView rec4PicAct;
    private TextView titleAct;
    private TextView rec1TextAct;
    private TextView rec2TextAct;
    private TextView rec3TextAct;
    private TextView rec4TextAct;
    private TextView messageAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);

        //Initializing the buttons, ImageViews and TextViews
        backButtonAct = (Button) findViewById(R.id.backButtonAct);
        rec1PicAct = (ImageView) findViewById(R.id.rec1PicAct);
        rec2PicAct = (ImageView) findViewById(R.id.rec2PicAct);
        rec3PicAct = (ImageView) findViewById(R.id.rec3PicAct);
        rec4PicAct = (ImageView) findViewById(R.id.rec4PicAct);
        titleAct = (TextView) findViewById(R.id.titleAct);
        rec1TextAct = (TextView) findViewById(R.id.rec1TextAct);
        rec2TextAct = (TextView) findViewById(R.id.rec2TextAct);
        rec3TextAct = (TextView) findViewById(R.id.rec3TextAct);
        rec4TextAct = (TextView) findViewById(R.id.rec4TextAct);
        messageAct = (TextView) findViewById(R.id.messageAct);

        String currentWeather = MainActivity.getWeatherDescription();

        titleAct.setText("Activities");


        //Writes the recommendations and shows the right pictures depending on the weather
        switch (currentWeather) {
            case "Clear": {
                messageAct.setText("Don't forget to walk around and explore these amazing areas and enjoy good weather while it lasts!");
                rec1PicAct.setBackgroundResource(R.drawable.bpl);
                rec2PicAct.setBackgroundResource(R.drawable.charles);
                rec3PicAct.setBackgroundResource(R.drawable.esplanade);
                rec4PicAct.setBackgroundResource(R.drawable.frogpond);

                rec1TextAct.setText("Boston Public Library Couryard\nBeautiful courtyard inside the library building. Perfect for studying, working or some coffee.");
                rec2TextAct.setText("Rowing on the Charles\nRent a boat and row with a beautiful view of Boston's Skyline.");
                rec3TextAct.setText("Charles River Esplanade\nGreat for exercising, relaxing or reading a book.");
                rec4TextAct.setText("Frog Pond\nBeautiful outdoor ice skating rink in the Boston Common.");

                break;
            }
            case "Clouds": {
                messageAct.setText("Don't forget to walk around and explore these amazing areas!");
                rec1PicAct.setBackgroundResource(R.drawable.bpl);
                rec2PicAct.setBackgroundResource(R.drawable.charles);
                rec3PicAct.setBackgroundResource(R.drawable.esplanade);
                rec4PicAct.setBackgroundResource(R.drawable.frogpond);

                rec1TextAct.setText("Boston Public Library Couryard\nBeautiful courtyard inside the library building. Perfect for studying, working or some coffee.");
                rec2TextAct.setText("Rowing on the Charles\nRent a boat and row with a beautiful view of Boston's Skyline.");
                rec3TextAct.setText("Charles River Esplanade\nGreat for exercising, relaxing or reading a book.");
                rec4TextAct.setText("Frog Pond\nBeautiful outdoor ice skating rink in the Boston Common.");

                break;
            }
            case "Wind": {
                messageAct.setText("Don't forget to walk around and explore these amazing areas!");
                rec1PicAct.setBackgroundResource(R.drawable.bpl);
                rec2PicAct.setBackgroundResource(R.drawable.charles);
                rec3PicAct.setBackgroundResource(R.drawable.esplanade);
                rec4PicAct.setBackgroundResource(R.drawable.frogpond);

                rec1TextAct.setText("Boston Public Library Couryard\nBeautiful courtyard inside the library building. Perfect for studying, working or some coffee.");
                rec2TextAct.setText("Rowing on the Charles\nRent a boat and row with a beautiful view of Boston's Skyline.");
                rec3TextAct.setText("Charles River Esplanade\nGreat for exercising, relaxing or reading a book.");
                rec4TextAct.setText("Frog Pond\nBeautiful outdoor ice skating rink in the Boston Common.");

                break;
            }
            case "Rain": {
                messageAct.setText("Pack an umbrella if you plan to explore these amazing areas!");
                rec1PicAct.setBackgroundResource(R.drawable.sledding);
                rec2PicAct.setBackgroundResource(R.drawable.theatre);
                rec3PicAct.setBackgroundResource(R.drawable.bowling);
                rec4PicAct.setBackgroundResource(R.drawable.walter);

                rec1TextAct.setText("Boston Common\nIf there's enough snow, go sledding on the hills in Boston Common.");
                rec2TextAct.setText("AMC Boston Common\nEnjoy some popcorn and a movie at these theaters when the weather isn't enjoyable.");
                rec3TextAct.setText("King's Bowling\nBowl or play some pool to forget about the bad weather.");
                rec4TextAct.setText("Walter Brown Arena\nGreat to ice skate when outdoor rinks aren't suitable!");
                break;
            }
            case "Snow": {
                messageAct.setText("Bring out the big coat if you plan to explore these amazing areas!");
                rec1PicAct.setBackgroundResource(R.drawable.sledding);
                rec2PicAct.setBackgroundResource(R.drawable.theatre);
                rec3PicAct.setBackgroundResource(R.drawable.bowling);
                rec4PicAct.setBackgroundResource(R.drawable.walter);

                rec1TextAct.setText("Boston Common\nIf there's enough snow, go sledding on the hills in Boston Common.");
                rec2TextAct.setText("AMC Boston Common\nEnjoy some popcorn and a movie at these theaters when the weather isn't enjoyable.");
                rec3TextAct.setText("King's Bowling\nBowl or play some pool to forget about the bad weather.");
                rec4TextAct.setText("Walter Brown Arena\nGreat to ice skate when outdoor rinks aren't suitable!");
                break;
            }
        }
        backButtonAct.setOnClickListener(new View.OnClickListener() {
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
