package com.antoinecampbell.advanceddatabinding.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antoinecampbell.advanceddatabinding.databinding.FragmentRecyclerviewBinding;
import com.antoinecampbell.advanceddatabinding.domain.RecyclerviewFragmentViewModel;
import com.antoinecampbell.advanceddatabinding.domain.recycler.NetowrkUser;
import com.antoinecampbell.advanceddatabinding.fragment.RecyclerviewAdapter.ActionCallback;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RecyclerviewBindingFragment extends Fragment implements ActionCallback {

    RecyclerviewFragmentViewModel viewModel;
    RecyclerviewAdapter adapter;
    private Random random = new Random();

    public static RecyclerviewBindingFragment newInstance() {
        return new RecyclerviewBindingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentRecyclerviewBinding binding = FragmentRecyclerviewBinding.inflate(inflater, container, false);
        viewModel = new RecyclerviewFragmentViewModel();
        adapter = new RecyclerviewAdapter(this);

        binding.setData(viewModel);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerview.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        binding.recyclerview.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadUsers();
    }

    private void loadUsers() {
        viewModel.setLoading(true);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                viewModel.setLoading(false);
                List<NetowrkUser> users = Arrays.asList(
                        new NetowrkUser("Bill Murray", "http://fillmurray.com/406/406"),
                        new NetowrkUser("Bill Murray", "http://fillmurray.com/405/405"),
                        new NetowrkUser("Bill Murray", "http://fillmurray.com/404/404"),
                        new NetowrkUser("Bill Murray", "http://fillmurray.com/403/403"),
                        new NetowrkUser("Bill Murray", "http://fillmurray.com/401/401"));
                adapter.addUsers(users);
                adapter.setUpdatingUserItem(new NetowrkUser("Bill Murray", "http://fillmurray.com/401/401"));
            }
        }, 2000);
    }

    @Override
    public void onUpdateClicked() {
        viewModel.setLoading(true);
        int size = random.nextInt(101) + 300;
        final String imageUrl = "http://fillmurray.com/" + size + "/" + size;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                viewModel.setLoading(false);
                adapter.setUpdatingUserItem(new NetowrkUser("Bill Murray", imageUrl));
            }
        }, 2000);
    }
}
