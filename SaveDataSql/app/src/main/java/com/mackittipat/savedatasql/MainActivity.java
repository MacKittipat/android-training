package com.mackittipat.savedatasql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private UserDbHelper userDbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(this.getClass().toString(), "Starting app");
        userDbHelper = new UserDbHelper(getApplication());

        db = userDbHelper.getWritableDatabase();

        Cursor cursor = db.query(
                UserDbHelper.TABLE_NAME,
                new String[]{UserDbHelper.COLUMN_ID, UserDbHelper.COLUMN_NAME_NAME},
                null,
                null,
                null,
                null,
                null
        );

        String result = "";
        while(cursor.moveToNext()) {
            result += cursor.getString(cursor.getColumnIndex(UserDbHelper.COLUMN_ID));
            result += " | ";
            result += cursor.getString(cursor.getColumnIndex(UserDbHelper.COLUMN_NAME_NAME));
            result += "\n";
        }

        TextView textView = (TextView) findViewById(R.id.lbl_name);
        textView.setText(result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void save(View view) {
        EditText editText = (EditText) findViewById(R.id.txt_name);


        ContentValues values = new ContentValues();
        values.put(UserDbHelper.COLUMN_NAME_NAME, editText.getText().toString());

            // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                UserDbHelper.TABLE_NAME,
                UserDbHelper.COLUMN_NAME_NAME,
                values);

        Log.d(this.getClass().toString(), "Row = " + newRowId);
    }
}
