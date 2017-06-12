package info.devexchanges.cardsstack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import link.fls.swipestack.SwipeStack;

public class MainActivity extends AppCompatActivity {

    private SwipeStack cardStack;
    private CardsAdapter cardsAdapter;
    private ArrayList<CardItem> cardItems;
    private View btnCancel;
    private View btnLove;
    private int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardStack = (SwipeStack) findViewById(R.id.container);
        btnCancel = findViewById(R.id.cancel);
        btnLove = findViewById(R.id.love);

        setCardStackAdapter();
        currentPosition = 0;

        //Handling swipe event of Cards stack
        cardStack.setListener(new SwipeStack.SwipeStackListener() {
            @Override
            public void onViewSwipedToLeft(int position) {
                currentPosition = position + 1;
            }

            @Override
            public void onViewSwipedToRight(int position) {
                currentPosition = position + 1;
            }

            @Override
            public void onStackEmpty() {

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, cardItems.get(currentPosition).getName() + " va niker sa mère ",
                        Toast.LENGTH_SHORT).show();
                cardStack.swipeTopViewToLeft();
                cardStack.swipeTopViewToRight();

            }
        });

        btnLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, cardItems.get(currentPosition).getName() + " fait parti de l'équipage ",
                        Toast.LENGTH_SHORT).show();
                cardStack.swipeTopViewToLeft();
            }
        });
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