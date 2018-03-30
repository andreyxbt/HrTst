package com.test.here.heretest.repository.providers;

import android.support.annotation.NonNull;

import com.flixbus.flixbustest.repository.database.FlixbusDatabase;

public interface DatabaseFactory {
    @NonNull
    FlixbusDatabase getDatabase();
}
