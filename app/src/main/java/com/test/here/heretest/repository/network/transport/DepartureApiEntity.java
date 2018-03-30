package com.test.here.heretest.repository.network.transport;

import android.support.annotation.NonNull;

import com.flixbus.flixbustest.domain.entities.Departure;

public class DepartureApiEntity extends RideApiEntity implements Departure {

    public DepartureApiEntity(final long rideId, @NonNull final DatetimeApiEntity datetime, @NonNull final String lineCode, @NonNull final String direction) {
        super(rideId, datetime, lineCode, direction);
    }
}
