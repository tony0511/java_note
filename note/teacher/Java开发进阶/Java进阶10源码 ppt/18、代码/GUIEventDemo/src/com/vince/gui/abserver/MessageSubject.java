package com.vince.gui.abserver;

/**
 * Created by vince on 2017/7/8.
 * ���۲��ߵĽӿ�
 */
public interface MessageSubject {
    //ע��۲���
    public void registerObserver(Observer o);
    //�Ƴ��۲���
    public void removeObserver(Observer o);
    //֪ͨ���й۲���
    public void notifyObservers();
}
