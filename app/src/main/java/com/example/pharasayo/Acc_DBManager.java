package com.example.pharasayo;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Acc_DBManager {
    static class DB_account_register extends SQLiteOpenHelper{

        private static  final String DB_NAME = "myDB";
        private static final String TABLE_NAME = "user_account";
        private static final int DATABASE_VERSION = 1;
        private static final String UID = "_id";
        private static final String FULLNAME = "fullname";
        private static final String USERNAME = "username";
        private static final String PASSWORD =  "password";
        private static final String EMAIL = "email";
        private static final String CONTACT_NUMBER = "contact_number";
        private static final String ADDRESS_STREETADDRESS = "address_streetaddress";
        private static final String ADDRESS_UNITFLOOR = "address_unitfloor";
        private static final String ADDRESS_CITY = "address_city";

        /* The table includes {USERNAME, PASSWORD, EMAIL, FULL NAME, EMAIL, CONTACT, ADDRESS} */
        private final String query = "CREATE TABLE " + TABLE_NAME + " ("
                + UID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + USERNAME + " TEXT NOT NULL,"
                + PASSWORD + " TEXT NOT NULL,"
                + FULLNAME + " TEXT NOT NULL,"
                + EMAIL + " TEXT NOT NULL,"
                + CONTACT_NUMBER + " TEXT NOT NULL,"
                + ADDRESS_STREETADDRESS + " TEXT NOT NULL,"
                + ADDRESS_UNITFLOOR + " TEXT NOT NULL,"
                + ADDRESS_CITY + " TEXT NOT NULL)";

        public DB_account_register(Context context) {
            super(context, DB_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

    private DB_account_register dbRegister;
    private Context context;
    private SQLiteDatabase database;

    public Acc_DBManager(Context c){
        context = c;
    }

    public Acc_DBManager open() throws SQLException{
        dbRegister = new DB_account_register(context);
        database = dbRegister.getWritableDatabase();
        return this;
    }

    public void close(){
        dbRegister.close();
    }

    //This method will insert the information filled up in registration form
    public void insert(
            String user,
            String pass,
            String fname,
            String email,
            String cnum,
            String add_street,
            String add_unit,
            String add_city){

        ContentValues values = new ContentValues();

        values.put(DB_account_register.USERNAME, user);
        values.put(DB_account_register.PASSWORD, pass);
        values.put(DB_account_register.FULLNAME, fname);
        values.put(DB_account_register.EMAIL, email);
        values.put(DB_account_register.CONTACT_NUMBER, cnum);
        values.put(DB_account_register.ADDRESS_STREETADDRESS, add_street);
        values.put(DB_account_register.ADDRESS_UNITFLOOR, add_unit);
        values.put(DB_account_register.ADDRESS_CITY, add_city);

        database.insert(DB_account_register.TABLE_NAME, null, values);

        database.close();
    }

    public int update(
            String user,
            String pass,
            String fname,
            String email,
            String cnum,
            String add_street,
            String add_unit,
            String add_city,
            long _id){

        ContentValues values = new ContentValues();

        values.put(DB_account_register.USERNAME, user);
        values.put(DB_account_register.PASSWORD, pass);
        values.put(DB_account_register.FULLNAME, fname);
        values.put(DB_account_register.EMAIL, email);
        values.put(DB_account_register.CONTACT_NUMBER, cnum);
        values.put(DB_account_register.ADDRESS_STREETADDRESS, add_street);
        values.put(DB_account_register.ADDRESS_UNITFLOOR, add_unit);
        values.put(DB_account_register.ADDRESS_CITY, add_city);

        int i = database.update(
                DB_account_register.TABLE_NAME,
                values,
                DB_account_register.UID + " = " + _id,
                null);

        return i;
    }

    public void delete(long _id){
        database.delete(
                DB_account_register.TABLE_NAME,
                DB_account_register.UID + " = " + _id,
                null);
    }
}
