package info.devexchanges.cardsstack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import link.fls.swipestack.SwipeStack;

public class MainActivity extends AppCompatActivity {

    private SwipeStack cardStack;
    private CardsAdapter cardsAdapter;
    private ArrayList<CardItem> cardItems;
    private View btnCancel;
    private View btnLove;
    private int currentPosition;


   private ArrayList<Integer> equipage = new ArrayList<>();
     private ArrayList<String> nom_equipage = new ArrayList<>();
    private final List EXTRA_NOM = new LinkedList();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        cardStack = (SwipeStack) findViewById(R.id.container);
        btnCancel = findViewById(R.id.cancel);
        btnLove = findViewById(R.id.bateau);
        Button myButton = (Button) findViewById(R.id.button);





        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                goToNextActivity();

            }

        });









        setCardStackAdapter();
        currentPosition = 0;

        //Handling swipe event of Cards stack
        cardStack.setListener(new SwipeStack.SwipeStackListener() {
            @Override
            public void onViewSwipedToLeft(int position) {

                Toast.makeText(MainActivity.this, cardItems.get(currentPosition).getName() + " va niker sa mère ",
                        Toast.LENGTH_SHORT).show();
                currentPosition = position + 1;
                cardStack.swipeTopViewToLeft();

            }

            @Override
            public void onViewSwipedToRight(int position) {

                Toast.makeText(MainActivity.this, cardItems.get(currentPosition).getName() + " fait parti de l'équipage ",
                        Toast.LENGTH_SHORT).show();

                equipage.add(cardItems.get(currentPosition).getDrawableId());
                nom_equipage.add(cardItems.get(currentPosition).getName());




                currentPosition = position + 1;

              //  cardStack.swipeTopViewToLeft();

                cardStack.swipeTopViewToRight();


            }

            @Override
            public void onStackEmpty() {

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cardStack.swipeTopViewToLeft();


            }
        });

        btnLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cardStack.swipeTopViewToRight();
            }
        });
    }






    private void goToNextActivity() {

        Intent intentt = new Intent(MainActivity.this, TeamActivity.class);
        intentt.putExtra("my list name",nom_equipage);
        intentt.putExtra("my list", equipage);

       startActivity(intentt);


    }








    private void setCardStackAdapter() {
        cardItems = new ArrayList<>();

        cardItems.add(new CardItem(R.drawable.a, "Arlong", "Nez Pointu"));
        cardItems.add(new CardItem(R.drawable.f, "Daddy Materson", "Barbu"));
        cardItems.add(new CardItem(R.drawable.g, "Don Krieg", "Défoncé"));
        cardItems.add(new CardItem(R.drawable.e, "Coby", "L'enfant"));
        cardItems.add(new CardItem(R.drawable.c, "Smoker", "La fumée"));
        cardItems.add(new CardItem(R.drawable.d, "Carmen", "Cheveux Rouge"));
        cardItems.add(new CardItem(R.drawable.b, "Baggy", "Le Clown"));
        cardItems.add(new CardItem(R.drawable.i, "Mihawk", "Le Samourai"));
        cardItems.add(new CardItem(R.drawable.h, "Erik", "Beau Gosse"));
        cardItems.add(new CardItem(R.drawable.j, "Kaya", "La Blonde"));
        cardItems.add(new CardItem(R.drawable.k, "Kuro", "En costar"));
        cardItems.add(new CardItem(R.drawable.l, "Luffy", "Le Capitaine"));
        cardItems.add(new CardItem(R.drawable.m, "Morgane", "Sans Main"));
        cardItems.add(new CardItem(R.drawable.n, "Nami", "La Bonnasse"));
        cardItems.add(new CardItem(R.drawable.o, "Nojiko", "L'Inconnue"));
        cardItems.add(new CardItem(R.drawable.p, "Ace", "L'Incontournable"));
        cardItems.add(new CardItem(R.drawable.q, "Zorro", "Sans Pitié"));
        cardItems.add(new CardItem(R.drawable.r, "Sanji", "Le Cuisto"));
        cardItems.add(new CardItem(R.drawable.s, "Shanks", "L'Eternel"));
        cardItems.add(new CardItem(R.drawable.t, "Tashigi", "L'inconnue 2"));
        cardItems.add(new CardItem(R.drawable.u, "Chopper", "Le Mignon"));
        cardItems.add(new CardItem(R.drawable.v, "Usop", "Le peureux"));
        cardItems.add(new CardItem(R.drawable.w, "Yasopp", "Le père"));
        cardItems.add(new CardItem(R.drawable.x, "Zeff", "Le Chef Etoilé"));

        cardsAdapter = new CardsAdapter(this, cardItems);
        cardStack.setAdapter(cardsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.reset) {
            cardStack.resetStack();
            currentPosition = 0;
        }
        return super.onOptionsItemSelected(item);
    }
}
