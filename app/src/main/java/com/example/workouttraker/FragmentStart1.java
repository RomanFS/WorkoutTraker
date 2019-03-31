package com.example.workouttraker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentStart1 extends Fragment implements View.OnClickListener {
    private Button male, female;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        male = (Button) view.findViewById(R.id.male);
        female = (Button) view.findViewById(R.id.female);
        male.setOnClickListener(this);
        female.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.male:
                male.setBackgroundResource(R.drawable.male_focus);
                female.setBackgroundResource(R.drawable.female);
                break;
            case R.id.female:
                female.setBackgroundResource(R.drawable.female_focus);
                male.setBackgroundResource(R.drawable.male);
                break;
        }
    }
}
