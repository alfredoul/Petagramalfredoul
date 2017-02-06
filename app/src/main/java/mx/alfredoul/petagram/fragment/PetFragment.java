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
import mx.alfredoul.petagram.adapter.PetAdaptador;
import mx.alfredoul.petagram.pojo.Pet;
import mx.alfredoul.petagram.presenter.IPetFragmentPresenter;
import mx.alfredoul.petagram.presenter.PetFragmentPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PetFragment extends Fragment implements IPetFragmentView {
    ArrayList<Pet> pets;
    private RecyclerView listPets;
    private IPetFragmentPresenter presenter;

    public PetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        listPets = (RecyclerView) v.findViewById(R.id.rvPets);
        presenter = new PetFragmentPresenter(this, getContext());
        return  v;
    }

    @Override
    public void GenerarLinearLayout() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        listPets.setLayoutManager(llm);
    }

    @Override
    public PetAdaptador crearAdaptador(ArrayList<Pet> pets) {
        PetAdaptador adaptador = new PetAdaptador(pets, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(PetAdaptador adaptador) {
        listPets.setAdapter(adaptador);
    }
}
