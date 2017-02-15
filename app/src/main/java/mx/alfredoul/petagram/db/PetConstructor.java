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
        BaseDatos db = new BaseDatos(context);
        //insertarPetsDummy(db);
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
