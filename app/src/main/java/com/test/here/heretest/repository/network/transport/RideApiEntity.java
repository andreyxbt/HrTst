package com.test.here.heretest.repository.network.transport;

import android.support.annotation.NonNull;

import com.flixbus.flixbustest.domain.entities.Ride;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RideApiEntity implements Ride {

    @SerializedName("ride_id")
    @Expose
    public final long rideId;

    @SerializedName("datetime")
    @Expose
    @NonNull
    public final DatetimeApiEntity datetime;

    @SerializedName("line_code")
    @Expose
    @NonNull
    public final String lineCode;

    @SerializedName("direction")
    @Expose
    @NonNull
    public final String direction;

    public RideApiEntity(final long rideId, @NonNull final DatetimeApiEntity datetime, @NonNull final String lineCode, @NonNull final String direction) {
        this.rideId = rideId;
        this.datetime = datetime;
        this.lineCode = lineCode;
        this.direction = direction;
    }

    @Override
    public long getRideId() {
        return rideId;
    }

    @NonNull
    @Override
    public String getLineNumber() {
        return lineCode;
    }

    @NonNull
    @Override
    public String getDirection() {
        return direction;
    }

    @Override
    public long getTimestamp() {
        return datetime.timestamp;
    }

    @NonNull
    @Override
    public String getTimezone() {
        return datetime.timezone;
    }
}
