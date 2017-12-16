package joaozao.sourcedev.com.easylearning.data;

import android.support.annotation.Keep;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

@Keep
@AutoValue
public abstract class InductionsResponse {

    @Json(name = "inductions")
    public abstract List<Induction> mInductionsList();

    public static InductionsResponse create(List<Induction> inductionsList) {
        return new AutoValue_InductionsResponse(inductionsList);
    }

    public static JsonAdapter<InductionsResponse> jsonAdapter(Moshi moshi) {
        return new AutoValue_InductionsResponse.MoshiJsonAdapter(moshi);
    }

}
