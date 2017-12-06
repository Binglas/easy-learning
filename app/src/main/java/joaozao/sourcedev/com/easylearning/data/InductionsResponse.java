package joaozao.sourcedev.com.easylearning.data;

import android.support.annotation.Keep;

import com.squareup.moshi.Json;

import java.util.List;

@Keep
public final class InductionsResponse {
    @Override
    public String toString() {
        return "InductionsResponse{" +
                "mInductionsList=" + mInductionsList +
                '}';
    }

    @Json(name = "inductions")
    private List<Induction> mInductionsList;

    public List<Induction> getInductionsList() {
        return mInductionsList;
    }
}
