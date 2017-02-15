package mx.alfredoul.petagram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import mx.alfredoul.petagram.FotoPetActivity;
import mx.alfredoul.petagram.db.PetConstructor;
import mx.alfredoul.petagram.pojo.Pet;
import mx.alfredoul.petagram.R;

/**
 * Created by alfredoul on 18/01/17.
 */

public class PetAdaptador extends RecyclerView.Adapter<PetAdaptador.PetViewHolder> {

    ArrayList<Pet> pets;
    Activity activity;

    public PetAdaptador(ArrayList<Pet> pets, Activity activity) {
        this.pets       = pets;
        this.activity   = activity;
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet,parent,false);
        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PetViewHolder petViewHolder, int i) {
        final Pet pet = pets.get(i);

        petViewHolder.petName.setText(pets.get(i).getNombre());
        petViewHolder.petPhoto.setImageResource(pets.get(i).getPhoto());
        petViewHolder.petRate.setText(String.valueOf(pets.get(i).getRate()));

        petViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(activity, "Diste like",Toast.LENGTH_SHORT).show();

                PetConstructor petConstructor = new PetConstructor(activity);
                petConstructor.darLikePet(pet);
                petViewHolder.petRate.setText(String.valueOf(petConstructor.obtenerLikesPet(pet)));

            }
        }
        );
        petViewHolder.petPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Abriendo Foto", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, FotoPetActivity.class);
                intent.putExtra("foto", pet.getPhoto());
                intent.putExtra("rate", pet.getRate());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {
        TextView petName;
        TextView petRate;
        ImageView petPhoto;
        ImageView btnLike;

        PetViewHolder(View itemView) {
            super(itemView);
            petName     = (TextView)itemView.findViewById(R.id.tvNombreCV);
            petRate     = (TextView)itemView.findViewById(R.id.tvRateCV);
            petPhoto    = (ImageView)itemView.findViewById(R.id.ivPhotoCV);
            btnLike     = (ImageView) itemView.findViewById(R.id.btnLike);
        }
    }
}
