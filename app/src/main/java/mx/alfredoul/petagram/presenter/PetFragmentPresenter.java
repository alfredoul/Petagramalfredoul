package mx.alfredoul.petagram.presenter;

import android.content.Context;

import java.util.ArrayList;

import mx.alfredoul.petagram.db.PetConstructor;
import mx.alfredoul.petagram.fragment.IPetFragmentView;
import mx.alfredoul.petagram.pojo.Pet;

/**
 * Created by alfredoul on 4/02/17.
 */

public class PetFragmentPresenter implements IPetFragmentPresenter {

    private IPetFragmentView iPetFragmentView;
    private Context context;
    private PetConstructor petConstructor;
    private ArrayList<Pet> pets;

    public PetFragmentPresenter(IPetFragmentView iPetFragmentView, Context context) {
        this.iPetFragmentView = iPetFragmentView;
        this.context = context;
        obtenerPets();
    }

    @Override
    public void obtenerPets() {
        petConstructor = new PetConstructor(context);
        pets = petConstructor.obtenerDatos();
        mostrarPetsRV();

    }

    @Override
    public void mostrarPetsRV() {
        iPetFragmentView.inicializarAdaptadorRV(iPetFragmentView.crearAdaptador(pets));
        iPetFragmentView.GenerarLinearLayout();
    }
}
