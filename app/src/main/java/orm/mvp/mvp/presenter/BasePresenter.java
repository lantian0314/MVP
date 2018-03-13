package orm.mvp.mvp.presenter;

import android.app.Activity;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;


/**
 * Created by xingyatong on 2018/3/13.
 */
public class BasePresenter<T> {
    private Reference<T> mReference;

    public void bindView(T mvpview) {
        //建立关联
        mReference = new WeakReference<T>(mvpview);
    }

    public T getView() {
        return mReference.get();
    }

    /**
     * 接触弱引用关联
     */
    public void detechView() {
        if (mReference != null) {
            mReference.clear();
            mReference = null;
        }
    }
}
