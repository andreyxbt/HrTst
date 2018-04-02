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
import com.flixbus.flixbustest.domain.entities.Arrival;
import com.flixbus.flixbustest.domain.interactor.ArrivalsInteractor;

import io.reactivex.disposables.Disposable;

public class RepositoriesViewModel extends ViewModel {

    @NonNull
    private final ArrivalsInteractor arrivalsInteractor;
    @NonNull
    private final MutableLiveData<ConnectionStatus> connectionStatus;
    @NonNull
    private final MutableLiveData<Boolean> updating;
    @Nullable
    private Disposable updateDisposable;
    @Nullable
    private Disposable softUpdateDisposable;
    @Nullable
    private LiveData<PagedList<Arrival>> arrivals;

    public RepositoriesViewModel() {
        updating = new MutableLiveData<>();
        arrivalsInteractor = new ArrivalsInteractor(FlixbusApp.getInstance().getRepository());
        connectionStatus = new MutableLiveData<>();
    }

    private static void dispose(@Nullable final Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @NonNull
    public LiveData<PagedList<Arrival>> getArrivals() {
        if (arrivals == null) {
            final DataSource.Factory<Integer, Arrival> factory = arrivalsInteractor.getArrivals();
            softUpdateArrivals();
            arrivals = new LivePagedListBuilder<>(factory, 20).build();
        }
        return arrivals;
    }

    @NonNull
    public LiveData<Boolean> getUpdating() {
        return updating;
    }

    @NonNull
    public LiveData<ConnectionStatus> getConnectionError() {
        return connectionStatus;
    }

    public void softUpdateArrivals() {
        if (softUpdateDisposable == null || softUpdateDisposable.isDisposed()) {
            updating.postValue(true);
            softUpdateDisposable = arrivalsInteractor
                    .softUpdate()
                    .doFinally(() -> {
                        dispose(softUpdateDisposable);
                        updating.postValue(false);
                    })
                    .subscribe(
                            () -> connectionStatus.postValue(
                                    new ConnectionStatus("updated: " + DateHelper.format(arrivalsInteractor.getLastUpdateTime()))
                            ),
                            throwable -> connectionStatus.postValue(new ConnectionStatus("Error", throwable))
                    );
        }
    }

    public void updateArrivals() {
        if (updateDisposable == null || updateDisposable.isDisposed()) {
            updating.postValue(true);
            updateDisposable = arrivalsInteractor
                    .update()
                    .doFinally(() -> {
                        dispose(softUpdateDisposable);
                        updating.postValue(false);
                    })
                    .subscribe(
                            () -> connectionStatus.postValue(
                                    new ConnectionStatus("updated: " + DateHelper.format(arrivalsInteractor.getLastUpdateTime()))
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
