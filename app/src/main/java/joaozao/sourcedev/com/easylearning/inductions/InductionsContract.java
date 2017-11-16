package joaozao.sourcedev.com.easylearning.inductions;

import java.util.List;

import joaozao.sourcedev.com.easylearning.BasePresenter;
import joaozao.sourcedev.com.easylearning.BaseView;
import joaozao.sourcedev.com.easylearning.data.Induction;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface InductionsContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showInductions(List<Induction> tasks);

        void showNoInductions();

    }

    interface Presenter extends BasePresenter<View> {

        void loadInductions();

        void takeView(InductionsContract.View view);

        void dropView();

    }
}
