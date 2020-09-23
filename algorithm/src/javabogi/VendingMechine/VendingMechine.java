package javabogi.VendingMechine;

/**
 * VendingMechine (20분)
 *
 * 자판기에서 음료수를 사고 거스름돈을 출력하는 문제입니다.
 *
 * 거스름돈은 100원짜리 5개와 10원짜리 20개가 있습니다.
 * 음료수는 120원이고 음료수를 사면 "음료수 출력! 거스름돈: 100원짜리 X개, 10원짜리 X개"를 출력합니다.
 * 120원보다 적은 돈이 들어오면 "음료수를 살 수 없습니다."를 출력합니다.
 * 100원짜리 거스름돈이 부족하면 10원짜리로 돌려줄 수 있습니다.
 * 10원짜리도 모자르면 "거스름돈이 부족합니다."를 출력합니다.
 *
 * 입력된 금액은 거스름돈으로 사용되지 않습니다.
 *
 * 입력 예)
 * 500
 * 100
 * 420
 * 200
 *
 * 출력 예)
 * 500원이 입력되었습니다.
 * 음료수 출력! 거스름돈: 100원짜리 3개, 10원짜리 8개
 * 100원이 입력되었습니다.
 * 음료수를 살 수 없습니다.
 * 420원이 입력되었습니다.
 * 음료수 출력! 거스름돈: 100원짜리 2개, 10원짜리 10개
 * 200원이 입력되었습니다.
 * 거스름돈이 부족합니다.
 *
 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class VendingMechine {
	int remain100 = 5;
	int remain10 = 20;

	public void getDrink(int money) {
		System.out.println(money + "원이 입력되었습니다.");

		if (money < 120) {
			System.out.println("음료수를 살 수 없습니다.");
		} else {
			int change = money - 120;

			int count100 = change / 100;
			int count10 = (change % 100)/10;
			if ((remain100 >= count100 && remain100 != 0) && (remain10 >= count10 && remain10 != 0)) {
				System.out.println("음료수 출력! 거스름돈: 100원짜리 " + count100 + "개, 10원짜리 "+ count10 +"개");
				remain100 -= count100;
				remain10 -= count10;
				return;
			}

			if (remain100 < count100 || remain100 == 0) {
				change = change - (remain100 * 100);
				count10 = change / 10;
				if (remain10 >= count10 && remain10 != 0) {
					System.out.println("음료수 출력! 거스름돈: 100원짜리 " + remain100 + "개, 10원짜리 "+ count10 +"개");
					remain100 -= remain100;
					remain10 -= count10;
					return;
				} else {
					System.out.println("거스름돈이 부족합니다.");
				}
			}
		}
	}

	public static void main(String[] args) {
		VendingMechine vendingMechine = new VendingMechine();
		vendingMechine.getDrink(500);
		vendingMechine.getDrink(100);
		vendingMechine.getDrink(420);
		vendingMechine.getDrink(200);
	}
}
