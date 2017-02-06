package mx.alfredoul.petagram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import mx.alfredoul.petagram.pojo.Pet;

/**
 * Created by alfredoul on 5/02/17.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /* aqui creamos la base de datos */
        String queryCrearTablaPet = "CREATE TABLE "     + ConstantesBaseDatos.TABLE_PET + "(" +
                ConstantesBaseDatos.TABLE_PET_ID        + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLE_PET_NAME      + " TEXT, "+
                ConstantesBaseDatos.TABLE_PET_PHOTO     + " INTEGER"+
                ")";

        String queryCrearTablaPetLike = "CREATE TABLE "         + ConstantesBaseDatos.TABLE_PET_LIKES + "(" +
                ConstantesBaseDatos.TABLE_PET_LIKES_ID          + " INTEGER, "+
                ConstantesBaseDatos.TABLE_PET_LIKES_NUM_LIKES   + " INTEGER, "+
                ConstantesBaseDatos.TABLE_PET_LIKES_PET         + " INTEGER, "+
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_PET_LIKES_PET + ") REFERENCES " + ConstantesBaseDatos.TABLE_PET + "("+ConstantesBaseDatos.TABLE_PET_ID+")"+
                ")";

        db.execSQL(queryCrearTablaPet);
        db.execSQL(queryCrearTablaPetLike);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_PET);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_PET_LIKES);
        onCreate(db);
    }

    public ArrayList<Pet> obtenerTodasLasPets() {
        ArrayList<Pet> pets = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PET;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Pet petActual = new Pet();
            petActual.setId(registros.getInt(0));
            petActual.setNombre(registros.getString(1));
            petActual.setPhoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT ("+ConstantesBaseDatos.TABLE_PET_LIKES_NUM_LIKES+")"+
                                " FROM "+ ConstantesBaseDatos.TABLE_PET_LIKES +
                                " WHERE "+ ConstantesBaseDatos.TABLE_PET_LIKES_ID + "=" + petActual.getId();
            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()) {
                petActual.setRate(registrosLikes.getInt(0));
            } else {
                petActual.setRate(0);
            }


            pets.add(petActual);
        }
        db.close();
        return pets;
     }

    public void insertarPet(ContentValues contentValues) {
        SQLiteDatabase db =this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PET,null,contentValues);
        db.close();
    }

    public void insertarLikePet(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PET_LIKES,null,contentValues);
        db.close();
    }

    public int obtenerLikesPet(Pet pet) {
        int likes = 0;
        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_PET_LIKES_NUM_LIKES+")"+
                " FROM "+ ConstantesBaseDatos.TABLE_PET_LIKES +
                " WHERE "+ ConstantesBaseDatos.TABLE_PET_LIKES_ID + "=" + pet.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        if (registros.moveToNext()) {
            likes = registros.getInt(0);
        }
        db.close();
        return likes;

    }
}
