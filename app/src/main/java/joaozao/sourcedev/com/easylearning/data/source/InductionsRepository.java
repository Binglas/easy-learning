package joaozao.sourcedev.com.easylearning.data.source;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import joaozao.sourcedev.com.easylearning.data.Induction;

public class InductionsRepository implements InductionsDataSource{

    private InductionsDataSource mInductionsRemoteDataSource;

    @Inject
    InductionsRepository(@Remote InductionsDataSource inductionsRemoteDataSource) {
        mInductionsRemoteDataSource = inductionsRemoteDataSource;
    }

    @Override
    public void getInductions(@NonNull LoadInductionsCallback callback) {
        mInductionsRemoteDataSource.getInductions(new LoadInductionsCallback() {
            @Override
            public void onInductionsLoaded(List<Induction> inductions) {

            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void getInduction(@NonNull String taskId, @NonNull GetInductionCallback callback) {

    }
}
