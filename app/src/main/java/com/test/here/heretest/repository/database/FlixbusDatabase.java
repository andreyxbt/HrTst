package com.test.here.heretest.repository.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;

import com.flixbus.flixbustest.repository.database.dao.ArrivalDBEntity;
import com.flixbus.flixbustest.repository.database.dao.ArrivalsDao;
import com.flixbus.flixbustest.repository.database.dao.DepartureDBEntity;
import com.flixbus.flixbustest.repository.database.dao.DeparturesDao;

@Database(entities = {ArrivalDBEntity.class, DepartureDBEntity.class}, version = 1)
public abstract class FlixbusDatabase extends RoomDatabase {

    @NonNull
    public abstract ArrivalsDao arrivalsDao();

    @NonNull
    public abstract DeparturesDao departuresDao();
}
