package mx.alfredoul.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import mx.alfredoul.petagram.R;
import mx.alfredoul.petagram.pojo.Pet;

/**
 * Created by alfredoul on 4/02/17.
 */

public class PetConstructor {
    private static final Integer LIKE = 1;
    private Context context;

    public PetConstructor(Context context) {
        this.context=context;

    }

    public ArrayList<Pet> obtenerDatos(){
        /*ArrayList<Pet> pets = new ArrayList<>();
        pets = new ArrayList<Pet>();
        pets.add(new Pet("Hugo", "2", R.drawable.pet1 ));
        pets.add(new Pet("Emma", "4", R.drawable.pet2));
        pets.add(new Pet("Daniel", "5", R.drawable.pet3));
        pets.add(new Pet("Pablo", "5", R.drawable.pet4));
        pets.add(new Pet("Sofia", "4", R.drawable.pet5));
        pets.add(new Pet("Santiago", "4", R.drawable.pet6));
        pets.add(new Pet("Camila", "3", R.drawable.pet7));
        pets.add(new Pet("Sebastián", "2", R.drawable.pet8));
        pets.add(new Pet("Valentina", "2", R.drawable.pet9));
        pets.add(new Pet("Diego", "4", R.drawable.pet10));
        return pets;*/

        BaseDatos db = new BaseDatos(context);
        insertarPetsDummy(db);
        return  db.obtenerTodasLasPets();
    }

    public void insertarPetsDummy(BaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NAME,"Hugo");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PHOTO,R.drawable.pet1);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NAME,"Emma");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PHOTO,R.drawable.pet2);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NAME,"Daniel");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PHOTO,R.drawable.pet3);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NAME,"Pablo");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PHOTO,R.drawable.pet4);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NAME,"Sofia");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PHOTO,R.drawable.pet5);
        db.insertarPet(contentValues);
    }

    public void darLikePet(Pet pet){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_LIKES_ID, pet.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_PET_LIKES_NUM_LIKES, LIKE);
        db.insertarLikePet(contentValues);
    }

    public int obtenerLikesPet(Pet pet) {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesPet(pet);
    }
}
