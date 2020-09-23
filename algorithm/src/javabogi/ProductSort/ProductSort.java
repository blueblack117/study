package javabogi.ProductSort;

/**
 * Product Sort (20분)
 *
 * 2차원 배열로 주어지는 부서정보 및 제품정보를 조합하여 제품정보를 sorting하여 출력
 ex> [부서정보 배열] (department 배열로 전달)
 부서코드  부서명
 10        TV부서
 20        에어콘부서
 30        모바일부서
 40        오디오부서

 [제품정보 배열] (product 배열로 전달)
 제품코드 제품명 부서코드
 P0001     G6       30
 P0007     휘센     20
 P0004     OLEDTV   10
 P0002     청정기   20

 출력은 다음과 같이 한다
 - 부서코드 순으로 오름차순 정렬한다
 - 부서코드가 같은 경우 제품코드로 비교하여 오름차순 한다.
 - 제품정보에서는 부서명을 알 수 없으므로 부서정보에서 가져온다.

 [출력예시]
 제품코드  제품명   부서명
 P0004     OLEDTV   TV부서
 P0002     청정기   에어콘부서
 P0007     휘센     에어콘부서
 P0001     G6       모바일부서

 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class ProductSort {

	public static void main(String[] args){

		String[][] product = productSorting(getDepartment(), getProduct());

		System.out.println("제품코드 제품명\t부서명");

		for(int i = 0; i < product.length; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(product[i][j]);
				System.out.print("\t");
			}
			System.out.println("");
		}

	}

	public static String[][] productSorting(String[][] department, String[][] product){
		String[][] result = new String[product.length][3];

		//TODO

		return result;
	}


	private static String[][] getDepartment(){
		String[][] department = {
				{"10", "TV부서"},
				{"20", "에어콘부서"},
				{"30", "모바일부서"},
				{"40", "오디오부서"}
		};

		return department;
	}

	private static String[][] getProduct(){
		String[][] product = {
				{"P0001", "G6", "30"},
				{"P0007", "휘센", "20"},
				{"P0004", "OLEDTV", "10"},
				{"P0002", "청정기", "20"}
		};

		return product;
	}
}
