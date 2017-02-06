package mx.alfredoul.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.alfredoul.petagram.R;
import mx.alfredoul.petagram.adapter.MypetAdaptador;
import mx.alfredoul.petagram.pojo.Mypet;


/**
 * A simple {@link Fragment} subclass.
 */
public class MypetFragment extends Fragment {
    ArrayList<Mypet> mascotas;
    private RecyclerView listMascotas;


    public MypetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_mypet, container, false);
        listMascotas = (RecyclerView) v.findViewById(R.id.rvLucas);

        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        GridLayoutManager llm = new GridLayoutManager(getActivity(),3);
        listMascotas.setLayoutManager(llm);

        inicicializarListaMascotas();
        inicializarAdaptadorMascotas();
        return  v;

    }

    public void inicicializarListaMascotas() {
        mascotas = new ArrayList<Mypet>();
        mascotas.add(new Mypet("2", R.drawable.lucas2));
        mascotas.add(new Mypet("4", R.drawable.lucas3));
        mascotas.add(new Mypet("5", R.drawable.lucas4));
        mascotas.add(new Mypet("5", R.drawable.lucas5));
        mascotas.add(new Mypet("4", R.drawable.lucas6));
        mascotas.add(new Mypet("4", R.drawable.lucas7));
        mascotas.add(new Mypet("3", R.drawable.lucas8));
        mascotas.add(new Mypet("2", R.drawable.lucas9));
        mascotas.add(new Mypet("2", R.drawable.lucas10));
    }

    public void inicializarAdaptadorMascotas () {
        MypetAdaptador adaptadorMascota = new MypetAdaptador(mascotas, getActivity());
        listMascotas.setAdapter(adaptadorMascota);

    }

}
