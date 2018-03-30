package com.test.here.heretest.repository.database.utils;

import android.support.annotation.NonNull;

import com.flixbus.flixbustest.domain.entities.Arrival;
import com.flixbus.flixbustest.repository.database.dao.ArrivalDBEntity;

import java.util.List;

public final class ArrivalDBMatcher {

    ArrivalDBMatcher() {
    }

    @NonNull
    public static ArrivalDBEntity[] toDbArrivals(@NonNull final List<? extends Arrival> arrivals) {
        final ArrivalDBEntity[] entities = new ArrivalDBEntity[arrivals.size()];
        for (int i = 0; i < arrivals.size(); i++) {
            entities[i] = from(arrivals.get(i));
        }
        return entities;
    }

    @NonNull
    public static ArrivalDBEntity from(@NonNull final Arrival arrival) {
        return new ArrivalDBEntity(
                arrival.getRideId(),
                arrival.getLineNumber(),
                arrival.getDirection(),
                arrival.getTimestamp(),
                arrival.getTimezone()
        );
    }
}
