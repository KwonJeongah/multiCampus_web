package kr.co.multi.IOExam.tv;

public class 지훈TV implements TV {

	public 지훈TV() {
		System.out.println("지훈TV 생성");
	}
	
	boolean power = false;
	int volume = 0;
	final int MAX_VOLUME = 10;
	final int MIN_VOLUME = 0;

	@Override
	public void turnOn() {
		power = true;
		System.out.println("켜기.");
	}

	@Override
	public void turnOff() {
		power = false;
		System.out.println("끄기.");
	}

	@Override
	public void volumeUp() {
		if (volume < MAX_VOLUME) {
			volume++;
			System.out.printf("현재 볼륨: %d\n", volume);
		}else 
			System.out.println("최대 볼륨임");
	}

	@Override
	public void volumeDown() {
		if (volume > MIN_VOLUME) {
			volume--;
			System.out.printf("현재 볼륨: %d\n", volume);
		} else
			System.out.println("최저 볼륨임");
	}


}
