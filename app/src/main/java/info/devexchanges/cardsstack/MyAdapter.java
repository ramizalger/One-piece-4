package info.devexchanges.cardsstack;


import android.content.Context;

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


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







    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView versionName;
        private ImageView   imageName;

        private  final Context context ;






        public MyViewHolder(final View itemView){

            super(itemView);
            context = itemView.getContext();



            versionName = (TextView) itemView.findViewById(R.id.textViewEquipage);
            imageName = (ImageView) itemView.findViewById(R.id.img);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override


                public void onClick(View view) {


                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle("Le membre suivant :")
                            .setMessage(versionName.getText() + " est dans votre équipage !")
                            .show();





                }
            });



        }





    }









}
