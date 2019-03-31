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
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private int index = 0;
    // GetFragment
    final FragmentStart1 fragment1 = new FragmentStart1();
    final FragmentStart2 fragment2 = new FragmentStart2();
    final FragmentStart3 fragment3 = new FragmentStart3();
    final FragmentStart4 fragment4 = new FragmentStart4();
    final FragmentStart5 fragment5 = new FragmentStart5();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // GetButton
        Button back = findViewById(R.id.back);
        Button btContinue = findViewById(R.id.bt_continue);

        back.setOnClickListener(this);
        btContinue.setOnClickListener(this);

        // Fragment Viewer
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, fragment1);
        fragmentTransaction.commit();
    }

    //
    public void setFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (index) {
            case 0:
                fragmentTransaction.replace(R.id.container, fragment1).addToBackStack("TAG").commit();
                break;
            case 1:
                fragmentTransaction.replace(R.id.container, fragment2).addToBackStack("TAG").commit();
                break;
            case 2:
                fragmentTransaction.replace(R.id.container, fragment3).addToBackStack("TAG").commit();
                break;
            case 3:
                fragmentTransaction.replace(R.id.container, fragment4).addToBackStack("TAG").commit();
                break;
            case 4:
                fragmentTransaction.replace(R.id.container, fragment5).addToBackStack("TAG").commit();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                if (index > 0) index--;
                onBackPressed();
                break;
            case R.id.bt_continue:
                Toast.makeText(StartActivity.this, Integer.toString(index), Toast.LENGTH_SHORT).show();
                if (index < 4) {
                    index++;
                    setFragment();
                }
                break;
        }
    }
}
