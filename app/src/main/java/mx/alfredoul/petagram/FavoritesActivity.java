package mx.alfredoul.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import mx.alfredoul.petagram.adapter.PetAdaptador;
import mx.alfredoul.petagram.pojo.Pet;

public class FavoritesActivity extends AppCompatActivity {

    ArrayList<Pet> pets; //creamos nuestro arreglo que contendrá las mascotas, lo declaramos fuera del metodo oncreate
    private RecyclerView listPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // rvPets es el id que dimos en activity_main a mi definicion del recyclerView
        listPets = (RecyclerView) findViewById(R.id.rvPets);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        listPets.setLayoutManager(llm);

        inicicializarListaPets();
        inicializarAdaptador();
    }

    public void inicicializarListaPets() {
        pets = new ArrayList<Pet>();
        /*pets.add(new Pet("Valentina", 0, R.drawable.pet9));
        pets.add(new Pet("Daniel", 0, R.drawable.pet3));
        pets.add(new Pet("Hugo", 0, R.drawable.pet1));
        pets.add(new Pet("Camila", 0, R.drawable.pet7));
        pets.add(new Pet("Emma", 0, R.drawable.pet2));*/
    }

    public void inicializarAdaptador () {
        PetAdaptador adaptador = new PetAdaptador(pets, this);
        listPets.setAdapter(adaptador);
    }
}
