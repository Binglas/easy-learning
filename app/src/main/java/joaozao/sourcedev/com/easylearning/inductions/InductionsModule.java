package joaozao.sourcedev.com.easylearning.inductions;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import joaozao.sourcedev.com.easylearning.di.qualifier.InductionsRequest;
import joaozao.sourcedev.com.easylearning.di.scope.ActivityScope;
import okhttp3.Request;

/**
 * This is a Dagger module. We use this to pass in the View dependency to the
 * {@link InductionsPresenter}.
 */
@Module
public abstract class InductionsModule {

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

}
