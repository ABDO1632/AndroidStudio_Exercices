package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbFiliere extends SQLiteOpenHelper {
    public  final  static String Nom_Db="FiliereDb.db";
    public  final  static String Nom_Table="Filiere";
    public static final String COLId = "id";
    public  final  static String ColCode="code";
    public  final  static String ColDescription="description";
    public  final  static String ColNiveau="niveau";
    public  final  static String ColNbModule="nbModule";
    public MyDbFiliere(Context c)
    {
        super(c,Nom_Db,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table "+Nom_Table+" ("+COLId+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ ColCode + " TEXT, " +ColDescription + " TEXT, "+ColNiveau+ " TEXT, "+ ColNbModule + " INTEGER)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS  "+Nom_Table);
        onCreate(sqLiteDatabase);
    }
    //Create
    public static long insertFiliere(SQLiteDatabase sqLiteDatabase,Filiere ct){
        ContentValues c=new ContentValues();
        c.put(ColDescription,ct.getDescription());
        c.put(ColNiveau,ct.getNiveau());
        c.put(ColNbModule,ct.getNbModule());
        return sqLiteDatabase.insert(Nom_Table,null,c);
    }
}
