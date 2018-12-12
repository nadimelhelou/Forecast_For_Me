package com.example.jadta.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Tourism extends AppCompatActivity {

    private Button backButtonTour;
    private ImageView rec1PicTour;
    private ImageView rec2PicTour;
    private ImageView rec3PicTour;
    private ImageView rec4PicTour;
    private TextView titleTour;
    private TextView rec1TextTour;
    private TextView rec2TextTour;
    private TextView rec3TextTour;
    private TextView rec4TextTour;
    private TextView messageTour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism);

        //Initializing the buttons, ImageViews and TextViews
        backButtonTour=(Button) findViewById(R.id.backButtonTour);
        rec1PicTour=(ImageView) findViewById(R.id.rec1PicTour);
        rec2PicTour=(ImageView) findViewById(R.id.rec2PicTour);
        rec3PicTour=(ImageView) findViewById(R.id.rec3PicTour);
        rec4PicTour=(ImageView) findViewById(R.id.rec4PicTour);
        titleTour=(TextView) findViewById(R.id.titleTour);
        rec1TextTour=(TextView) findViewById(R.id.rec1TextTour);
        rec2TextTour=(TextView) findViewById(R.id.rec2TextTour);
        rec3TextTour=(TextView) findViewById(R.id.rec3TextTour);
        rec4TextTour=(TextView) findViewById(R.id.rec4TextTour);
        messageTour= (TextView) findViewById(R.id.messageTour);

        String currentWeather = MainActivity.getWeatherDescription();

        titleTour.setText("Tourism");


        //Writes the recommendations and shows the right pictures depending on the weather
        switch(currentWeather){
            case "Clear":{
                rec1PicTour.setBackgroundResource(R.drawable.beaconhill);
                rec2PicTour.setBackgroundResource(R.drawable.bunkerhill);
                rec3PicTour.setBackgroundResource(R.drawable.freedomtrail);
                rec4PicTour.setBackgroundResource(R.drawable.bostoncommon);
                rec1TextTour.setText("Beacon Hill\nA historic neighborhood in Boston upon which the Massachusetts State House resides.\nCheck out the rowhouses and narrow gaslit streets!");
                rec2TextTour.setText("Bunker Hill\nThe Bunker Hill Monument was erected to commemorate the Battle of Bunker Hill.\nThe monument is a 221-foot granite obelisk!");
                rec3TextTour.setText("Freedom Trail\nThe Freedom Trail passes by 16 locations significant to the history of the United States.\nFollow the brick path and special markers!");
                rec4TextTour.setText("Boston Common\nA central public park in downtown Boston that is the oldest city park in the United States.\nThe Common is part of the Emerald Necklace, a chain of beautiful parks!");
                messageTour.setText("Don't forget to walk around and explore these amazing areas and enjoy the weather while it lasts!");
                break;
            }
            case "Clouds":{
                rec1PicTour.setBackgroundResource(R.drawable.beaconhill);
                rec2PicTour.setBackgroundResource(R.drawable.bunkerhill);
                rec3PicTour.setBackgroundResource(R.drawable.freedomtrail);
                rec4PicTour.setBackgroundResource(R.drawable.bostoncommon);
                rec1TextTour.setText("Beacon Hill\nA historic neighborhood in Boston upon which the Massachusetts State House resides.\nCheck out the rowhouses and narrow gaslit streets!");
                rec2TextTour.setText("Bunker Hill\nThe Bunker Hill Monument was erected to commemorate the Battle of Bunker Hill.\nThe monument is a 221-foot granite obelisk!");
                rec3TextTour.setText("Freedom Trail\nThe Freedom Trail passes by 16 locations significant to the history of the United States.\nFollow the brick path and special markers!");
                rec4TextTour.setText("Boston Common\nA central public park in downtown Boston that is the oldest city park in the United States.\nThe Common is part of the Emerald Necklace, a chain of beautiful parks!");
                messageTour.setText("Don't forget to walk around and explore these amazing areas!");
                break;
            }
            case "Wind":{
                rec1PicTour.setBackgroundResource(R.drawable.mfa);
                rec2PicTour.setBackgroundResource(R.drawable.ica);
                rec3PicTour.setBackgroundResource(R.drawable.aquarium);
                rec4PicTour.setBackgroundResource(R.drawable.science);
                rec1TextTour.setText("Museum of Fine Arts\nThe fifth largest museum in the United States.\nIt is one of the most comprehensive art collections in America!");
                rec2TextTour.setText("The Institute of Contemporary Art\nAn art museum and exhibition space founded in 1936 with a mission to exhibit contemporary art.\nTry one of the interactive exhibits!");
                rec3TextTour.setText("New England Aquarium\nOne of the premier visitor attractions in Boston and an amazing aquarium.\nTry the Simons IMAX theatre or the New England Aquarium Whale Watch!");
                rec4TextTour.setText("Museum of Science\nA science museum and indoor zoo located in Science Park.\nTry over 700 interactive exhibits and attend various live presentations.");
                messageTour.setText("Stay inside and visit an exciting exhibition!");
                break;
            }
            case "Rain":{
                rec1PicTour.setBackgroundResource(R.drawable.mfa);
                rec2PicTour.setBackgroundResource(R.drawable.ica);
                rec3PicTour.setBackgroundResource(R.drawable.aquarium);
                rec4PicTour.setBackgroundResource(R.drawable.science);
                rec1TextTour.setText("Museum of Fine Arts\nThe fifth largest museum in the United States.\nIt is one of the most comprehensive art collections in America!");
                rec2TextTour.setText("The Institute of Contemporary Art\nAn art museum and exhibition space founded in 1936 with a mission to exhibit contemporary art.\nTry one of the interactive exhibits!");
                rec3TextTour.setText("New England Aquarium\nOne of the premier visitor attractions in Boston and an amazing aquarium.\nTry the Simons IMAX theatre or the New England Aquarium Whale Watch!");
                rec4TextTour.setText("Museum of Science\nA science museum and indoor zoo located in Science Park.\nTry over 700 interactive exhibits and attend various live presentations.");
                messageTour.setText("Stay inside and visit an exciting exhibition!");
                break;
            }
            case "Snow":{
                rec1PicTour.setBackgroundResource(R.drawable.mfa);
                rec2PicTour.setBackgroundResource(R.drawable.ica);
                rec3PicTour.setBackgroundResource(R.drawable.aquarium);
                rec4PicTour.setBackgroundResource(R.drawable.science);
                rec1TextTour.setText("Museum of Fine Arts\nThe fifth largest museum in the United States.\nIt is one of the most comprehensive art collections in America!");
                rec2TextTour.setText("The Institute of Contemporary Art\nAn art museum and exhibition space founded in 1936 with a mission to exhibit contemporary art.\nTry one of the interactive exhibits!");
                rec3TextTour.setText("New England Aquarium\nOne of the premier visitor attractions in Boston and an amazing aquarium.\nTry the Simons IMAX theatre or the New England Aquarium Whale Watch!");
                rec4TextTour.setText("Museum of Science\nA science museum and indoor zoo located in Science Park.\nTry over 700 interactive exhibits and attend various live presentations.");
                messageTour.setText("Stay inside and visit an exciting exhibition!");
                break;
            }
        }

        backButtonTour.setOnClickListener(new View.OnClickListener() {
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
