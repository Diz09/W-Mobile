package com.example.intent_explicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    Button btnSend;
    private String KEY_NAME = "NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.edt_nama);
        btnSend = (Button)
                findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nama = name.getText().toString();
                    if (!nama.equals("")) { // Check if the string is not empty
                        Intent i = new Intent(MainActivity.this, SecondActivity.class);
                        i.putExtra(KEY_NAME, nama);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(), "YOU NEED TO FILL YOUR NAME", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "ERROR, TRY AGAIN !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}