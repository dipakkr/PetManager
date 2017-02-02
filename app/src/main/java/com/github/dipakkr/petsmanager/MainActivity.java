package com.github.dipakkr.petsmanager;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.github.dipakkr.petsmanager.data.Petdbhelper;
import com.github.dipakkr.petsmanager.data.PetContract.PetEntry;

public class MainActivity extends AppCompatActivity{

    private Petdbhelper petdbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,EditorActivity.class);
                startActivity(intent);
            }
        });

        petdbhelper = new Petdbhelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        displaydatabaseinfo();
    }

    private void displaydatabaseinfo(){
        SQLiteDatabase db = petdbhelper.getReadableDatabase();

        String[] Projection = {
                PetEntry._ID,
                PetEntry.COLUMN_PET_NAME,
                PetEntry.COLUMN_PET_BREED,
                PetEntry.COLUMN_PET_GENDER,
                PetEntry.COLUMN_PET_WEIGHT
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_insert_dummy_data :
                insertPet();
                displaydatabaseinfo();
                return true;
            case R.id.action_delete_all_entries :
                return true;
            //leave it for now
        }
        return super.onOptionsItemSelected(item);
    }
    private void insertPet(){

            // Gets the database in write mode
            SQLiteDatabase db = petdbhelper.getWritableDatabase();

            // Create a ContentValues object where column names are the keys,
            // and Toto's pet attributes are the values.
            ContentValues values = new ContentValues();
            values.put(PetEntry.COLUMN_PET_NAME, "Toto");
            values.put(PetEntry.COLUMN_PET_BREED, "Terrier");
            values.put(PetEntry.COLUMN_PET_GENDER, PetEntry.GENDER_MALE);
            values.put(PetEntry.COLUMN_PET_WEIGHT, 7);
    }
}

