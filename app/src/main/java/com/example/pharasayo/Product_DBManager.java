package com.example.pharasayo;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Product_DBManager {
    static class DB_Product extends SQLiteOpenHelper {

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

        public DB_Product(Context context) {
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

    private Product_DBManager.DB_Product dbProduct;
    private Context context;
    private SQLiteDatabase database;

    public Product_DBManager(Context c){
        context = c;
    }

    public Product_DBManager open() throws SQLException {
        dbProduct = new Product_DBManager.DB_Product(context);
        database = dbProduct.getWritableDatabase();
        return this;
    }

    public void close(){
        dbProduct.close();
    }

    //This method will insert the information filled up in registration form
    public void insert(
            String productName,
            String productPrice,
            String decription,
            String sellerName,
            String cnum,
            String add_street,
            String add_unit,
            String add_city){

        ContentValues values = new ContentValues();

        values.put(DB_Product.PRODUCT_NAME, productName);
        values.put(DB_Product.PRODUCT_PRICE, productPrice);
        values.put(DB_Product.DESCRIPTION, decription);
        values.put(DB_Product.SELLER_NAME, sellerName);
        values.put(DB_Product.CONTACT_NUMBER, cnum);
        values.put(DB_Product.ADDRESS_STREETADDRESS, add_street);
        values.put(DB_Product.ADDRESS_UNITFLOOR, add_unit);
        values.put(DB_Product.ADDRESS_CITY, add_city);

        database.insert(DB_Product.TABLE_NAME, null, values);

    }

    public int update(
            String productName,
            String productPrice,
            String decription,
            String sellerName,
            String cnum,
            String add_street,
            String add_unit,
            String add_city,
            long _id){

        ContentValues values = new ContentValues();

        values.put(DB_Product.PRODUCT_NAME, productName);
        values.put(DB_Product.PRODUCT_PRICE, productPrice);
        values.put(DB_Product.DESCRIPTION, decription);
        values.put(DB_Product.SELLER_NAME, sellerName);
        values.put(DB_Product.CONTACT_NUMBER, cnum);
        values.put(DB_Product.ADDRESS_STREETADDRESS, add_street);
        values.put(DB_Product.ADDRESS_UNITFLOOR, add_unit);
        values.put(DB_Product.ADDRESS_CITY, add_city);

        int i = database.update(
                DB_Product.TABLE_NAME,
                values,
                DB_Product.UID + " = " + _id,
                null);

        return i;
    }

    public void delete(long _id){
        database.delete(
                DB_Product.TABLE_NAME,
                DB_Product.UID + " = " + _id,
                null);
    }
}
