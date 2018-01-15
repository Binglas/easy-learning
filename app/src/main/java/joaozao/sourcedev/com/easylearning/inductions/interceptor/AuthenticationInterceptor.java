package joaozao.sourcedev.com.easylearning.inductions.interceptor;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor {

    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String HEADER_ACCEPT = "Accept";

    private String authToken;

    public AuthenticationInterceptor(String token) {
        this.authToken = token;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder builder = original.newBuilder()
                .header(HEADER_AUTHORIZATION, "Bearer " + authToken)
                .header(HEADER_ACCEPT, "application/json")
                .method(original.method(), original.body());

        Request request = builder.build();
        return chain.proceed(request);
    }
}