package com.faizurazadri.githubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        Thread splash = new Thread(){
            @Override
            public void run() {
                super.run();

                try {
                    sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Intent main = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(main);
                }
            }
        };

        splash.start();
    }
}