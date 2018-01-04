package com.example.user.myapplication3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.BaseColumns._ID;
import static com.example.user.myapplication3.SpendingContract.SpendingEntry.COL_AMOUNT;
import static com.example.user.myapplication3.SpendingContract.SpendingEntry.COL_REMARKS;
import static com.example.user.myapplication3.SpendingContract.SpendingEntry.TABLE_NAME;

public class MainActivity extends AppCompatActivity {

    private SpendingDbHelper spendingDbHelper;
    private SQLiteDatabase spendingDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //TO DO 3.1 Create a new instance of com.example.user.myapplication3.SpendingDbHelper
        SpendingDbHelper spendingDbHelper= new SpendingDbHelper(this);

        //TO DO 3.2 Get an instance of the database that can be written to
        SQLiteDatabase spendingDb=spendingDbHelper.getWritableDatabase();
    }

    public void onClickAddToDb(View view){

        //TO DO 3.3 Get instances of the edit text widgets and extract their contents
        EditText _remarks = (EditText) findViewById(R.id.editTextRemarks) ;
        String str_remarks=_remarks.getText().toString();
        EditText _amount = (EditText) findViewById(R.id.editTextAmount) ;
        String str_amount=_amount.getText().toString();
        //EditText _id = (EditText) findViewById(R.id.editTextID) ;
        //String str_id=_id.getText().toString();



        //TO DO 3.4 Store the contents into a ContentValues Object
        ContentValues values= new ContentValues();
        //values.put(_ID,str_id);
        values.put(SpendingContract.SpendingEntry.COL_AMOUNT,str_amount);
        values.put(SpendingContract.SpendingEntry.COL_REMARKS,str_remarks);
        //TO DO 3.5 Insert the ContentValues object into the database
        spendingDb.insert(SpendingContract.SpendingEntry.TABLE_NAME,null,values);


        //spendingDb.close();
        //TO DO 3.6 (Optional) Display a Toast Message
        Context context = getApplicationContext();
        CharSequence text = "Hello toast1";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void onClickGetEntireDb(View view){

        //TO DO 3.7 Call the query or rawQuery method of the spendingDb object and
        //          store the result in a Cursor object
        Cursor cursor = spendingDb.rawQuery("SELECT * FROM mytable", null);
        //TO DO 3.8 Extract the data from the Cursor object and
        //          display it on the textView widget
//Get the reference to your textView widget to display the results in
        TextView textView = findViewById(R.id.textViewEntireDatabase);

        String outstring = "";

        //Get the column index. The first one is done for you. Complete the rest.
        int indexRemarks = cursor.getColumnIndex(COL_REMARKS);

        while(cursor.moveToNext()){

            //Get the contents of the particular row in that column. The first one is done for you.
            String myRemarks = cursor.getString(indexRemarks);

            //format the output string and add it to outstring
            outstring=outstring + myRemarks;

        }

        textView.setText(outstring);
    }


    public void onClickDeleteFromDb(View view){


        try{
            //TO DO 3.9 Get an instance of the editText Widget
            //          and extract the contents
            TextView _textView=(TextView) findViewById(R.id.textViewEntireDatabase);
            String _text=_textView.getText().toString();
            //TO DO 3.10 Delete the entry
            String sqlQuery = "DELETE FROM my_table_name WHERE where_clause" ;
            spendingDb.execSQL(sqlQuery);


        }catch(Exception ex){
            //TO DO 3.11 Display a toast if an exception occurs
        }

    }
}
