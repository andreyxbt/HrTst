package com.test.here.heretest.repository.database.dao;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.flixbus.flixbustest.domain.entities.Arrival;
import com.test.here.heretest.domain.entities.Owner;
import com.test.here.heretest.domain.entities.Repository;

import io.reactivex.annotations.Nullable;

@Entity(tableName = "arrivals")
public class RepositoryDBEntity implements Repository {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private final long id;

    @ColumnInfo(name = "name")
    private final String name;

    @ColumnInfo(name = "full_name")
    private final String fullName();

    @ColumnInfo(name = "owner")
    private final Owner getOwner();

    boolean isPrivate();

    String getHtmlUrl();

    String getDescription();

    boolean isFork();

    String getUrl();

    String getCreatedAt();

    String getUpdatedAt();

    String getPushedAt();

    String getGitUrl();

    String getSshUrl();

    String getCloneUrl();

    @Nullable
    String getSvnUrl();

    @Nullable
    String getHomepage();

    long getSize();

    @Nullable
    String getLanguage();

    public RepositoryDBEntity(final long id, @NonNull final String lineNumber, @NonNull final String direction, final long time, @NonNull final String timezone) {
        this.id = id;
        this.lineNumber = lineNumber;
        this.direction = direction;
        this.time = time;
        this.timezone = timezone;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getFullName() {
        return null;
    }

    @Override
    public Owner getOwner() {
        return null;
    }

    @Override
    public boolean isPrivate() {
        return false;
    }

    @Override
    public String getHtmlUrl() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public boolean isFork() {
        return false;
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public String getCreatedAt() {
        return null;
    }

    @Override
    public String getUpdatedAt() {
        return null;
    }

    @Override
    public String getPushedAt() {
        return null;
    }

    @Override
    public String getGitUrl() {
        return null;
    }

    @Override
    public String getSshUrl() {
        return null;
    }

    @Override
    public String getCloneUrl() {
        return null;
    }

    @Override
    public String getSvnUrl() {
        return null;
    }

    @Override
    public String getHomepage() {
        return null;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public String getLanguage() {
        return null;
    }
}
