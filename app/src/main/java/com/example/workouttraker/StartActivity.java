package com.example.workouttraker;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity implements OnClickListener {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private int index = 0;
    final FragmentStart1 fragment1 = new FragmentStart1();
    final FragmentStart2 fragment2 = new FragmentStart2();
    final FragmentStart3 fragment3 = new FragmentStart3();
    final FragmentStart4 fragment4 = new FragmentStart4();
    final FragmentStart5 fragment5 = new FragmentStart5();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // GetButton
        Button back = findViewById(R.id.back);
        Button btContinue = findViewById(R.id.bt_continue);

        back.setOnClickListener(this);
        btContinue.setOnClickListener(this);

        TextView page = findViewById(R.id.page_num);
        page.setText(Integer.toString(index+1) + " of 5");

        setFragment();
    }

    public void setFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (index) {
            case 0:
                fragmentTransaction.replace(R.id.container, fragment1);
                break;
            case 1:
                fragmentTransaction.replace(R.id.container, fragment2).addToBackStack("TAG");
                break;
            case 2:
                fragmentTransaction.replace(R.id.container, fragment3).addToBackStack("TAG");
                break;
            case 3:
                fragmentTransaction.replace(R.id.container, fragment4).addToBackStack("TAG");
                break;
            case 4:
                fragmentTransaction.replace(R.id.container, fragment5).addToBackStack("TAG");
                break;
        }
        fragmentTransaction.commit();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                if (index > 0) index--;
                onBackPressed();
                break;
            case R.id.bt_continue:
                if (index < 4) {
                    index++;
                    setFragment();
                }
                break;
        }

        TextView page = findViewById(R.id.page_num);
        page.setText(Integer.toString(index+1) + " of 5");
    }
}
