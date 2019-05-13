package com.example.sharedprefrenes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email,name;
    Button save , gotoNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email_et);
        name =  findViewById(R.id.name_et);
        save = findViewById(R.id.save_btn);
        gotoNext = findViewById(R.id.goto_next_btn);
        saveButtonclicked();
        nextButtonClicked();
    }
    public void saveButtonclicked(){
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("DataList",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email", email.getText().toString());
                editor.putString("name", name.getText().toString());
                editor.apply();
                Toast.makeText(MainActivity.this, "Data saved Successfully", Toast.LENGTH_SHORT).show();


            }
        });
    }

    public void nextButtonClicked(){

        gotoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent  = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

}
