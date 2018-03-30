package com.test.here.heretest.presentation.ui;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flixbus.flixbustest.R;
import com.flixbus.flixbustest.domain.entities.Arrival;
import com.flixbus.flixbustest.domain.eqality.RideEqualitator;
import com.flixbus.flixbustest.presentation.ArrivalsViewModel;
import com.flixbus.flixbustest.presentation.adapters.RideAdapter;
import com.flixbus.flixbustest.presentation.adapters.RideDiffCallback;

public class ArrivalsFragment extends Fragment {

    private ArrivalsViewModel arrivalsViewModel;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrivalsViewModel = ViewModelProviders.of(this).get(ArrivalsViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_rides_list, container, false);
        final RecyclerView recyclerView = rootView.findViewById(R.id.rides_recycler_view);
        recyclerView.setTag(getString(R.string.page_title_arrivals));
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        final RideAdapter<Arrival> adapter = new RideAdapter<>(new RideDiffCallback<>(new RideEqualitator<>()));

        arrivalsViewModel.getArrivals().observe(this, adapter::setList);
        recyclerView.setAdapter(adapter);

        final SwipeRefreshLayout swipeRefreshLayout = rootView.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(arrivalsViewModel::updateArrivals);
        arrivalsViewModel.getUpdating().observe(this, swipeRefreshLayout::setRefreshing);
        final TextView updateStatus = rootView.findViewById(R.id.update_status);
        arrivalsViewModel.getConnectionError().observe(this, connectionStatus -> {
            if (connectionStatus != null) {
                updateStatus.setText(connectionStatus.message);
                updateStatus.setVisibility(View.VISIBLE);
            } else {
                updateStatus.setVisibility(View.GONE);
            }
        });
        return rootView;
    }
}
