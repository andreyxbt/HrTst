package com.test.here.heretest.domain.eqality;

import android.support.annotation.Nullable;

public interface Equalitator<T> {
    boolean isEquals(@Nullable T left, @Nullable T right);
}
