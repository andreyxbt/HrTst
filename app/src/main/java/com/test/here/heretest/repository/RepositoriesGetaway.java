package com.test.here.heretest.repository;

import com.flixbus.flixbustest.repository.network.transport.TimetableApiEntity;
import com.test.here.heretest.domain.entities.Repository;

import java.util.List;

import io.reactivex.Observable;

public interface RepositoriesGetaway {
    Observable<List<Repository>> getTimetable();
}
