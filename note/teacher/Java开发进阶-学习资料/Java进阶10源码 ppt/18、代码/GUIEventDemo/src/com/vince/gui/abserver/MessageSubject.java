package com.vince.gui.abserver;

/**
 * Created by vince on 2017/7/8.
 * 被观察者的接口
 */
public interface MessageSubject {
    //注册观察者
    public void registerObserver(Observer o);
    //移除观察者
    public void removeObserver(Observer o);
    //通知所有观察者
    public void notifyObservers();
}
