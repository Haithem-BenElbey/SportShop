package com.example.SportShop;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperFoot extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "image_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "images";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_IMAGE_DESCRIPTION = "description";

    public DatabaseHelperFoot(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_IMAGE_DESCRIPTION + " TEXT)";
        db.execSQL(createTableQuery);

        // Insérer des données fictives pour la première utilisation
        insertInitialData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    // Méthode pour mettre à jour la description d'une image à partir de son ID
    public void updateImageDescription(int imageId, String newDescription) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Check if the imageId exists in the database
        Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN_ID}, COLUMN_ID + " = ?",
                new String[]{String.valueOf(imageId)}, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {
            // If the imageId exists, update the description
            ContentValues values = new ContentValues();
            values.put(COLUMN_IMAGE_DESCRIPTION, newDescription);

            db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{String.valueOf(imageId)});
        } else {
            // If the imageId doesn't exist, insert a new row with the given imageId and description
            ContentValues values = new ContentValues();
            values.put(COLUMN_ID, imageId);
            values.put(COLUMN_IMAGE_DESCRIPTION, newDescription);

            db.insert(TABLE_NAME, null, values);
        }

        // Close the cursor and database
        if (cursor != null) {
            cursor.close();
        }
        db.close();
    }


    // Méthode pour insérer des données initiales dans la base de données
    private void insertInitialData(SQLiteDatabase db) {
        ContentValues values1 = new ContentValues();
        values1.put(COLUMN_ID, 1);
        values1.put(COLUMN_IMAGE_DESCRIPTION, "Description de l'image 1");
        db.insert(TABLE_NAME, null, values1);

        // Insérer d'autres données si nécessaire...
    }

    // Méthode pour récupérer la description d'une image à partir de son ID
    @SuppressLint("Range")
    public String getImageDescription(int imageId) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + COLUMN_IMAGE_DESCRIPTION + " FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(imageId)});
        String description = "";
        if (cursor.moveToFirst()) {
            description = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE_DESCRIPTION));
        }
        cursor.close();
        return description;
    }

    // Méthode pour récupérer les données associées à l'image depuis la base de données
    @SuppressLint("Range")
    public String getImageData(int imageId) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + COLUMN_IMAGE_DESCRIPTION + " FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(imageId)});
        String data = "";
        if (cursor.moveToFirst()) {
            data = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE_DESCRIPTION));
        }
        cursor.close();
        return data;
    }
}
