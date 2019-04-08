package com.example.http.rx;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author Li
 * @data 2017年12月4日
 * @Email 364797468@qq.com
 * @describe
 * Rx管理类 管理订阅
 */

public class RxManager {

    private static RxManager manager;
    private Map<String, CompositeDisposable> map;

    private RxManager() {
        map = new HashMap<>();
    }

    /**
     * 单例获取Manger对象
     *
     * @return
     */
    public static RxManager getInstance() {
        if (manager == null) {
            synchronized (RxManager.class) {
                if (manager == null) {
                    manager = new RxManager();
                }
            }
        }
        return manager;
    }

    /**
     * RxObserver中，执行onSubscribe方法时，把参数Disposable添加进了RxManager中
     * @param key
     * @param disposable
     */
    public void add(String key, Disposable disposable) {
        Set<String> keySet = map.keySet();
        if (keySet.contains(key)) {
            CompositeDisposable compositeDisposable = map.get(key);
            compositeDisposable.add(disposable);
        } else {
            CompositeDisposable compositeDisposable = new CompositeDisposable();
            compositeDisposable.add(disposable);
            map.put(key, compositeDisposable);
        }
    }

    /**
     * 根据key得到对应的CompositeDisposable ，
     * 并执行compositeDisposable.clear()来取消compositeDisposable中所有的订阅关系
     */
    public void clean(String key){
        Set<String> keySet=map.keySet();
        if (keySet.contains(key)){
            CompositeDisposable compositeDisposable=map.get(key);
            compositeDisposable.clear();
            map.remove(key);
            Log.e(">>>remove",key);
        }
    }
}
