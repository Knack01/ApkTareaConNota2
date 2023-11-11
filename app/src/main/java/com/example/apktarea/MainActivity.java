package com.example.apktarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Button iniciar;
    private EditText Usuario, Password;

    private ProgressBar pb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar = findViewById(R.id.btn_ingresar);
        Usuario = findViewById(R.id.et_usuario);
        Password = findViewById(R.id.et_password);
        pb = findViewById(R.id.progressBar);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Task().execute(Usuario.getText().toString());
            }
        });
    }
    class Task extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute(){
            pb.setVisibility(View.VISIBLE);
            iniciar.setEnabled(false);
        }

        protected String doInBackground(String... strings){
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return strings[0];
        }

        @Override
        protected void onPostExecute(String s){
            pb.setVisibility(View.VISIBLE);
            iniciar.setEnabled(true);
            Intent intent = new Intent(MainActivity.this, Menu.class);
            intent.putExtra("Usuario", Usuario.getText().toString());
            startActivity(intent);
        }
    }
    public void Menu(View view){
        Intent menu = new Intent(this, Menu.class);
        startActivity(menu);
    }


}