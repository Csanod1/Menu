package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonSubmit;
    private EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1. lépés, adat elmentés
                adatMentes();

            }
        });
    }

    private void adatMentes() {
        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String seged = editTextInput.getText().toString();
        if (seged.equals("")){
            editTextInput.setError("muszáj kitölteni");
        }else {
            editor.putString("editTextErteke", seged);
            editor.apply();
            //2. lépés, átmegyünk másik Activityre
            //HOnnan -> hova
            Intent intent = new Intent(MainActivity.this, MasodikActivity.class);
            startActivity(intent);
            //backstack!!
            finish();
        }
        editor.putString("editTextErteke", seged);
        editor.commit();
        editor.apply();
    }

    private void init(){
        buttonSubmit = findViewById(R.id.buttonSubmit);
        editTextInput = findViewById(R.id.editTextInput);
    }
}