package info.devexchanges.cardsstack;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 12/06/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private int recyclerItemRes;
    private String[] data;
    private Context context;

    public RecyclerViewAdapter(Context context, int recyclerItemRes, String[] data) {

        this.recyclerItemRes = recyclerItemRes;
        this.data = data;
        this.context = context;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(recyclerItemRes, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;

    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.versionName.setText(data[position]);
    }




    @Override
    public int getItemCount() {

        if (data != null)
            return data.length;

        return 0;

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView versionName;

        public ViewHolder(View itemView) {

            super(itemView);

            versionName = (TextView) itemView.findViewById(R.id.textView23);

        }


    }
}