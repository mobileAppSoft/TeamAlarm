package by.home.dartlen.dindindon.timepicker.time;

import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressWarnings("WeakerAccess")
public interface TimepointLimiter extends Parcelable {
    boolean isOutOfRange(@Nullable Timepoint point, int index, @NonNull Timepoint.TYPE resolution);

    boolean isAmDisabled();

    boolean isPmDisabled();

    @NonNull
    Timepoint roundToNearest(
            @NonNull Timepoint time,
            @Nullable Timepoint.TYPE type,
            @NonNull Timepoint.TYPE resolution
    );
}