package com.doc.util;

import java.net.URISyntaxException;
import java.util.Arrays;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class Socketclient {
		public void conn() throws URISyntaxException{
			IO.Options opts = new IO.Options();
			opts.reconnectionAttempts = Integer.MAX_VALUE;
			opts.reconnectionDelay = 30;
			opts.timeout = 2000;
			
			Socket socket = IO.socket("http://211.155.84.134:9092",opts);
			socket.on(Socket.EVENT_CONNECT_TIMEOUT, new Emitter.Listener() {

				  @Override
				  public void call(Object... args) {
					  System.out.println(Arrays.toString(args));
					  System.out.println(System.currentTimeMillis()+"Socket.EVENT_MESSAGE");
				  }

				}).on(Socket.EVENT_CONNECT, new Emitter.Listener() {

			  @Override
			  public void call(Object... args) {
				  System.out.println(Arrays.toString(args));
				  System.out.println(System.currentTimeMillis()+"EVENT_CONNECT");
			  }

			}).on(Socket.EVENT_PING, new Emitter.Listener() {

				  @Override
				  public void call(Object... args) {
					  System.out.println(System.currentTimeMillis()+"EVENT_PiNG");
				  }

				}).on(Socket.EVENT_PONG, new Emitter.Listener() {

				  @Override
				  public void call(Object... args) {
					  socket.emit(Socket.EVENT_MESSAGE, "ddd");
					  System.out.println(System.currentTimeMillis()+"EVENT_PONG");
				  }

				}).on(Socket.EVENT_CONNECTING, new Emitter.Listener() {

					  @Override
					  public void call(Object... args) {
						  System.out.println(System.currentTimeMillis()+"EVENT_CONNECTING");
					  }

					})
			
			.on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

			  @Override
			  public void call(Object... args) {
				  System.out.println(System.currentTimeMillis()+"EVENT_DISCONNECT");
			  }

			});
			socket.connect();
			
		}
		public static void main(String[] args) {
			try {
				new Socketclient().conn();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
