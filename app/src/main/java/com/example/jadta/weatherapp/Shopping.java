package com.example.jadta.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Shopping extends AppCompatActivity {

    private Button backButtonShop;
    private ImageView rec1PicShop;
    private ImageView rec2PicShop;
    private ImageView rec3PicShop;
    private ImageView rec4PicShop;
    private TextView titleShop;
    private TextView rec1TextShop;
    private TextView rec2TextShop;
    private TextView rec3TextShop;
    private TextView rec4TextShop;
    private TextView messageShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        //Initializing the buttons, ImageViews and TextViews
        backButtonShop=(Button) findViewById(R.id.backButtonShop);
        rec1PicShop=(ImageView) findViewById(R.id.rec1PicShop);
        rec2PicShop=(ImageView) findViewById(R.id.rec2PicShop);
        rec3PicShop=(ImageView) findViewById(R.id.rec3PicShop);
        rec4PicShop=(ImageView) findViewById(R.id.rec4PicShop);
        titleShop=(TextView) findViewById(R.id.titleShop);
        rec1TextShop=(TextView) findViewById(R.id.rec1TextShop);
        rec2TextShop=(TextView) findViewById(R.id.rec2TextShop);
        rec3TextShop=(TextView) findViewById(R.id.rec3TextShop);
        rec4TextShop=(TextView) findViewById(R.id.rec4TextShop);
        messageShop= (TextView) findViewById(R.id.messageShop);

        String currentWeather = MainActivity.getWeatherDescription();

        titleShop.setText("Shopping");

        rec3PicShop.setBackgroundResource(R.drawable.prudentialcenter);
        rec4PicShop.setBackgroundResource(R.drawable.faneuilhall);

        rec3TextShop.setText("Prudential Center\nUrban shopping center featuring over 75 shops and restaurants.");
        rec4TextShop.setText("Faneuil Hall\nShopping center with many stores & restaurants comprising 3 historic market buildings & a promenade");

        //Writes the recommendations and shows the right pictures depending on the weather
        switch(currentWeather){
            case "Clear":{
                messageShop.setText("Be careful not to spend all your money and enjoy good weather while it lasts!");
                rec1PicShop.setBackgroundResource(R.drawable.newbury);
                rec2PicShop.setBackgroundResource(R.drawable.downtowncrossing);
                rec1TextShop.setText("Newbury Street\nBoston's most enchanting street. Eight blocks filled with salons, boutiques, and fabulous dining. It has something for everyone.");
                rec2TextShop.setText("Downtown Crossing\nGreat pedestrian shopping zone, it lies at the intersection of Washington, Winter and Summer streets");
                break;
            }
            case "Clouds":{
                messageShop.setText("Be careful not to spend all your money!");
                rec1PicShop.setBackgroundResource(R.drawable.newbury);
                rec2PicShop.setBackgroundResource(R.drawable.downtowncrossing);
                rec1TextShop.setText("Newbury Street\nBoston's most enchanting street. Eight blocks filled with salons, boutiques, and fabulous dining. It has something for everyone.");
                rec2TextShop.setText("Downtown Crossing\nGreat pedestrian shopping zone, it lies at the intersection of Washington, Winter and Summer streets");
                break;
            }
            case "Wind":{
                messageShop.setText("Be careful not to spend all your money!");
                rec1PicShop.setBackgroundResource(R.drawable.newbury);
                rec2PicShop.setBackgroundResource(R.drawable.downtowncrossing);
                rec1TextShop.setText("Newbury Street\nBoston's most enchanting street. Eight blocks filled with salons, boutiques, and fabulous dining. It has something for everyone.");
                rec2TextShop.setText("Downtown Crossing\nGreat pedestrian shopping zone, it lies at the intersection of Washington, Winter and Summer streets");
                break;
            }
            case "Rain":{
                messageShop.setText("Don't forget your umbrella! If you don't have one, now's your chance!");
                rec1PicShop.setBackgroundResource(R.drawable.cambridgesidegalleria);
                rec2PicShop.setBackgroundResource(R.drawable.copleyplace);
                rec1TextShop.setText("CambridgeSide Galleria\nShopping destination with over 100 stores and restaurants. Its original anchor stores were Sears, Filene's and Lechmere.");
                rec2TextShop.setText("Copley Place\nUpscale shopping mall in the Back Bay section of Boston.");
                break;
            }
            case "Snow":{
                messageShop.setText("Don't forget your umbrella! If you don't have one, now's your chance!");
                rec1PicShop.setBackgroundResource(R.drawable.cambridgesidegalleria);
                rec2PicShop.setBackgroundResource(R.drawable.copleyplace);
                rec1TextShop.setText("CambridgeSide Galleria\nShopping destination with over 100 stores and restaurants. Its original anchor stores were Sears, Filene's and Lechmere.");
                rec2TextShop.setText("Copley Place\nUpscale shopping mall in the Back Bay section of Boston.");
                break;
            }
        }

        backButtonShop.setOnClickListener(new View.OnClickListener() {
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
