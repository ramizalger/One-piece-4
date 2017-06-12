package info.devexchanges.cardsstack;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static android.media.CamcorderProfile.get;
import static info.devexchanges.cardsstack.CardsAdapter.decodeSampledBitmapFromResource;

public class TeamActivity extends AppCompatActivity {

    private List equip = new LinkedList();
    private final String EXTRA_NOM ="";
    private String recup ="";
    private ImageView img ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        setTitle("Mon Equipage");


        img=(ImageView) findViewById(R.id.imageView) ;


        ArrayList<Integer> equipage = (ArrayList<Integer>) getIntent().getSerializableExtra("my list");

      //  ArrayList<String> nom_equipage = (ArrayList<String>)getIntent().getStringArrayListExtra("my list name");


        if(equipage.size()!=0)
            img.setImageResource(equipage.get(0));

      //  text.setText(equipage.get(0).getDrawableId());




           // text.setText("Aucun Membre ajouté");








      //  for (int i=0; i<equip.size(); i++);
    }







    }



























