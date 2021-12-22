package com.example.pharasayo;

import static android.os.Message.*;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Message;

import androidx.annotation.Nullable;

public class dbAdapter {
    static class DB_account_register extends SQLiteOpenHelper{

        private static  final String DB_NAME = "myDB";
        private static final String TABLE_NAME = "sampleTable";
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

        private Context context;

        public DB_account_register(Context context) {
            super(context, DB_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            /* The table includes {USERNAME, PASSWORD, EMAIL, FULL NAME, EMAIL, CONTACT, ADDRESS} */
            String query = "CREATE TABLE " + TABLE_NAME + " ("
                    + UID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + USERNAME + " TEXT PRIMARY KEY,"
                    + PASSWORD + " TEXT,"
                    + FULLNAME + " TEXT,"
                    + EMAIL + " TEXT,"
                    + CONTACT_NUMBER + " TEXT,"
                    + ADDRESS_STREETADDRESS + " TEXT,"
                    + ADDRESS_UNITFLOOR + " TEXT,"
                    + ADDRESS_CITY + " TEXT)";

            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

        //This method will insert the information filled up in registration form
        public void Register(String user, String pass, String fname, String email, String cnum, String add_street, String add_unit, String add_city){
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put(USERNAME, user);
            values.put(PASSWORD, pass);
            values.put(FULLNAME, fname);
            values.put(EMAIL, email);
            values.put(CONTACT_NUMBER, cnum);
            values.put(ADDRESS_STREETADDRESS, add_street);
            values.put(ADDRESS_UNITFLOOR, add_unit);
            values.put(ADDRESS_CITY, add_city);

            db.insert(TABLE_NAME, null, values);

            db.close();
        }
    }
}
