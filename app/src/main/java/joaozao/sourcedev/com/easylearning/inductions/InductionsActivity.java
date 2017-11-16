package joaozao.sourcedev.com.easylearning.inductions;

import android.os.Bundle;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import joaozao.sourcedev.com.easylearning.R;

public class InductionsActivity extends DaggerAppCompatActivity {

    @Inject
    InductionsPresenter mInductionsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInductionsPresenter.loadInductions();
    }

}
