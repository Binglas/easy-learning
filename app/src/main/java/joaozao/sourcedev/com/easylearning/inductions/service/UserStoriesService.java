package joaozao.sourcedev.com.easylearning.inductions.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UserStoriesService {

    @GET("UserStories/?access_token=MTQ5MTp4bG9aUXVPRk1IOWlVdGJKTTNjL3pCY0xxMWNRcUpQL21kcHBTRGRYMG5zPQ==")
    Call<ResponseBody> getUserStories();
}
