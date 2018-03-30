package com.test.here.heretest.repository.database.dao;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.flixbus.flixbustest.domain.entities.Arrival;

@Entity(tableName = "arrivals")
public class ArrivalDBEntity implements Arrival {

    @PrimaryKey
    @ColumnInfo(name = "rideId")
    public final long rideId;

    @ColumnInfo(name = "line_number")
    @NonNull
    public final String lineNumber;

    @ColumnInfo(name = "direction")
    @NonNull
    public final String direction;

    @ColumnInfo(name = "time")
    public final long time;

    @ColumnInfo(name = "timezone")
    @NonNull
    public final String timezone;

    public ArrivalDBEntity(final long rideId, @NonNull final String lineNumber, @NonNull final String direction, final long time, @NonNull final String timezone) {
        this.rideId = rideId;
        this.lineNumber = lineNumber;
        this.direction = direction;
        this.time = time;
        this.timezone = timezone;
    }

    @Override
    public long getRideId() {
        return rideId;
    }

    @NonNull
    @Override
    public String getLineNumber() {
        return lineNumber;
    }

    @NonNull
    @Override
    public String getDirection() {
        return direction;
    }

    @Override
    public long getTimestamp() {
        return time;
    }

    @NonNull
    @Override
    public String getTimezone() {
        return timezone;
    }
}
