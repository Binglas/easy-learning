package joaozao.sourcedev.com.easylearning;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import joaozao.sourcedev.com.easylearning.di.component.AppComponent;
import joaozao.sourcedev.com.easylearning.di.component.DaggerAppComponent;

public class ELApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }

}
