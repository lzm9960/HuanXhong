package lzm.jiyun.com.mysvg.base;

/**
 * Created by lenovo on 2018/1/7.
 */
public class BasePresenter<M, V> {
    public M baseModel;
    public V baseView;

    public void setVM(M m, V v) {
        baseModel = m;
        baseView = v;
    }
}
