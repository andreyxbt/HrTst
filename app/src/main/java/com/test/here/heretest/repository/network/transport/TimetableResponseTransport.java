package com.test.here.heretest.repository.network.transport;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimetableResponseTransport {

    @SerializedName("timetable")
    @Expose
    @NonNull
    public final TimetableApiEntity timetable;

    public TimetableResponseTransport(@NonNull final TimetableApiEntity timetable) {
        this.timetable = timetable;
    }
}
