package javabogi.calculator;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> operator = new ArrayList<String>();
		operator.add("1");
		operator.add("2");
		operator.add("3");
		operator.add("4");
		operator.add("5");

		operator.remove(2);
		operator.remove(3);

		operator.add(2,"7");

		for (int inx=0; inx<operator.size(); inx++) {
			System.out.println(operator.get(inx));
		}


	}

}
