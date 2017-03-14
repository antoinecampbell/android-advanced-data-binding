package com.antoinecampbell.advanceddatabinding.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import com.antoinecampbell.advanceddatabinding.R;
import com.antoinecampbell.advanceddatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setData("A message bound to the MainActivity");
        binding.buttonSimpleBinding.setOnClickListener(this);
        binding.buttonTwoWayBinding.setOnClickListener(this);
        binding.buttonRecyclerviewBinding.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_simple_binding:
                startActivity(new Intent(this, SimpleBindingActivity.class));
                break;
            case R.id.button_two_way_binding:
                startActivity(new Intent(this, TwoWayBindingActivity.class));
                break;
            case R.id.button_recyclerview_binding:
                startActivity(new Intent(this, RecyclerviewBindingActivity.class));
                break;
            default:
                break;
        }
    }
}
