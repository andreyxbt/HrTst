package com.test.here.heretest.domain.eqality;

import android.support.annotation.Nullable;

import com.flixbus.flixbustest.domain.entities.Ride;

public class RideEqualitator<T extends Ride> implements Equalitator<T> {

    public boolean isEquals(@Nullable final T left, @Nullable final T right) {
        if (left == right) {
            return true;
        }
        if (left != null && right == null || left == null || left.getClass() != right.getClass()) {
            return false;
        }

        if (left.getRideId() != right.getRideId()) {
            return false;
        }
        if (left.getTimestamp() != right.getTimestamp()) {
            return false;
        }
        if (!left.getLineNumber().equals(right.getLineNumber())) {
            return false;
        }
        if (!left.getDirection().equals(right.getDirection())) {
            return false;
        }
        return left.getTimezone().equals(right.getTimezone());
    }
}
