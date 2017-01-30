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
import mx.alfredoul.petagram.pojo.Pet;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerviewFragment extends Fragment {
    ArrayList<Pet> pets;
    private RecyclerView listPets;

    public RecyclerviewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listPets = (RecyclerView) v.findViewById(R.id.rvPets);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        listPets.setLayoutManager(llm);

        inicicializarListaPets();
        inicializarAdaptador();
        return  v;

    }

    public void inicicializarListaPets() {
        pets = new ArrayList<Pet>();
        pets.add(new Pet("Hugo", "2", R.drawable.pet1));
        pets.add(new Pet("Emma", "4", R.drawable.pet2));
        pets.add(new Pet("Daniel", "5", R.drawable.pet3));
        pets.add(new Pet("Pablo", "5", R.drawable.pet4));
        pets.add(new Pet("Sofia", "4", R.drawable.pet5));
        pets.add(new Pet("Santiago", "4", R.drawable.pet6));
        pets.add(new Pet("Camila", "3", R.drawable.pet7));
        pets.add(new Pet("Sebastián", "2", R.drawable.pet8));
        pets.add(new Pet("Valentina", "2", R.drawable.pet9));
        pets.add(new Pet("Diego", "4", R.drawable.pet10));
    }

    public void inicializarAdaptador () {
        RVAdaptador adaptador = new RVAdaptador(pets, getActivity());
        listPets.setAdapter(adaptador);
    }


}
