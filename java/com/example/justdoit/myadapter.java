package com.example.justdoit;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.Viewholder> {

    private Context context;
    private ArrayList<gsconstructor> con;

    // constructor for adapter
    public myadapter(Context context, ArrayList<gsconstructor> con) {
        this.context = context;
        this.con = con;
    }


    @NonNull
    @Override
    public myadapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myadapter.Viewholder a, @SuppressLint("RecyclerView") int p) {
        // to set data to textview and imageview of each card layout
        final gsconstructor gs = con.get(p);
        a.des.setText(gs.getdes());
        a.image.setImageResource(gs.getimage());
        //clickevent on items
        a.rl.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent ii = new Intent(context.getApplicationContext(),datadisplay.class);
                ii.putExtra("imgid",gs.getimage());
                ii.putExtra("desc",gs.getdes());
                context.startActivity(ii);
                return false;
            }
        });
        a.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p==0){
                    Intent itt=new Intent(context.getApplicationContext(),tts.class);
                    context.startActivity(itt);

                }
                if (p==1){
                    Intent itt=new Intent(context.getApplicationContext(),highlight.class);
                    context.startActivity(itt);

                }
                if (p==3){
                    Intent it=new Intent(context.getApplicationContext(),newstab.class);
                    context.startActivity(it);

                }
                if (p==5){
                    Intent itt=new Intent(context.getApplicationContext(),deviceinfo.class);
                    context.startActivity(itt);

                }
                else{
                    Toast.makeText(context.getApplicationContext(),"loading the "+gs.getdes(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        //for showing number of card items in recycler view
        return con.size();
    }

    //references of cardview elements
    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView des;
        private RelativeLayout rl;
        public Viewholder(@NonNull View i) {
            super(i);
            image = i.findViewById(R.id.image);
            des = i.findViewById(R.id.des);
            rl=i.findViewById(R.id.rl);
            i.setClickable(true);
        }

    }
}


