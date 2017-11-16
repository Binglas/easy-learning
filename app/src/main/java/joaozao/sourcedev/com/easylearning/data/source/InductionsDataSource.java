package joaozao.sourcedev.com.easylearning.data.source;

import android.support.annotation.NonNull;

import java.util.List;

import joaozao.sourcedev.com.easylearning.data.Induction;

public interface InductionsDataSource {

    interface LoadInductionsCallback {

        void onInductionsLoaded(List<Induction> tasks);

        void onDataNotAvailable();
    }

    interface GetInductionCallback {

        void onInductionLoaded(Induction task);

        void onDataNotAvailable();
    }

    void getInductions(@NonNull LoadInductionsCallback callback);

    void getInduction(@NonNull String taskId, @NonNull GetInductionCallback callback);
}
