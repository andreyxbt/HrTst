package com.test.here.heretest.repository.database.dao;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface DeparturesDao {

    @Query("SELECT * FROM departures")
    DataSource.Factory<Integer, DepartureDBEntity> getAllDataSource();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(DepartureDBEntity... departures);

    @Query("DELETE FROM departures")
    void deleteAll();
}
