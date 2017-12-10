package joaozao.sourcedev.com.easylearning.inductions;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;
import joaozao.sourcedev.com.easylearning.R;
import joaozao.sourcedev.com.easylearning.data.Induction;

public class InductionsFragment extends DaggerFragment implements InductionsContract.View {

    public static final String TAG = "TAG_INDUCTIONS_FRAGMENT";

    @Inject
    InductionsContract.Presenter mPresenter;

    @BindView(R.id.recycler_view) RecyclerView inductionsRecyclerView;

    private InductionsAdapter inductionsAdapter;

    @Inject
    public InductionsFragment() {
        // Requires empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inductionsAdapter = new InductionsAdapter(getContext(), new ArrayList<>(0));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.inductions_fragment, container, false);

        ButterKnife.bind(this, root);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        inductionsRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        inductionsRecyclerView.setLayoutManager(layoutManager);
        inductionsRecyclerView.setAdapter(inductionsAdapter);

        return root;
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
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setLoadingIndicator(boolean active) {
    }

    @Override
    public void showInductions(List<Induction> inductions) {
        getActivity().runOnUiThread(() -> inductionsAdapter.replaceData(inductions));
    }

    @Override
    public void showNoInductions() {
        Toast.makeText(getContext(), "No inductions to show!", Toast.LENGTH_SHORT).show();
    }


}
