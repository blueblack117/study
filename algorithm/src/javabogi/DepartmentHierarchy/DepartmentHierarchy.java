package javabogi.DepartmentHierarchy;

/**
 * Department Hierarchy (20분)
 *
 * 부서 출력하는 메소드를 작성하세요.
 *
 * 최상위 조직부터 출력 시작.
 * 동일한 level의 조직이 있는 경우, 부서ID로 오름차순 정렬하여 출력
 * 이웃 노드보다 하위 조직이 있으면 하위 조직부터 출력
 * 하위 조직은 level에 따라 들여쓰기 해야 함
 * 입력은 상위 조직부터 입력된다고 가정함
 *
 * 입력 예)
 * 부서ID, 부서명, 상위조직
 { "0000", "사장실", null},
 { "1010", "영업1", "0000"},
 { "1020", "영업2", "0000"},
 { "1030", "영업3", "0000"},
 { "2002", "영업1하위2", "1010"},
 { "2001", "영업1하위1", "1010"},
 { "3002", "영업2하위2", "1020"},
 { "3001", "영업2하위1", "1020"},
 { "4001", "영업1하위1하위1", "2001"},
 { "4002", "영업1하위1하위2", "2001"}

 츌력 예)
 사장실
 영업1
 영업1하위1
 영업1하위1하위1
 영업1하위1하위2
 영업1하위2
 영업2
 영업2하위1
 영업2하위2
 영업3
 *
 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class DepartmentHierarchy {

	private void printTree(String[][] arrays) {
		// TODO

	}

	public static void main(String[] args) {
		String[][] arrays = {{ "0000", "사장실", null},
				{ "1010", "영업1", "0000"},
				{ "1020", "영업2", "0000"},
				{ "1030", "영업3", "0000"},
				{ "2002", "영업1하위2", "1010"},
				{ "2001", "영업1하위1", "1010"},
				{ "3002", "영업2하위2", "1020"},
				{ "3001", "영업2하위1", "1020"},
				{ "4001", "영업1하위1하위1", "2001"},
				{ "4002", "영업1하위1하위2", "2001"}
		};
		new DepartmentHierarchy().printTree(arrays);
	}

}
