package joaozao.sourcedev.com.easylearning.data;

import android.support.annotation.Keep;

import com.squareup.moshi.Json;

@Keep
public class Induction {

    public String getmInductionName() {
        return mInductionName;
    }

    public void setmInductionName(String mInductionName) {
        this.mInductionName = mInductionName;
    }

    public String getmInductionDescription() {
        return mInductionDescription;
    }

    public void setmInductionDescription(String mInductionDescription) {
        this.mInductionDescription = mInductionDescription;
    }

    public String getmInductionDate() {
        return mInductionDate;
    }

    public void setmInductionDate(String mInductionDate) {
        this.mInductionDate = mInductionDate;
    }

    public String getmInductionTecher() {
        return mInductionTecher;
    }

    public void setmInductionTecher(String mInductionTecher) {
        this.mInductionTecher = mInductionTecher;
    }

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
