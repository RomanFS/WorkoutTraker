package com.example.workouttraker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity implements OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Button Call
        Button back = findViewById(R.id.back);
        Button btContinue = findViewById(R.id.bt_continue);

        back.setOnClickListener(this);
        btContinue.setOnClickListener(this);

        // Fragment Viewer
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FragmentStart1 fragment = new FragmentStart1();
        fragmentTransaction.add(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.bt_continue:
                Toast.makeText(StartActivity.this, "Next Fragment", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
