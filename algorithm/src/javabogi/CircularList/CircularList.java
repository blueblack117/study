package javabogi.CircularList;

import java.util.LinkedList;
import java.util.List;

/**
 * 아래 조건에 따라 리스트를 회전하는 프로그램을 작성하시오.

 조건

 입력값은 한 행의 문자열로 주어지며, 각 값은 공백으로 구분된다.
 첫 번째 값은 리스트를 회전하는 양과 방향(음수의 경우 좌측으로, 양수의 경우 우측으로 회전)이다.
 첫 번째 값을 제외한 나머지 값은 리스트의 각 항목의 값이다.
 회전된 리스트를 문자열로 출력한다.
 구현에 이용할 자료구조에 대한 조건이나 제약은 없다.
 입력되는 리스트의 항목의 개수는 유한하다.
 입출력 예

 예 1)

 입력: 1 10 20 30 40 50
 출력: 50 10 20 30 40
 예 2)

 입력: 4 가 나 다 라 마 바 사
 출력: 라 마 바 사 가 나 다
 예 3)

 입력: -2 A B C D E F G
 출력: C D E F G A B
 예 4)

 입력: 0 똘기 떵이 호치 새초미
 출력: 똘기 떵이 호치 새초미

 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class CircularList {

	public String shift(String text) {
		String[] arrTest = text.split(" ");
		List<String> textList = new LinkedList<String>();

		if (arrTest.length > 1) {
			for (int inx=1; inx<arrTest.length; inx++) {
				textList.add(arrTest[inx]);
			}
		}
		rotationList(Integer.parseInt(arrTest[0]), textList);
		return printList(textList);
	}

	private void rotationList(int cntRepeat, List<String> textList) {
		if (cntRepeat == 0) {
			return;
		} else if (cntRepeat > 0) {
			for (int inx=0; inx<cntRepeat; inx++) {
				String text = textList.remove(textList.size()-1);
				textList.add(0, text);
			}
		} else {
			cntRepeat = cntRepeat * (-1);
			for (int inx=0; inx<cntRepeat; inx++) {
				String text = textList.remove(0);
				textList.add(textList.size(), text);
			}
		}
	}

	private String printList(List<String> textList) {
		String result = null;
		StringBuffer sb = new StringBuffer();
		for (String text : textList) {
			sb.append(text).append(" ");
		}
		result = sb.toString();
		return result;
	}

	public static void main(String[] args) {
		CircularList list = new CircularList();
		System.out.println(list.shift("1 10 20 30 40 50"));
		System.out.println(list.shift("4 가 나 다 라 마 바 사"));
		System.out.println(list.shift("-2 A B C D E F G"));
		System.out.println(list.shift("0 똘기 떵이 호치 새초미"));
		System.out.println(list.shift("-2 10 20 30 40 50"));
	}

}
