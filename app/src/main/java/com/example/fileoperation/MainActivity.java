package com.example.fileoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText txtinput;
    TextView tv1;
    Button btnRead,btnWrite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtinput = findViewById(R.id.txtinput);
        tv1 = findViewById(R.id.tv1);
        btnRead = findViewById(R.id.btnRead);
        btnWrite = findViewById(R.id.btnWrite);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream fos;
                try
                    {
                        fos = openFileOutput("tryFile",MODE_APPEND);
                        fos.write(txtinput.getText().toString().getBytes());
                        fos.close();
                        Toast.makeText(getApplicationContext(), "file save", Toast.LENGTH_SHORT).show();
                    }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer sb = new StringBuffer();
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("tryFile")));
                    String inputString;
                    while((inputString = br.readLine())!=null)
                    {
                        sb.append(inputString + " \n");
                    }
                    tv1.setText(sb);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}