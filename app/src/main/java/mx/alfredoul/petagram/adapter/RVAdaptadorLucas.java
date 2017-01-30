package mx.alfredoul.petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.alfredoul.petagram.R;
import mx.alfredoul.petagram.pojo.Lucas;
import mx.alfredoul.petagram.pojo.Pet;

/**
 * Created by alfredoul on 18/01/17.
 */

public class RVAdaptadorLucas extends RecyclerView.Adapter<RVAdaptadorLucas.LucasViewHolder> {

    ArrayList<Lucas> pets;
    Activity activity;

    public RVAdaptadorLucas(ArrayList<Lucas> pets, Activity activity) {
        this.pets  = pets;
        this.activity   = activity;
    }

    @Override
    public LucasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new LucasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LucasViewHolder personViewHolder, int i) {
        personViewHolder.petRate.setText(pets.get(i).getRate());
        personViewHolder.petPhoto.setImageResource(pets.get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class LucasViewHolder extends RecyclerView.ViewHolder {
        TextView petRate;
        ImageView petPhoto;

        LucasViewHolder(View itemView) {
            super(itemView);
            petRate = (TextView)itemView.findViewById(R.id.tvRateL);
            petPhoto = (ImageView)itemView.findViewById(R.id.ivLucas);
        }
    }
}