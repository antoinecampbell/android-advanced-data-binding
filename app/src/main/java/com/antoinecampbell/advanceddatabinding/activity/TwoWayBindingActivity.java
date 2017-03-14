package com.antoinecampbell.advanceddatabinding.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.antoinecampbell.advanceddatabinding.R;
import com.antoinecampbell.advanceddatabinding.databinding.ActivityTwoWayBinding;
import com.antoinecampbell.advanceddatabinding.domain.TwoWayBindingForm;

import org.parceler.Parcels;

public class TwoWayBindingActivity extends AppCompatActivity implements LoginActionCallback {

    private static final String ARG_FORM = "ARG_FORM";

    private TwoWayBindingForm form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTwoWayBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way);

        if (savedInstanceState != null) {
            form = Parcels.unwrap(savedInstanceState.getParcelable(ARG_FORM));
        } else {
            form = new TwoWayBindingForm();
        }

        binding.setData(form);
        binding.setCallback(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(ARG_FORM, Parcels.wrap(form));
    }

    @Override
    public void onLoginClicked() {
        this.finish();
    }
}
