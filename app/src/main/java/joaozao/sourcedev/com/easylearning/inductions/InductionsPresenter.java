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
            public void onInductionsLoaded(List<Induction> inductions) {

                // The view may not be able to handle UI updates anymore
                if (mInductionsView == null || !mInductionsView.isActive()) {
                    return;
                }

                processInductions(inductions);
            }

            @Override
            public void onDataNotAvailable() {
                processEmptyInductions();
            }
        });
    }

    private void processInductions(List<Induction> inductions) {
        if (inductions.isEmpty()) {
            // Show a message indicating there are no inductions for that filter type.
            processEmptyInductions();
        } else {
            // Show the list of inductions
            if (mInductionsView != null) {
                mInductionsView.showInductions(inductions);
            }
        }
    }

    private void processEmptyInductions() {
        if(mInductionsView == null) return;

        mInductionsView.showNoInductions();
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
