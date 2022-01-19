package com.example.pharasayo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Product_DBManager {
    static class DB_account_register extends SQLiteOpenHelper {

        private static  final String DB_NAME = "myDB";
        private static final String TABLE_NAME = "product_information";
        private static final int DATABASE_VERSION = 1;
        private static final String UID = "_id";
        private static final String PRODUCT_NAME = "product_name";
        private static final String PRODUCT_PRICE = "product_price";
        private static final String DESCRIPTION =  "description";
        private static final String SELLER_NAME = "seller_name";
        private static final String CONTACT_NUMBER = "contact_number";
        private static final String ADDRESS_STREETADDRESS = "address_streetaddress";
        private static final String ADDRESS_UNITFLOOR = "address_unitfloor";
        private static final String ADDRESS_CITY = "address_city";

        /* The table includes {USERNAME, PASSWORD, EMAIL, FULL NAME, EMAIL, CONTACT, ADDRESS} */
        private final String query = "CREATE TABLE " + TABLE_NAME + " ("
                + UID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PRODUCT_NAME + " TEXT NOT NULL,"
                + PRODUCT_PRICE + " INTEGEGER NOT NULL,"
                + DESCRIPTION + " TEXT NOT NULL,"
                + SELLER_NAME + " TEXT NOT NULL,"
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
}
