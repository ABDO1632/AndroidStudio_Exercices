package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDbContact extends SQLiteOpenHelper {
    //private int image;
    //    private String Nom,Prenom,Email,Tel;
    public  final  static String Nom_Db="ContactDb";
    public  final  static String Nom_Table="Contact";
    public static final String COLId = "id";
    public  final  static String ColNom="Nom";
    public  final  static String ColPrenom="Prenom";
    public  final  static String ColEmail="Email";
    public  final  static String ColTel="Tel";
    public  final  static String ColImage="image";

    public  MyDbContact(Context c){
        super(c,Nom_Db,null,3);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table "+Nom_Table+" ("+COLId+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ ColNom + " TEXT, " +ColPrenom + " TEXT, "+ColEmail+ " TEXT, "+ ColTel + " TEXT, "+ColImage + " INTEGER )";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //sqLiteDatabase.execSQL("DROP TABLE  " + Nom_Table);
        onCreate(sqLiteDatabase);
    }
    public static long insertContact(SQLiteDatabase sqLiteDatabase,ContactClass ct){
        ContentValues c=new ContentValues();
        c.put(ColNom,ct.getNom());
        c.put(ColPrenom,ct.getPrenom());
        c.put(ColEmail,ct.getEmail());
        c.put(ColTel,ct.getTel());
        c.put(ColImage,ct.getImage());
        return sqLiteDatabase.insert(Nom_Table,null,c);
    }
    public static long updateContact(SQLiteDatabase sqLiteDatabase,ContactClass ct){
        ContentValues c = new ContentValues();
        c.put(ColNom,ct.getNom());
        c.put(ColPrenom,ct.getPrenom());
        c.put(ColEmail,ct.getEmail());
        c.put(ColTel,ct.getTel());
        c.put(ColImage,ct.getImage());
        long result = sqLiteDatabase.update(MyDbContact.Nom_Table,c,"id = "+ct.getId(),null);
        sqLiteDatabase.close();
        return result;
    }
    public static long deleteStudent(SQLiteDatabase sqLiteDatabase,int id){
        long result = sqLiteDatabase.delete(Nom_Table,"id = "+id,null);
        sqLiteDatabase.close();

        return result;
    }
    public static ArrayList<ContactClass> getAllContacs(SQLiteDatabase sqLiteDatabase){
        ArrayList<ContactClass> stds=new ArrayList<>();
        Cursor cur=sqLiteDatabase.rawQuery("select * from "+Nom_Table,null);
        while(cur.moveToNext()){
            ContactClass s = new ContactClass();
            s.setId(cur.getInt(0));
            s.setNom(cur.getString(1));
            s.setPrenom(cur.getString(2));
            s.setEmail(cur.getString(3));
            s.setTel(cur.getString(4));
            s.setImage(cur.getInt(5));
            stds.add(s);
        }

        return stds;

    }

}
