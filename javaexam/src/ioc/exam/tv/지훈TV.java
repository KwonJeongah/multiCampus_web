package ioc.exam.tv;

public class ����TV implements TV {

	boolean power = false;
	int volume = 0;
	final int MAX_VOLUME = 10;
	final int MIN_VOLUME = 0;

	@Override
	public void turnOn() {
		power = true;
		System.out.println("������ �մϴ�.");
	}

	@Override
	public void turnOff() {
		power = false;
		System.out.println("������ ���ϴ�.");
	}

	@Override
	public void volumeUp() {
		if (volume < MAX_VOLUME) {
			volume++;
			System.out.printf("���� ������ %d�Դϴ�.\n", volume);
		}else 
			System.out.println("������ �ִ� �����Դϴ�.");
	}

	@Override
	public void volumeDown() {
		if (volume > MIN_VOLUME) {
			volume--;
			System.out.printf("���� ������ %d�Դϴ�.\n", volume);
		} else
			System.out.println("������ �ּ� �����Դϴ�.");
	}


}
