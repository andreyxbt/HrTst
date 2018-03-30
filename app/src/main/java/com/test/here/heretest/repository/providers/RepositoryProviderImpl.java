package com.test.here.heretest.repository.providers;

import android.support.annotation.NonNull;

import com.flixbus.flixbustest.domain.TimetableRepository;

public class RepositoryProviderImpl implements RepositoryProvider {

    @NonNull
    private TimetableRepository repository;

    public RepositoryProviderImpl(@NonNull final TimetableRepository repository) {
        this.repository = repository;
    }

    @Override
    public void inject(@NonNull final TimetableRepository repository) {
        throw new SecurityException("Unable to inject repository!");
    }

    @NonNull
    public TimetableRepository getRepository() {
        return repository;
    }
}
