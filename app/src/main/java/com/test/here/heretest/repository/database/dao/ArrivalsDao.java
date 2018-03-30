package com.test.here.heretest.repository.database.dao;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface ArrivalsDao {
    @Query("SELECT * FROM arrivals")
    DataSource.Factory<Integer, ArrivalDBEntity> getAllDataSource();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(ArrivalDBEntity... arrivals);

    @Query("DELETE FROM arrivals")
    void deleteAll();
}
