package mx.alfredoul.petagram;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alfredoul on 18/01/17.
 */

public class RVAdaptador extends RecyclerView.Adapter<RVAdaptador.PetViewHolder> {

    ArrayList<Pet> pets;
    Activity activity;

    public RVAdaptador (ArrayList<Pet> pets, Activity activity) {
        this.pets  = pets;
        this.activity   = activity;
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet,parent,false);
        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PetViewHolder personViewHolder, int i) {
        personViewHolder.petName.setText(pets.get(i).getNombre());
        personViewHolder.petRate.setText(pets.get(i).getRate());
        personViewHolder.petPhoto.setImageResource(pets.get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {
        TextView petName;
        TextView petRate;
        ImageView petPhoto;

        PetViewHolder(View itemView) {
            super(itemView);
            petName = (TextView)itemView.findViewById(R.id.tvNombreCV);
            petRate = (TextView)itemView.findViewById(R.id.tvRateCV);
            petPhoto = (ImageView)itemView.findViewById(R.id.ivPhotoCV);
        }
    }
}
