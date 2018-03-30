package com.test.here.heretest.domain.entities;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public interface License {

    @NonNull
    String getKey();

    @NonNull
    String getName();

    @Nullable
    String getSpdxId();

    @Nullable
    String getUrl();
}
