package com.antoinecampbell.advanceddatabinding.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.antoinecampbell.advanceddatabinding.R;
import com.antoinecampbell.advanceddatabinding.databinding.ActivityRecyclerviewBinding;
import com.antoinecampbell.advanceddatabinding.fragment.RecyclerviewBindingFragment;

public class RecyclerviewBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRecyclerviewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_recyclerview);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(binding.container.getId(), RecyclerviewBindingFragment.newInstance())
                    .commit();
        }
    }

}
