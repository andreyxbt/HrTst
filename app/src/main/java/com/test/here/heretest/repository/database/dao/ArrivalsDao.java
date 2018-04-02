package com.test.here.heretest.repository.database.dao;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface ArrivalsDao {
    @Query("SELECT * FROM RepositoryDBEntity")
    DataSource.Factory<Integer, RepositoryDBEntity> getAllDataSource();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(RepositoryDBEntity... arrivals);

    @Query("DELETE FROM RepositoryDBEntity")
    void deleteAll();
}
