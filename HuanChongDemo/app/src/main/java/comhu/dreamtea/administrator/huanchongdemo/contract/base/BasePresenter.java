package comhu.dreamtea.administrator.huanchongdemo.contract.base;

/**
 * Created by Administrator on 2018/1/8.
 */

public class BasePresenter<M, V> {
    public M m;
    public V v;

    public void setVM(M m1, V v1) {
        m = m1;
        v = v1;

    }

}
