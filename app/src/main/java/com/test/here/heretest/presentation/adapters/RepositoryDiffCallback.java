package com.test.here.heretest.presentation.adapters;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.DiffCallback;

import com.flixbus.flixbustest.domain.entities.Ride;
import com.flixbus.flixbustest.domain.eqality.RideEqualitator;

public class RepositoryDiffCallback<T extends Ride> extends DiffCallback<T> {

    @NonNull
    private final RideEqualitator<T> equalitator;

    public RepositoryDiffCallback(@NonNull final RideEqualitator<T> equalitator) {
        this.equalitator = equalitator;
    }

    @Override
    public boolean areItemsTheSame(@NonNull final T oldItem, @NonNull final T newItem) {
        return oldItem.getRideId() == newItem.getRideId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull final T oldItem, @NonNull final T newItem) {
        return equalitator.isEquals(oldItem, newItem);
    }
}
