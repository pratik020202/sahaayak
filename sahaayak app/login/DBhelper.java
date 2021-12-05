package com.technic.loginui;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.service.autofill.UserData;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context,"Login.db", null ,1);
    }

    public static final String Table_Column_1_Name="username";

    public static final String Table_Column_3_Password="password";
    public static final String TABLE_NAME="UserTable";

   @Override
    public void onCreate(SQLiteDatabase myDB){
        myDB.execSQL("create Table users(username Text primary key,password Text)");
    }

  /*  @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( "+Table_Column_1_Name+" VARCHAR, "+Table_Column_3_Password+" VARCHAR)";
        database.execSQL(CREATE_TABLE);

    }*/


    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldversion , int newversion){
        myDB.execSQL("drop Table if exists users");
    }



    public Boolean insertData(String username,String password){
        try {
            SQLiteDatabase myDB = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("username", username);
            contentValues.put("password", password);
            long result = myDB.insert("users", null, contentValues);

            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public Boolean checkusername(String username) {
        try {

            SQLiteDatabase myDB = this.getWritableDatabase();

            Cursor cursor = myDB.rawQuery("select * from  users where username  = ?", new String[]{username});
//close();
            if (cursor.getCount() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
        public Boolean checkusernamePassword(String username , String password){
            SQLiteDatabase myDB = this.getWritableDatabase();
            Cursor cursor = myDB.rawQuery("select * from users where username = ? and password = ?",new String []{username,password});
           // close();
       if (cursor.getCount()>0)
       {
           return true;
       }
       else {
           return false;
       }
        }


    }


