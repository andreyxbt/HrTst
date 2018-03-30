package com.test.here.heretest.repository;

import android.support.annotation.NonNull;

import com.flixbus.flixbustest.repository.database.CachePrefs;

public class CacheHelper {

    private final long cacheTtlMillis;
    @NonNull
    private final CachePrefs prefs;

    public CacheHelper(@NonNull final CachePrefs prefs, final long cacheTtlMillis) {
        this.cacheTtlMillis = cacheTtlMillis;
        this.prefs = prefs;
    }

    public long getCacheTimestamp() {
        return prefs.getCacheTimestamp();
    }

    public void setCacheTimestamp(final long timestamp) {
        prefs.setCacheTimestamp(timestamp);
    }

    public boolean isCacheValid(final long timestamp) {
        return timestamp - prefs.getCacheTimestamp() < cacheTtlMillis;
    }
}
