package com.antoinecampbell.advanceddatabinding.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.antoinecampbell.advanceddatabinding.R;
import com.antoinecampbell.advanceddatabinding.databinding.ActivitySimpleBinding;
import com.antoinecampbell.advanceddatabinding.domain.SimpleBindingUser;

public class SimpleBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySimpleBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_simple);

        SimpleBindingUser user = new SimpleBindingUser();
        user.setName("Bill Murray");
        user.setImageUrl("http://fillmurray.com/400/400");
        user.setDescription("Actor");

        binding.setData(user);
    }
}
