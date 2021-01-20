package ioc.exam.tv;

public class TVImpl implements TV {

	@Override
	public void turnOn() {
		System.out.println("TV ÄÔ");
	}

	@Override
	public void turnOff() {
		System.out.println("TV ²û");
	}

	@Override
	public void volumeUp() {
		System.out.println("º¼·ı ³ôÀÓ");
	}

	@Override
	public void volumeDown() {
		System.out.println("º¼·ı ³·Ãã");
	}

}
