package joaozao.sourcedev.com.easylearning.data;

import android.support.annotation.Keep;

import com.squareup.moshi.Json;

@Keep
public class Induction {

    @Json(name = "name")
    private String mInductionName;

    @Json(name = "description")
    private String mInductionDescription;

    @Json(name = "date")
    private String mInductionDate;

    @Json(name = "teacher")
    private String mInductionTecher;

    @Override
    public String toString() {
        return "Induction{" +
                "mInductionName='" + mInductionName + '\'' +
                ", mInductionDescription='" + mInductionDescription + '\'' +
                ", mInductionDate='" + mInductionDate + '\'' +
                ", mInductionTecher='" + mInductionTecher + '\'' +
                '}';
    }
}
