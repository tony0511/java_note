package com.vince.gui.abserver;

import org.junit.Test;

/**
 * Created by vince on 2017/7/8.
 */
public class TestDemo {

    @Test
    public void testObserver(){
        Message message = new Message();
        Observer user1 = new User("lily");
        Observer user2 = new User("tom");
        Observer user3 = new User("vince");
        message.registerObserver(user1);
        message.registerObserver(user2);
        message.registerObserver(user3);

        message.setMessage("亲们，么么哒");

        message.removeObserver(user1);

        message.setMessage("有在的吗，我要发红包啦");
    }
}
