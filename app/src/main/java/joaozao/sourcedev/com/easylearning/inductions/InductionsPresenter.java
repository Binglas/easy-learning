package joaozao.sourcedev.com.easylearning.inductions;


import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import joaozao.sourcedev.com.easylearning.data.Induction;
import joaozao.sourcedev.com.easylearning.data.source.InductionsDataSource;
import joaozao.sourcedev.com.easylearning.data.source.InductionsRepository;

public class InductionsPresenter implements InductionsContract.Presenter{

    @Nullable
    private InductionsContract.View mInductionsView;
    private InductionsRepository mInductionsRepository;

    @Inject
    InductionsPresenter(InductionsRepository inductionsRepository) {
        mInductionsRepository = inductionsRepository;
    }

    @Override
    public void loadInductions() {
        mInductionsRepository.getInductions(new InductionsDataSource.LoadInductionsCallback() {
            @Override
            public void onInductionsLoaded(List<Induction> tasks) {

            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void takeView(InductionsContract.View view) {
        this.mInductionsView = view;
        loadInductions();
    }

    @Override
    public void dropView() {
        mInductionsView = null;
    }
}
