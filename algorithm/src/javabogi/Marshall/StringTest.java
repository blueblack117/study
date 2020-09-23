package javabogi.Marshall;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String addr = "서울시 영등포구=여의도동,여의대로=24,30층 내옆자리";
		addr = addr.replaceAll("=", "\\\\=");
		addr = addr.replaceAll(",", "\\\\,");
		System.out.println("value = " + addr);
//		String[] arrAdd = addr.split("^((?!\\,).)*$,");
//		for (String value : arrAdd) 
//			System.out.println("value = " + value);
	}

}
