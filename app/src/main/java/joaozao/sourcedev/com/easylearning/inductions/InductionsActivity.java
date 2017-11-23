package joaozao.sourcedev.com.easylearning.inductions;

import android.os.Bundle;
import android.support.v7.app.ActionBar;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;
import joaozao.sourcedev.com.easylearning.R;

public class InductionsActivity extends DaggerAppCompatActivity {

    @Inject
    InductionsPresenter mInductionsPresenter;

    @Inject
    Lazy<InductionsFragment> mProvidesInductionsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(false);
            ab.setTitle("Inductions");
        }

        InductionsFragment mInductionsFragment = mProvidesInductionsFragment.get();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.layout_content, mInductionsFragment, InductionsFragment.TAG)
                .show(mInductionsFragment)
                .commitNow();
    }

}
