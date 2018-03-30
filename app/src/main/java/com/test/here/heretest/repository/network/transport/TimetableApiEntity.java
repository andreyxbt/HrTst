package com.test.here.heretest.repository.network.transport;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TimetableApiEntity {

    @SerializedName("arrivals")
    @Expose
    @NonNull
    public final List<RepositoryApiEntity> arrivals;

    @SerializedName("departures")
    @Expose
    @NonNull
    public final List<DepartureApiEntity> departures;

    public TimetableApiEntity(@NonNull final List<RepositoryApiEntity> arrivals, @NonNull final List<DepartureApiEntity> departures) {
        this.arrivals = arrivals;
        this.departures = departures;
    }
}
