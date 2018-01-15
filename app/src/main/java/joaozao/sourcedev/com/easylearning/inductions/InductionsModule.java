package joaozao.sourcedev.com.easylearning.inductions;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import joaozao.sourcedev.com.easylearning.di.qualifier.DefaultOkHttpClient;
import joaozao.sourcedev.com.easylearning.di.qualifier.InductionsRequest;
import joaozao.sourcedev.com.easylearning.di.qualifier.TargetProcessOkHttpClient;
import joaozao.sourcedev.com.easylearning.di.qualifier.TargetProcessRetrofit;
import joaozao.sourcedev.com.easylearning.di.scope.ActivityScope;
import joaozao.sourcedev.com.easylearning.di.scope.FragmentScope;
import joaozao.sourcedev.com.easylearning.inductions.interceptor.AuthenticationInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;

/**
 * This is a Dagger module. We use this to pass in the View dependency to the
 * {@link InductionsPresenter}.
 */
@Module
public abstract class InductionsModule {

    private static final String TARGET_PROCESS_BASE_URL = "https://ppb.tpondemand.com/api/v1/";
    private static final String TARGET_PROCESS_ACCESS_TOKEN =
            "MTQ5MTp4bG9aUXVPRk1IOWlVdGJKTTNjL3pCY0xxMWNRcUpQL21kcHBTRGRYMG5zPQ==";

    @FragmentScope
    @ContributesAndroidInjector
    abstract InductionsFragment inductionsFragment();

    @ActivityScope
    @Binds
    abstract InductionsContract.Presenter inductionPresenter(InductionsPresenter presenter);

    @Provides
    @ActivityScope
    @InductionsRequest
    static Request providesInductionsRequest() {
        return new Request.Builder().url("https://drive.google.com/uc?" +
                "authuser=0&id=1sMSltMnb1z_QhbZmr_conPAS_xzusAXN&export=download").build();
    }

    @Provides
    @ActivityScope
    @TargetProcessOkHttpClient
    static OkHttpClient providesTargetProcessOkHttpClient(@DefaultOkHttpClient OkHttpClient okHttpClient) {
        AuthenticationInterceptor authenticationInterceptor =
                new AuthenticationInterceptor(TARGET_PROCESS_ACCESS_TOKEN);

        return okHttpClient.newBuilder()
                .addInterceptor(authenticationInterceptor)
                .build();
    }

    @Provides
    @ActivityScope
    @TargetProcessRetrofit
    static Retrofit providesTargetProcessRetrofit(@TargetProcessOkHttpClient OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(TARGET_PROCESS_BASE_URL)
                .build();
    }

}
