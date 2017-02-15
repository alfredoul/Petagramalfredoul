package mx.alfredoul.petagram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.alfredoul.petagram.FotoPetActivity;
import mx.alfredoul.petagram.R;
import mx.alfredoul.petagram.pojo.Mypet;

/**
 * Created by alfredoul on 18/01/17.
 */

public class MypetAdaptador extends RecyclerView.Adapter<MypetAdaptador.MypetViewHolder> {

    ArrayList<Mypet> pets;
    Activity activity;

    public MypetAdaptador(ArrayList<Mypet> pets, Activity activity) {
        this.pets  = pets;
        this.activity   = activity;
    }

    @Override
    public MypetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mypet,parent,false);
        return new MypetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MypetViewHolder mypetViewHolder, int i) {
        final Mypet mypet = pets.get(i);

        mypetViewHolder.petRate.setText(String.valueOf(pets.get(i).getRate()));
        mypetViewHolder.petPhoto.setImageResource(pets.get(i).getPhoto());

        mypetViewHolder.petPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, FotoPetActivity.class);
                intent.putExtra("foto", mypet.getPhoto());
                intent.putExtra("rate", mypet.getRate());
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class MypetViewHolder extends RecyclerView.ViewHolder {
        TextView petRate;
        ImageView petPhoto;

        MypetViewHolder(View itemView) {
            super(itemView);
            petRate = (TextView)itemView.findViewById(R.id.tvRateL);
            petPhoto = (ImageView)itemView.findViewById(R.id.ivLucas);
        }
    }
}
