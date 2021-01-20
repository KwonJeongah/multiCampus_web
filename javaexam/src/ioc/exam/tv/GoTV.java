package ioc.exam.tv;

public class GoTV implements TV {

	@Override
	public void turnOn() {
		System.out.println("������ �Ѵ�.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("������ ����.");
	}

	@Override
	public void volumeUp() {
		System.out.println("�Ҹ��� ���̴�.");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("�Ҹ��� ���ߴ�.");
		
	}
	
}
