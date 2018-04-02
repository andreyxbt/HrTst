package com.test.here.heretest.domain.entities;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public interface Owner {

    @NonNull
    String getLogin();
    
    long getId();

    @NonNull
    String getAvatarUrl();

    @NonNull
    String getGravatarId();

    @NonNull
    String getUrl();

    @NonNull
    String getHtmlUrl();

    @NonNull
    String getFollowersUrl();

    @NonNull
    String getFollowingUrl();

    @NonNull
    String getGistsUrl();

    @NonNull
    String getStarredUrl();

    @NonNull
    String getSubscriptionsUrl();

    String getOrganizationsUrl();

    String getReposUrl();

    String getEventsUrl();

    String getReceivedEventsUrl();

    String getType();

    boolean isSiteAdmin();

    default boolean equals(@Nullable final Owner license) {
        return
    }
}
