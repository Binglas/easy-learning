package joaozao.sourcedev.com.easylearning.inductions;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import joaozao.sourcedev.com.easylearning.data.Induction;

public class InductionsFragment extends DaggerFragment implements InductionsContract.View {

    public static final String TAG = "TAG_INDUCTIONS_FRAGMENT";

    @Inject
    InductionsContract.Presenter mPresenter;

    @Inject
    public InductionsFragment() {
        // Requires empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();  //prevent leaking activity in
        // case presenter is orchestrating a long running task
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showInductions(List<Induction> tasks) {

    }

    @Override
    public void showNoInductions() {

    }


}
