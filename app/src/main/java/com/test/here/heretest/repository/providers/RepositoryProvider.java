package com.test.here.heretest.repository.providers;

import android.support.annotation.NonNull;

import com.flixbus.flixbustest.domain.TimetableRepository;

public interface RepositoryProvider {

    void inject(@NonNull TimetableRepository repository);

    @NonNull
    TimetableRepository getRepository();
}
