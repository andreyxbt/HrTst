
package com.test.here.heretest.repository.network.transport;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatetimeApiEntity {

    @SerializedName("timestamp")
    @Expose
    public final long timestamp;

    @SerializedName("tz")
    @Expose
    @NonNull
    public final String timezone;

    public DatetimeApiEntity(final long timestamp, @NonNull final String timezone) {
        this.timestamp = timestamp;
        this.timezone = timezone;
    }
}
