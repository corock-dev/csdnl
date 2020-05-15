package jsp;

public class Calc {
	public int factorial(int num) {
		// num이 1 이하라면 num을 반환하고, 그렇지 않으면 factorial recursion 수행
		return (num <= 1) ? num : factorial(num - 1) * num;
	}
}
