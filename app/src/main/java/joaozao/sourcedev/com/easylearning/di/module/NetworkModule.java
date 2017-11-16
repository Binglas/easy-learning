package joaozao.sourcedev.com.easylearning.di.module;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import joaozao.sourcedev.com.easylearning.di.qualifier.DefaultOkHttpClient;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

@Module
public class NetworkModule {

    private static final int DEFAULT_CACHE_SIZE = 10 * 1024 * 1024; // 10 Mib
    private static final int DEFAULT_TIMEOUT = 30; // Seconds

    private NetworkModule() {
        // Disallow instantiation with empty private constructor
    }

    @Provides
    @Singleton
    static Cache provideOkHttpCache(Application application) {
        return new Cache(application.getCacheDir(), DEFAULT_CACHE_SIZE);
    }

    @Provides
    @Singleton
    @DefaultOkHttpClient
    static OkHttpClient provideDefaultOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

}
