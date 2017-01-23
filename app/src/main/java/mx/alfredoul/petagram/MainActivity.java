package mx.alfredoul.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import static mx.alfredoul.petagram.R.id.item_touch_helper_previous_elevation;
import static mx.alfredoul.petagram.R.id.rvPets;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pet> pets; //creamos nuestro arreglo que contendrá las mascotas, lo declaramos fuera del metodo oncreate
    private RecyclerView listPets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // rvPets es el id que dimos en activity_main a mi definicion del recyclerView
        listPets = (RecyclerView) findViewById(R.id.rvPets);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        listPets.setLayoutManager(llm);

        inicicializarListaPets();
        inicializarAdaptador();

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
        RVAdaptador adaptador = new RVAdaptador(pets, this);
        listPets.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mFavoritos:
                Intent intent = new Intent(this, ActivityFavoritos.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}