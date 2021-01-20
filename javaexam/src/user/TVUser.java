package user;

import ioc.exam.tv.TV;
import ioc.exam.tv.TVFactory;

public class TVUser {
	public static void main(String[] args) {
		/*
		�ΰ�TV tv = new �ΰ�TV();
		tv.turnon();
		tv.volumeup();
		tv.volumedown();
		tv.turnoff();
		
		����TV tv = new ����TV();
		tv.powerOn();
		tv.volumeUp();
		tv.voumeDown();
		tv.powerOff();
		*/
		
		//TV tv = new /*GoTV();*/ ����TV();
		
		TV tv = TVFactory.getTV(args[0]);
		
		tv.turnOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.turnOff();
	}
}
