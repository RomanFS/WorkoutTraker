package com.example.workouttraker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.startButton);
        Button exit = findViewById(R.id.startButtonExit);

        start.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, StartActivity.class)));

        // This is must be a intent(MainPageActivity)
        exit.setOnClickListener(v -> onBackPressed());
    }

}
