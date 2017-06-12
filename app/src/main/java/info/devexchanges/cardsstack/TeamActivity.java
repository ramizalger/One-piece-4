package info.devexchanges.cardsstack;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static android.media.CamcorderProfile.get;
import static info.devexchanges.cardsstack.CardsAdapter.decodeSampledBitmapFromResource;

public class TeamActivity extends AppCompatActivity {

   // private List equip = new LinkedList();
    private final String EXTRA_NOM ="";
    private String recup ="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

      //  final TextView text = (TextView)findViewById(R.id.text);
        final ImageView img = (ImageView)findViewById(R.id.imageEquipage) ;


        ArrayList<CardItem> equipage = (ArrayList<CardItem>) getIntent().getSerializableExtra("my list");


     //   if(equipage.size()!=0)
      //  text.setText(equipage.get(0).getDrawableId());
            img.setImageBitmap(decodeSampledBitmapFromResource(this.getResources(),equipage.get(0).getDrawableId(),261,155));


            //text.setText("Aucun Membre ajouté");








      //  for (int i=0; i<equip.size(); i++);
    }
}
