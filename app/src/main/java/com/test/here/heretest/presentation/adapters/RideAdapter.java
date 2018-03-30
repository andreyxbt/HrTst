package com.test.here.heretest.presentation.adapters;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.recyclerview.extensions.DiffCallback;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flixbus.flixbustest.R;
import com.flixbus.flixbustest.domain.entities.Ride;
import com.flixbus.flixbustest.presentation.DateHelper;

public class RideAdapter<T extends Ride> extends PagedListAdapter<T, RideAdapter.ViewHolder> {

    public RideAdapter(@NonNull final DiffCallback<T> diffCallback) {
        super(diffCallback);
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ride, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final T ride = getItem(position);
        if (ride != null) {
            holder.bindTo(ride, position);
        } else {
            holder.clear();
        }
    }

    public T getItem(final int position) {
        return super.getItem(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @NonNull
        final TextView direction;
        @NonNull
        final TextView lineNumber;
        @NonNull
        final TextView time;
        @NonNull
        final TextView positionView;
        @NonNull
        final View rootView;

        ViewHolder(@NonNull final View itemView) {
            super(itemView);
            direction = itemView.findViewById(R.id.direction);
            lineNumber = itemView.findViewById(R.id.line_number);
            time = itemView.findViewById(R.id.time);
            positionView = itemView.findViewById(R.id.position);
            rootView = itemView;
        }

        private void bindTo(@NonNull final Ride ride, final int position) {
            positionView.setText(String.valueOf(position));
            direction.setText(ride.getDirection());
            lineNumber.setText(ride.getLineNumber());
            time.setText(DateHelper.format(ride.getTimestamp() * 1000, ride.getTimezone()));
            final int colorId = position % 2 == 0 ? R.color.timetable_list_item_1 : R.color.timetable_list_item_2;
            rootView.setBackgroundColor(ContextCompat.getColor(rootView.getContext(), colorId));
        }

        private void clear() {
            positionView.setText("");
            direction.setText("");
            lineNumber.setText("");
            time.setText("");
            rootView.setBackgroundColor(ContextCompat.getColor(rootView.getContext(), android.R.color.transparent));
        }
    }
}
