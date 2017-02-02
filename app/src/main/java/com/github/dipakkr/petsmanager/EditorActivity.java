package com.github.dipakkr.petsmanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by deepak on 30-01-2017.
 */

import com.github.dipakkr.petsmanager.data.PetContract.PetEntry;

import java.util.zip.Inflater;

public class EditorActivity extends AppCompatActivity {

    private EditText mPetname;
    private EditText mPetBreed;
    private Spinner mPetGender;
    private EditText mWeight;

    private int mGender = PetEntry.GENDER_UNKNOWN;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.layout.activity_editor);

         mPetname = (EditText)findViewById(R.id.edit_pet_name);
         mPetBreed = (EditText)findViewById(R.id.edit_pet_breed);
         mPetGender = (Spinner)findViewById(R.id.spinner_gender);
         mWeight = (EditText)findViewById(R.id.edit_pet_weight);

        setupSpinner();
    }
    private void setupSpinner(){
        ArrayAdapter genderAdapter = ArrayAdapter.createFromResource(this,R.array.array_gender_option,
                android.R.layout.simple_spinner_dropdown_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mPetGender.setAdapter(genderAdapter);
       mPetGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               String selection = (String) adapterView.getItemAtPosition(i);
               if (!TextUtils.isEmpty(selection)) {
                   if (selection.equals(getString(R.string.gender_male))) {
                       mGender = PetEntry.GENDER_MALE;
                   } else if (selection.equals(getString(R.string.gender_female))) {
                       mGender = PetEntry.GENDER_FEMALE;
                   } else {
                       mGender = PetEntry.GENDER_UNKNOWN;
                   }
               }
           }
           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {
               mGender = PetEntry.GENDER_UNKNOWN;
           }
       });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_editor,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_save :
                insertPet();
                finish();
                break;
            case R.id.action_delete_all_entries:
                //leave for now
                return true;
            case android.R.id.home :
                NavUtils.navigateUpFromSameTask(this);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    private void insertPet(){

    }
}
