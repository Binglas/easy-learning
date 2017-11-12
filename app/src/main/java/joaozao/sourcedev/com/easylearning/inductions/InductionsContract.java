package joaozao.sourcedev.com.easylearning.inductions;

import joaozao.sourcedev.com.easylearning.BasePresenter;
import joaozao.sourcedev.com.easylearning.BaseView;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface InductionsContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter<View> {

    }
}
