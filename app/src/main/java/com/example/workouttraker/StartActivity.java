package com.example.workouttraker;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private int index = 0;

    private ArrayList<Fragment> mFragments;

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

        // Init buttons
        Button back = findViewById(R.id.back);
        Button btContinue = findViewById(R.id.bt_continue);

        back.setOnClickListener(v -> {
            if (index > 0) index--;
            onBackPressed();

            this.updateTip_Pages();
        });
        btContinue.setOnClickListener(v -> {
            if (index < 4) {
                index++;
                updateView();
            }
            this.updateTip_Pages();
        });
        this.updateTip_Pages();

        // Fragments list init
        mFragments = new ArrayList<Fragment>();

        mFragments.add(fragment1);
        mFragments.add(fragment2);
        mFragments.add(fragment3);
        mFragments.add(fragment4);
        mFragments.add(fragment5);

        // Setup activity fragment
        updateView();
    }

    private void updateView() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.container, mFragments.get(index));
        if(index > 0) {
            fragmentTransaction.addToBackStack("FRAGMENT_" + index);
        }

        fragmentTransaction.commit();
    }

    @SuppressLint("SetTextI18n")
    private void updateTip_Pages(){
        TextView page = findViewById(R.id.page_num);
        page.setText((index+1) + " of " + mFragments.size());
    }
}
