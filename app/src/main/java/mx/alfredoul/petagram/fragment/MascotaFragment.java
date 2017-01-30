package mx.alfredoul.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.alfredoul.petagram.R;
import mx.alfredoul.petagram.adapter.RVAdaptador;
import mx.alfredoul.petagram.adapter.RVAdaptadorLucas;
import mx.alfredoul.petagram.pojo.Lucas;
import mx.alfredoul.petagram.pojo.Pet;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotaFragment extends Fragment {
    ArrayList<Lucas> mascotas;
    private RecyclerView listMascotas;


    public MascotaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_mascota, container, false);

        listMascotas = (RecyclerView) v.findViewById(R.id.rvLucas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        listMascotas.setLayoutManager(llm);

        inicicializarListaMascotas();
        inicializarAdaptadorMascotas();
        return  v;

    }

    public void inicicializarListaMascotas() {
        mascotas = new ArrayList<Lucas>();
        mascotas.add(new Lucas("2", R.drawable.lucas2));
        mascotas.add(new Lucas("4", R.drawable.lucas3));
        mascotas.add(new Lucas("5", R.drawable.lucas4));
        mascotas.add(new Lucas("5", R.drawable.lucas5));
        mascotas.add(new Lucas("4", R.drawable.lucas6));
        mascotas.add(new Lucas("4", R.drawable.lucas7));
        mascotas.add(new Lucas("3", R.drawable.lucas8));
        mascotas.add(new Lucas("2", R.drawable.lucas9));
        mascotas.add(new Lucas("2", R.drawable.lucas10));
    }

    public void inicializarAdaptadorMascotas () {
        RVAdaptadorLucas adaptadorMascota = new RVAdaptadorLucas(mascotas, getActivity());
        listMascotas.setAdapter(adaptadorMascota);
    }

}
