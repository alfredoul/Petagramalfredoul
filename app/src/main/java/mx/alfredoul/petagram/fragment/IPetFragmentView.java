package mx.alfredoul.petagram.fragment;

import java.util.ArrayList;

import mx.alfredoul.petagram.adapter.PetAdaptador;
import mx.alfredoul.petagram.pojo.Pet;

/**
 * Created by alfredoul on 4/02/17.
 */

public interface IPetFragmentView {
    public void GenerarLinearLayout();

    public PetAdaptador crearAdaptador (ArrayList<Pet> pets);

    public void inicializarAdaptadorRV(PetAdaptador adaptador);

}
