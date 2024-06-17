package com.shaihi.menus_example;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = findViewById(R.id.imageView);
        iv.setImageResource(R.drawable.sharp_brightness_7_24);

        CardView cv = findViewById(R.id.cardView); //Remember CardView "is a" View
        registerForContextMenu(cv);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT)
                .show();
        if(item.getItemId() ==  R.id.firstTest) {
            return true;
        }
        if(item.getItemId() == R.id.secondTest) {
            return true;
        }
        if(item.getItemId() == R.id.thirdTest) {
            return true;
        }
        return false;
    }


    //Floating Context Menu implementation
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT)
                .show();
        if (item.getItemId() == R.id.firstContextTest) {
            return true;
        } else if (item.getItemId() == R.id.secondContextTest) {
            return true;
        } else if (item.getItemId() == R.id.thirdContextTest) {
            return true;
        }
        return super.onContextItemSelected(item);
    }
}