package ioc.exam.tv;

public class TVFactory {
	public static TV getTV(String tvName) {
		TV tv = null;
		if("G".equals(tvName)) tv = new GoTV();
		else if("J".equalsIgnoreCase(tvName)) tv = new ÁöÈÆTV();
		
		return tv;
	}
}
