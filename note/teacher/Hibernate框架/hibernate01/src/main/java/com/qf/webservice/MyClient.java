package com.qf.webservice;

/**
 * Thanks for Everything.
 */
public class MyClient {

	public static void main(String[] args) {
		MyPhoneImplService myPhoneImplService = new MyPhoneImplService();
		MyPhoneImpl port = myPhoneImplService.getPort(MyPhoneImpl.class);
		String s = port.queryPhone("13478909876");
		System.out.println(s);

	}

}
