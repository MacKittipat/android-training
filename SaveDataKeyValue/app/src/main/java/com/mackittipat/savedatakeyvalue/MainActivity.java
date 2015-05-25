package com.mackittipat.savedatakeyvalue;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final String KEY_MSG = "mac.kittipat.savedatakeyvalue.MSG";

    private SharedPreferences sharedPreferences;

    private EditText txtMsg;
    private TextView lblMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMsg = (EditText) findViewById(R.id.txt_msg);
        lblMsg = (TextView) findViewById(R.id.lbl_msg);

        sharedPreferences =
                getApplicationContext().getSharedPreferences(KEY_MSG, Context.MODE_PRIVATE);
        String msg = sharedPreferences.getString(KEY_MSG, null);
        if(msg != null) {
            lblMsg.setText(msg);
        }
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
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String msg = txtMsg.getText().toString();
        editor.putString(KEY_MSG, msg);
        editor.commit();

        lblMsg.setText(msg);
    }
}
