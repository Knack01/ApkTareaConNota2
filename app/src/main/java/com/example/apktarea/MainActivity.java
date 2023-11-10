package com.example.apktarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb;
    Button btn;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = findViewById(R.id.progressBar);
        btn = findViewById(R.id.btn_ingresar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb.setVisibility(View.VISIBLE);

                Timer timer = new Timer();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        counter++;
                        pb.setProgress(counter);
                        if (counter == 100){
                            timer.cancel();
                            Intent opcion = new Intent(MainActivity.this, Menu.class);
                            startActivity(opcion);
                        }
                    }
                };
                timer.schedule(timerTask, 0, 50);
            }
        });
    }
    public void Menu(View view){
        Intent menu = new Intent(this, Menu.class);
        startActivity(menu);
    }


}