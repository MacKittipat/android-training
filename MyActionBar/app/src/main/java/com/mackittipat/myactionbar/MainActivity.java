package com.mackittipat.myactionbar;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        TextView textView = (TextView) findViewById(R.id.lbl_message);

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            textView.setText("Search!!!");
            return true;
        } else if(id == R.id.action_settings) {
            textView.setText("Setting!!!");
            return true;
        } else if(id == R.id.action_about) {
            textView.setText("About!!!");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
