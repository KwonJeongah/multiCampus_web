package kr.co.multi.IOExam.tv;

public class GoTV implements TV {
	public GoTV() {
		System.out.println("goTV생성");
	}
	
	@Override
	public void turnOn() {
		System.out.println("킴");
		
	}

	@Override
	public void turnOff() {
		System.out.println("끔");
	}

	@Override
	public void volumeUp() {
		System.out.println("볼륨 올림");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("볼륨 내림.");
		
	}
	
}
