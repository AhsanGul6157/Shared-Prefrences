package com.example.sharedprefrenes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private static final String DEFAULT = "N/A";
Button previousButton,loadButton;
TextView userEmail,userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        userEmail = findViewById(R.id.perrson_email_tv);
        userName = findViewById(R.id.perrson_name_tv);
        previousButton = findViewById(R.id.previousBtn);
        loadButton = findViewById(R.id.loadBtn);
        loadButtonClicked();
        previousButtonClicked();

    }

    public void loadButtonClicked(){
        SharedPreferences sharedPreferences = getSharedPreferences("DataList",MODE_PRIVATE);

        String user_Email = sharedPreferences.getString("email", DEFAULT);
                String user_Name = sharedPreferences.getString("name",DEFAULT);
                
        if(user_Email.equals(DEFAULT) || user_Name.equals(DEFAULT) ){
            Toast.makeText(this, "No data found ):", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Data Loaded Successfully (:", Toast.LENGTH_SHORT).show();
            userEmail.setText(user_Email);
            userName.setText(user_Name);
        }
    }

    public void previousButtonClicked(){
previousButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SecondActivity.this,MainActivity.class);
        startActivity(intent);
    }
});    }
}
