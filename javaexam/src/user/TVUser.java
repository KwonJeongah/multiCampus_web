package user;

import ioc.exam.tv.TV;
import ioc.exam.tv.TVFactory;

public class TVUser {
	public static void main(String[] args) {
		/*
		πŒ∞ÊTV tv = new πŒ∞ÊTV();
		tv.turnon();
		tv.volumeup();
		tv.volumedown();
		tv.turnoff();
		
		«˝¿ŒTV tv = new «˝¿ŒTV();
		tv.powerOn();
		tv.volumeUp();
		tv.voumeDown();
		tv.powerOff();
		*/
		
		//TV tv = new /*GoTV();*/ ¡ˆ»∆TV();
		
		TV tv = TVFactory.getTV(args[0]);
		
		tv.turnOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.turnOff();
	}
}
