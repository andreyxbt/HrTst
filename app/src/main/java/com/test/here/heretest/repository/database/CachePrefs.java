package com.test.here.heretest.repository.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public class CachePrefs {

    @NonNull
    private static final String PREFS_NAME = "cache_prefs";
    @NonNull
    private static final String KEY_CACHE_TIMESTAMP = "key_cache_timestamp";
    @NonNull
    private final SharedPreferences preferences;

    private CachePrefs(@NonNull final SharedPreferences preferences) {
        this.preferences = preferences;
    }

    @NonNull
    public static CachePrefs from(@NonNull final Context context) {
        final SharedPreferences preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return new CachePrefs(preferences);
    }

    public long getCacheTimestamp() {
        return preferences.getLong(KEY_CACHE_TIMESTAMP, 0);
    }

    public void setCacheTimestamp(final long timestamp) {
        preferences.edit().putLong(KEY_CACHE_TIMESTAMP, timestamp).apply();
    }
}
