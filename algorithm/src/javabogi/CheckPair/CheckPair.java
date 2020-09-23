package javabogi.CheckPair;

import java.util.Stack;

/**
 * CheckPair (20분)
 *
 * 괄호의 짝이 맞는지 확인하는 함수를 작성하세요.
 *
 * 예)
 * hello[world(good)]{} -> true
 * hello[[[world(good)]{} -> false
 *
 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class CheckPair {

	public boolean check(String str) {

		Stack<String> stack = new Stack<String>();
		for (int inx=0; inx<str.length(); inx++) {
			char ch = str.charAt(inx);
			if (ch == '[' || ch == '{' || ch == '(') {
				stack.push(str.substring(inx, inx+1));
			}
			if (ch == ']' || ch == '}' || ch == ')') {
				String storedStr = stack.pop();
				if (storedStr.equals("[") && ch != ']') {
					stack.push(storedStr);
				}
				if (storedStr.equals("{") && ch != '}') {
					stack.push(storedStr);
				}
				if (storedStr.equals("(") && ch != ')') {
					stack.push(storedStr);
				}
			}
		}

		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		CheckPair checkPair = new CheckPair();
		System.out.println(checkPair.check("hello[world(good)]{}"));
		System.out.println(checkPair.check("hello[[[world(good)]{}"));
		System.out.println(checkPair.check("hello[[world(good)]{}]"));
	}

}
