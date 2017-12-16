package joaozao.sourcedev.com.easylearning.data;

import android.support.annotation.Keep;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@Keep
@AutoValue
public abstract class Induction {

    public abstract String name();

    abstract String description();

    abstract String date();

    abstract String teacher();

    public static Induction create(String name, String description, String date, String teacher) {
        return new AutoValue_Induction(name, description, date, teacher);
    }

    public static JsonAdapter<Induction> jsonAdapter(Moshi moshi) {
        return new AutoValue_Induction.MoshiJsonAdapter(moshi);
    }

}
