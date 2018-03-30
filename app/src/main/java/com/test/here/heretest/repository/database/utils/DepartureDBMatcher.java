package com.test.here.heretest.repository.database.utils;

import android.support.annotation.NonNull;

import com.flixbus.flixbustest.domain.entities.Departure;
import com.flixbus.flixbustest.repository.database.dao.DepartureDBEntity;

import java.util.List;

public final class DepartureDBMatcher {

    DepartureDBMatcher() {
    }

    @NonNull
    public static DepartureDBEntity[] toDbDepartures(@NonNull final List<? extends Departure> departures) {
        final DepartureDBEntity[] entities = new DepartureDBEntity[departures.size()];
        for (int i = 0; i < departures.size(); i++) {
            entities[i] = from(departures.get(i));
        }
        return entities;
    }

    @NonNull
    public static DepartureDBEntity from(@NonNull final Departure departure) {
        return new DepartureDBEntity(
                departure.getRideId(),
                departure.getLineNumber(),
                departure.getDirection(),
                departure.getTimestamp(),
                departure.getTimezone()
        );
    }
}
