package com.test.here.heretest.repository.database;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;

import com.flixbus.flixbustest.repository.providers.DatabaseFactory;

public class DatabaseFactoryImpl implements DatabaseFactory {

    @NonNull
    private final Context context;
    private final String databaseName;

    public DatabaseFactoryImpl(@NonNull final Context context, @NonNull final String databaseName) {
        this.context = context.getApplicationContext();
        this.databaseName = databaseName;
    }

    @NonNull
    public FlixbusDatabase getDatabase() {
        return Room.databaseBuilder(context, FlixbusDatabase.class, databaseName).build();
    }
}
