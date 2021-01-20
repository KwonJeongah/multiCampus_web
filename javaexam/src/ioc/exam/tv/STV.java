package ioc.exam.tv;

public class STV {
	boolean power = false;
	int volume = 20;
	
	//전원을 켜다
	public boolean onTV() {
		this.power = true;
		return this.power;
	}
	
	public boolean offTV() {
		this.power = false;
		return this.power;
	}
	
	public int upTV() {
		this.volume++;
		return this.volume;
	}
	
	public int downTV() {
		this.volume--;
		return this.volume;
	}
}
