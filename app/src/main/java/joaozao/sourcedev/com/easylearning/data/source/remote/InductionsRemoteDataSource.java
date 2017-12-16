package joaozao.sourcedev.com.easylearning.data.source.remote;

import android.support.annotation.NonNull;
import android.util.Log;

import com.ryanharter.auto.value.moshi.AutoValueMoshiAdapterFactory;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;

import javax.inject.Inject;

import joaozao.sourcedev.com.easylearning.data.InductionsResponse;
import joaozao.sourcedev.com.easylearning.data.source.InductionsDataSource;
import joaozao.sourcedev.com.easylearning.di.qualifier.DefaultOkHttpClient;
import joaozao.sourcedev.com.easylearning.di.qualifier.InductionsRequest;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class InductionsRemoteDataSource implements InductionsDataSource{

    private final JsonAdapter<InductionsResponse> mInductionsResponseJsonAdapter;
    private OkHttpClient mOkHttpClient;
    private Request mRequest;
    private InductionsResponse mInductionsResponse;

    @Inject
    public InductionsRemoteDataSource(@DefaultOkHttpClient OkHttpClient okHttpClient,
                                      @InductionsRequest Request request) {
        mOkHttpClient = okHttpClient;
        mRequest = request;

        mInductionsResponseJsonAdapter = new Moshi.Builder()
                .add(new AutoValueMoshiAdapterFactory())
                .build()
                .adapter(InductionsResponse.class);
    }

    @Override
    public void getInductions(@NonNull LoadInductionsCallback callback) {
        mOkHttpClient.newCall(mRequest).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onDataNotAvailable();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (!response.isSuccessful()) {
                    callback.onDataNotAvailable();
                }

                try {
                    mInductionsResponse = mInductionsResponseJsonAdapter.fromJson(response.body().string());
                    Log.d("_DEBUG", "Induction response: " + mInductionsResponse.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (mInductionsResponse != null) {
                        callback.onInductionsLoaded(mInductionsResponse.mInductionsList());
                    } else {
                        callback.onDataNotAvailable();
                    }
                    response.body().close();
                }

            }
        });
    }

    @Override
    public void getInduction(@NonNull String taskId, @NonNull GetInductionCallback callback) {

    }
}
