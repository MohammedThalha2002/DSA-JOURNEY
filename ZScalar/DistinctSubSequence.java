package ZScalar;

class DistinctSubSequence {
	static int f(int i, int j, String s,
									String t)
	{
		if (j >= t.length()) {
			return 1;
		}
		if (i >= s.length()) {
			return 0;
		}
		if (s.charAt(i) == t.charAt(j)) {
			return f(i + 1, j + 1, s, t)
				+ f(i + 1, j, s, t);
		}
		return f(i + 1, j, s, t);
	}

	public static void main(String[] args)
	{
		String T = "ge";
		String S = "geeksforgeeks";
		System.out.println(
			f(0, 0, S, T));
	}
}
