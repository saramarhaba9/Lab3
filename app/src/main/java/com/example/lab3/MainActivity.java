package com.example.lab3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton radioButton;
    RadioGroup radioGroup;
    ImageView imageView  ;
    int radioId ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        imageView = findViewById(R.id.imageView);
//        click(this);

    }

    public void click(View view) {
        radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);
        String selected = (String) radioButton.getText();
        if(selected.equals("Don")){
            imageView.setImageResource(R.drawable.purple);
        } else if (selected.equals("Raph")){
            imageView.setImageResource(R.drawable.red);
        }else if (selected.equals("Mike")){
            imageView.setImageResource(R.drawable.orange);
        }else if (selected.equals("Leo")){
            imageView.setImageResource(R.drawable.blue);
        } else {
            Toast.makeText(this, "Not Selected", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("id", radioId);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        radioId = savedInstanceState.getInt("id");
    }
}