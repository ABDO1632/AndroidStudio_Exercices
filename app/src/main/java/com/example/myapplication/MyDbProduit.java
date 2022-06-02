package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;


public class MyDbProduit extends SQLiteOpenHelper {
    public  final  static String Nom_Db="ProduitDb.db";
    public  final  static String Nom_Table="Produit";
    public static final String COLId = "id";
    public  final  static String ColLibelle="Libelle";
    public  final  static String ColFamille="Famille";
    public  final  static String ColPrixAchat="PrixAchat";
    public  final  static String ColPrixVente="PrixVente";

    public MyDbProduit(Context c){
        super(c,Nom_Db,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table "+Nom_Table+" ("+COLId+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ ColLibelle + " TEXT, " +ColFamille + " TEXT, "+ColPrixAchat+ " DOUBLE, "+ ColPrixVente + " DOUBLE)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS  "+Nom_Table);
        onCreate(sqLiteDatabase);
    }
    //Read
    public static ArrayList<ProduitsClass> getAllProduits(SQLiteDatabase sqLiteDatabase){
        ArrayList<ProduitsClass> prds=new ArrayList<>();
        Cursor cr=sqLiteDatabase.rawQuery("Select * from "+Nom_Table,null);
        while (cr.moveToNext())
        {
            ProduitsClass p=new ProduitsClass();
            p.setId(cr.getInt(0));
            p.setLibelle(cr.getString(1));
            p.setFamille(cr.getString(2));
            p.setPrixAchat(cr.getDouble(3));
            p.setPrixVente(cr.getDouble(4));

            prds.add(p);
        }
        return prds;

    }
    //Create
    public static long insertPrduits(SQLiteDatabase sqLiteDatabase,ProduitsClass ct){
        ContentValues c=new ContentValues();
        c.put(ColLibelle,ct.getLibelle());
        c.put(ColFamille,ct.getFamille());
        c.put(ColPrixAchat,ct.getPrixAchat());
        c.put(ColPrixVente,ct.getPrixVente());
        return sqLiteDatabase.insert(Nom_Table,null,c);
    }
    public static long updatePrduits(SQLiteDatabase sqLiteDatabase,ProduitsClass ct){
        ContentValues c = new ContentValues();
        c.put(ColLibelle,ct.getLibelle());
        c.put(ColFamille,ct.getFamille());
        c.put(ColPrixAchat,ct.getPrixAchat());
        c.put(ColPrixVente,ct.getPrixVente());
        long result = sqLiteDatabase.update(MyDbProduit.Nom_Table,c,"id = "+ct.getId(),null);
        sqLiteDatabase.close();
        return result;
    }
}
