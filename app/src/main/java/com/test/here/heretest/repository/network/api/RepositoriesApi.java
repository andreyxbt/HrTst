package com.test.here.heretest.repository.network.api;

import com.test.here.heretest.domain.entities.Repository;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RepositoriesApi {

    @GET("/users/heremaps/repos")
    Observable<List<Repository>> getRepositoriesObservable();
}
