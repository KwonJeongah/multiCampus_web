package ioc.exam.tv;

public class TVImpl implements TV {

	@Override
	public void turnOn() {
		System.out.println("TV ��");
	}

	@Override
	public void turnOff() {
		System.out.println("TV ��");
	}

	@Override
	public void volumeUp() {
		System.out.println("���� ����");
	}

	@Override
	public void volumeDown() {
		System.out.println("���� ����");
	}

}
