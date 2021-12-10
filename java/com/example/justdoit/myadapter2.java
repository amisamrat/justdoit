package com.example.justdoit;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class myadapter2 extends RecyclerView.Adapter<myadapter2.Viewholder2> {

    private Context context;
    private ArrayList<gsconstructor> con2;

    // constructor for adapter
    public myadapter2(Context context, ArrayList<gsconstructor> con2) {
        this.context = context;
        this.con2 = con2;
    }


    @NonNull
    @Override
    public myadapter2.Viewholder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view
        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview2, parent, false);
        return new Viewholder2(view2);
    }

    @Override
    public void onBindViewHolder(@NonNull myadapter2.Viewholder2 a2, @SuppressLint("RecyclerView") int p2) {
        // to set data to textview and imageview of each card layout
        final gsconstructor gs2 = con2.get(p2);
        a2.des2.setText(gs2.getdes());
        a2.image2.setImageResource(gs2.getimage());


    }

    @Override
    public int getItemCount() {
        //for showing number of card items in recycler view
        return con2.size();
    }

    //references of cardview elements
    public class Viewholder2 extends RecyclerView.ViewHolder {
        private ImageView image2;
        private TextView des2;
        private RelativeLayout rl2;
        public Viewholder2(@NonNull View i2) {
            super(i2);
            image2 = i2.findViewById(R.id.image);
            des2 = i2.findViewById(R.id.des);
            rl2=i2.findViewById(R.id.rl);
            i2.setClickable(true);
        }

    }
}
