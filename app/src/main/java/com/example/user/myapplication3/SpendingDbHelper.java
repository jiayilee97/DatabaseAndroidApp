package com.example.user.myapplication3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by User on 3/1/2018.
 */

public class SpendingDbHelper extends SQLiteOpenHelper {


    private final Context context;
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase sqLiteDatabase;

    SpendingDbHelper(Context context) {
        super(context, SpendingContract.SpendingEntry.TABLE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

//TO DO 2.1 Build the SQLite command string to create the table
        final String SQL_CREATE_TABLE = "CREATE TABLE SpendingRecord ( _ID INTEGER PRIMARY KEY AUTOINCREMENT, Amount TEXT NOT NULL, Remarks TEXT NOT NULL );\n";

//Execute the SQL command
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

//TO DO 2.2 Build the SQLite command string to delete the table
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS SpendingRecord");
//TO DO 2.3 execute this SQLite command
//TO DO 2.4 Create the table
        onCreate(sqLiteDatabase);

    }
}