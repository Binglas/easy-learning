package joaozao.sourcedev.com.easylearning.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;
import joaozao.sourcedev.com.easylearning.EasyLearningApplication;
import joaozao.sourcedev.com.easylearning.di.module.ActivityBindingModule;
import joaozao.sourcedev.com.easylearning.di.module.ApplicationModule;
import joaozao.sourcedev.com.easylearning.di.module.NetworkModule;

/**
 * This is a Dagger component. Refer to {@link EasyLearningApplication} for the list of Dagger components
 * used in this application.
 * <p>
 * Even though Dagger allows annotating a {@link Component} as a singleton, the code
 * itself must ensure only one instance of the class is created. This is done in {@link
 * EasyLearningApplication}.
 * //{@link AndroidSupportInjectionModule}
 * // is the module from Dagger.Android that helps with the generation
 * // and location of subcomponents.
 */
@Singleton
@Component(modules = {ApplicationModule.class,
        AndroidSupportInjectionModule.class,
        NetworkModule.class,
        ActivityBindingModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(EasyLearningApplication application);

    @Override
    void inject(DaggerApplication instance);

    // Gives us syntactic sugar. we can then do DaggerAppComponent.builder().application(this).build().inject(this);
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph now.
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();

    }

}
