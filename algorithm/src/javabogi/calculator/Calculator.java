package javabogi.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Calculator (30분 ~ 40분)
 *
 * 사칙연산 계산기 만들기 1*8+3+6+5/2*5-9 와 같이 사칙연산의 답을 구하는 문제
 *
 * *, /은 +, -보다 우선순위가 높다. 각 숫자는 한자리 자연수로 이루어지고 나누셈의 경우 소수점은 버리고(5/2=2) 0으로 나누는
 * 경우는 없다고 가정한다.
 *
 * ----------- Pseudocode ----------- TODO
 *
 */
public class Calculator {

	public int calculate(String str) {
		List<String> operator = new ArrayList<String>();
		List<Integer> operand = new ArrayList<Integer>();

		parse(operator, operand, str);

		calculate(operator, operand, 2);
		calculate(operator, operand, 1);

		return operand.get(0);
	}

	private void parse(List<String> operator, List<Integer> operand, String str) {
		for (int inx = 0; inx < str.length(); inx++) {
			String ch = str.substring(inx, inx + 1);
			if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
				operator.add(ch);
			} else {
				operand.add(Integer.parseInt(ch));
			}
		}
	}

	private void calculate(List<String> operators, List<Integer> operands, int op) {
		String[] copyOperator = new String[operators.size()];
		copyOperator = operators.toArray(copyOperator);

		int realIndex = 0;
		for (int inx = 0; inx < copyOperator.length; inx++) {
			boolean isCalculate = false;
			String operator = copyOperator[inx];
			if (op == 2 && (operator.equals("*") || operator.equals("/"))) {
				isCalculate = true;
			} else if (op == 1 && (operator.equals("+") || operator.equals("-"))) {
				isCalculate = true;
			}

			if (isCalculate) {
				int result = calculate(operands.get(realIndex), operands.get(realIndex+1), operator);
				operands.remove(realIndex);
				operands.remove(realIndex);
				operands.add(realIndex, result);
				operators.remove(realIndex);
			} else {
				realIndex++;
			}
		}
	}

	private int calculate(int operand1, int operand2, String operator) {
		if (operator.equals("*")) {
			return operand1 * operand2;
		}
		if (operator.equals("/")) {
			int quotient = operand1 / operand2;
			return quotient;
		}
		if (operator.equals("+")) {
			return operand1 + operand2;
		}
		if (operator.equals("-")) {
			return operand1 - operand2;
		}
		return 0;
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		System.out.println(calculator.calculate("1*8+3+6+5/2*5-9")); // 18
		System.out.println(calculator.calculate("1*8-3-6+5/2*6-9")); // 2
	}

}
