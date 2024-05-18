package com.example.SportShop;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperBasket extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "basket_database1";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "basket_image";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ITEM_DESCRIPTION = "description";

    public DatabaseHelperBasket(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_ITEM_DESCRIPTION + " TEXT)";
        db.execSQL(createTableQuery);

        // Insérer des données fictives pour la première utilisation
        insertInitialData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Méthode pour mettre à jour la description d'un élément à partir de son ID
    public void updateItemDescription(int itemId, String newDescription) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Vérifier si l'itemId existe dans la base de données
        Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN_ID}, COLUMN_ID + " = ?",
                new String[]{String.valueOf(itemId)}, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {
            // Si l'itemId existe, mettre à jour la description
            ContentValues values = new ContentValues();
            values.put(COLUMN_ITEM_DESCRIPTION, newDescription);

            db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{String.valueOf(itemId)});
        } else {
            // Si l'itemId n'existe pas, insérer une nouvelle ligne avec l'itemId et la description donnés
            ContentValues values = new ContentValues();
            values.put(COLUMN_ID, itemId);
            values.put(COLUMN_ITEM_DESCRIPTION, newDescription);

            db.insert(TABLE_NAME, null, values);
        }

        // Fermer le curseur et la base de données
        if (cursor != null) {
            cursor.close();
        }
        db.close();
    }

    // Méthode pour insérer des données initiales dans la base de données
    private void insertInitialData(SQLiteDatabase db) {
        ContentValues values1 = new ContentValues();
        values1.put(COLUMN_ID, 1);
        values1.put(COLUMN_ITEM_DESCRIPTION, "Description de l'élément 1");
        db.insert(TABLE_NAME, null, values1);

        // Insérer d'autres données si nécessaire...
    }

    // Méthode pour récupérer la description d'un élément à partir de son ID
    @SuppressLint("Range")
    public String getItemDescription(int itemId) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + COLUMN_ITEM_DESCRIPTION + " FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(itemId)});
        String description = "";
        if (cursor.moveToFirst()) {
            description = cursor.getString(cursor.getColumnIndex(COLUMN_ITEM_DESCRIPTION));
        }
        cursor.close();
        return description;
    }

    // Méthode pour récupérer les données associées à l'élément depuis la base de données
    @SuppressLint("Range")
    public String getItemData(int itemId) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + COLUMN_ITEM_DESCRIPTION + " FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(itemId)});
        String data = "";
        if (cursor.moveToFirst()) {
            data = cursor.getString(cursor.getColumnIndex(COLUMN_ITEM_DESCRIPTION));
        }
        cursor.close();
        return data;
    }
}
