package joaozao.sourcedev.com.easylearning.inductions;


import android.support.annotation.NonNull;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import joaozao.sourcedev.com.easylearning.data.Induction;
import joaozao.sourcedev.com.easylearning.data.source.InductionsRepository;
import joaozao.sourcedev.com.easylearning.di.qualifier.TargetProcessRetrofit;
import joaozao.sourcedev.com.easylearning.inductions.service.UserStoriesService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class InductionsPresenter implements InductionsContract.Presenter{

    @Nullable
    private InductionsContract.View mInductionsView;
    private InductionsRepository mInductionsRepository;
    private Retrofit retrofit;

    @Inject
    InductionsPresenter(InductionsRepository inductionsRepository, @TargetProcessRetrofit Retrofit retrofit) {
        mInductionsRepository = inductionsRepository;
        this.retrofit = retrofit;
    }

    @Override
    public void loadInductions() {

        UserStoriesService userStoriesService = retrofit.create(UserStoriesService.class);

        userStoriesService.getUserStories().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                response.body();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });

        /*if (mInductionsView != null) {
            mInductionsView.setLoadingIndicator(true);
        }

        mInductionsRepository.getInductions(new InductionsDataSource.LoadInductionsCallback() {
            @Override
            public void onInductionsLoaded(List<Induction> inductions) {

                // The view may not be able to handle UI updates anymore
                if (mInductionsView == null || !mInductionsView.isActive()) {
                    return;
                }

                processInductions(inductions);

                mInductionsView.setLoadingIndicator(false);
            }

            @Override
            public void onDataNotAvailable() {
                processEmptyInductions();
            }
        });*/
    }

    private void processInductions(List<Induction> inductions) {
        if (inductions.isEmpty()) {
            // Show a message indicating there are no inductions for that filter type.
            processEmptyInductions();
        } else {
            // Show the list of inductions
            if (mInductionsView != null) {
                mInductionsView.showInductions(inductions);
            }
        }
    }

    private void processEmptyInductions() {
        if(mInductionsView == null) return;

        mInductionsView.showNoInductions();
    }

    @Override
    public void takeView(InductionsContract.View view) {
        this.mInductionsView = view;
        loadInductions();
    }

    @Override
    public void dropView() {
        mInductionsView = null;
    }
}
