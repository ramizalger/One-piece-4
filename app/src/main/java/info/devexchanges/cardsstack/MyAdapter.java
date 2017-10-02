package info.devexchanges.cardsstack;


import android.content.Context;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static info.devexchanges.cardsstack.R.id.recyclerView;


/**
 * Created by Thomas on 09/06/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>    {

    private ArrayList<String> data ;
    private ArrayList<Integer>dataint;
    private int recyclerItemRes;
    private Context context;


    public MyAdapter(Context context, int recyclerItemRes, ArrayList<String> data,ArrayList<Integer> dataint)
    {
        this.recyclerItemRes = recyclerItemRes;
        this.data = data;
        this.context=context;
        this.dataint = dataint;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){


        View view = LayoutInflater.from(parent.getContext()).inflate(recyclerItemRes,parent,false);

        MyViewHolder vh = new MyViewHolder(view);

        return vh;


    }





    public void onBindViewHolder(MyViewHolder holder, int position){

        holder.versionName.setText(data.get(position));
        holder.imageName.setImageResource(dataint.get(position));


    }



    @Override
    public int getItemCount(){

        if(data!=null){

            return data.size();

        }




        return 0;
    }






    public void removeAt(int position) {
        data.remove(position);
        dataint.remove(position);
        notifyItemRemoved(position);
    }





    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView versionName;
        private ImageView   imageName;
        private Button vire ;

        private  final Context context ;






        public MyViewHolder(final View itemView){
            super(itemView);



            context = itemView.getContext();



            versionName = (TextView) itemView.findViewById(R.id.textViewEquipage);
            imageName = (ImageView) itemView.findViewById(R.id.img);
            vire = (Button) itemView.findViewById(R.id.cancel);







            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle("Le membre suivant :")
                            .setMessage(versionName.getText() + " est dans votre équipage !")
                            .show();



                }
            });



            vire.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setMessage("Voulez-vous virer : " + data.get(getAdapterPosition()).toString() + "?").setCancelable(false
                    ).setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            removeAt(getAdapterPosition());
                            dialog.cancel();
                        }


                    }).setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    builder.create().show();


                }
            });












        }





    }









}
