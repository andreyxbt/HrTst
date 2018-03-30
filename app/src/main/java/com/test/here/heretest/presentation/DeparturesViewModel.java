package com.test.here.heretest.presentation;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.DataSource;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.flixbus.flixbustest.FlixbusApp;
import com.flixbus.flixbustest.domain.entities.Departure;
import com.flixbus.flixbustest.domain.interactor.DeparturesInteractor;

import io.reactivex.disposables.Disposable;

public class DeparturesViewModel extends ViewModel {

    @NonNull
    private final DeparturesInteractor departuresInteractor;
    @NonNull
    private final MutableLiveData<ConnectionStatus> connectionStatus;
    @NonNull
    private final MutableLiveData<Boolean> updating;
    @Nullable
    private Disposable updateDisposable;
    @Nullable
    private Disposable softUpdateDisposable;
    @Nullable
    private LiveData<PagedList<Departure>> departures;

    public DeparturesViewModel() {
        connectionStatus = new MutableLiveData<>();
        updating = new MutableLiveData<>();
        departuresInteractor = new DeparturesInteractor(FlixbusApp.getInstance().getRepository());
    }

    private static void dispose(@Nullable final Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @NonNull
    public LiveData<PagedList<Departure>> getDepartures() {
        if (departures == null) {
            final DataSource.Factory<Integer, Departure> factory = departuresInteractor.getDepartures();
            softUpdateDepartures();
            departures = new LivePagedListBuilder<>(factory, 20).build();
        }
        return departures;
    }

    @NonNull
    public LiveData<Boolean> getUpdating() {
        return updating;
    }

    @NonNull
    public LiveData<ConnectionStatus> getConnectionError() {
        return connectionStatus;
    }

    public void softUpdateDepartures() {
        if (softUpdateDisposable == null || softUpdateDisposable.isDisposed()) {
            updating.postValue(true);
            softUpdateDisposable = departuresInteractor
                    .softUpdate()
                    .doFinally(() -> {
                        dispose(softUpdateDisposable);
                        updating.postValue(false);
                    })
                    .subscribe(
                            () -> connectionStatus.postValue(
                                    new ConnectionStatus("updated: " + DateHelper.format(departuresInteractor.getLastUpdateTime()))
                            ),
                            throwable -> connectionStatus.postValue(new ConnectionStatus("Error", throwable))
                    );
        }
    }

    public void updateDepartures() {
        if (updateDisposable == null || updateDisposable.isDisposed()) {
            updating.postValue(true);
            updateDisposable = departuresInteractor
                    .update()
                    .doFinally(() -> {
                        dispose(softUpdateDisposable);
                        updating.postValue(false);
                    })
                    .subscribe(
                            () -> connectionStatus.postValue(
                                    new ConnectionStatus("updated: " + DateHelper.format(departuresInteractor.getLastUpdateTime()))
                            ),
                            throwable -> connectionStatus.postValue(new ConnectionStatus("Error", throwable))
                    );
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        dispose(updateDisposable);
        dispose(softUpdateDisposable);
    }
}
