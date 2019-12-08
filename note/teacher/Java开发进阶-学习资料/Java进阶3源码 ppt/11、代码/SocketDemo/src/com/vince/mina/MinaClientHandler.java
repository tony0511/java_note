package com.vince.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import javax.sound.midi.Soundbank;

/**
 * Created by vince on 2017/6/8.
 */
public class MinaClientHandler extends IoHandlerAdapter {
  @Override
  public void sessionOpened(IoSession session) throws Exception {
    super.sessionOpened(session);
    System.out.println("sessionOpened");
  }
  @Override
  public void sessionClosed(IoSession session) throws Exception {
    super.sessionClosed(session);
    System.out.println("sessionClosed");
  }
  @Override
  public void messageReceived(IoSession session, Object message) throws Exception {
    super.messageReceived(session, message);
    // String msg = (String) message;
    Message msg = (Message)message;
    System.out.println(msg);
  }
}
