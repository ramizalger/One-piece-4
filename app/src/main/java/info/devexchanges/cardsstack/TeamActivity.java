package info.devexchanges.cardsstack;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
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



    private MyAdapter adapter;
    private RecyclerView recyclerView;
    private TextView noneMembre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        setTitle("Mon Equipage");


       noneMembre=(TextView)findViewById(R.id.noneMembre) ;


       ArrayList<Integer> equipage = (ArrayList<Integer>) getIntent().getSerializableExtra("my list");


        ArrayList<String> nom_equipage = getIntent().getStringArrayListExtra("my list name");









        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MyAdapter(this,R.layout.cellules,nom_equipage,equipage);
        recyclerView.setAdapter(adapter);




        if(nom_equipage.size()==0)
            noneMembre.setText("Aucun membre dans l'équipage");


        else
        {
            noneMembre.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

        }






    }







    }



























