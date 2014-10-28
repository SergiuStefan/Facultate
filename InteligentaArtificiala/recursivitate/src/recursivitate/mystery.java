package recursivitate;

public class mystery {

	static long duration = 0;
	static long duration1 = 0;
	static long duration3 = 0;
	static long duration4 = 0;

	public static int Mystery(int a, int b) {
		if (b == 0)
			return 0;
		if (b % 2 == 0)
			return Mystery(a + a, b / 2);
		return Mystery(a + a, b / 2) + a;
	}

	// factorial recursiv
	public static int factorialrec(int n) {

		long startTime = System.nanoTime();
		if (n == 0)
			return 1;
		n = n * factorialrec(n - 1);
		long endTime = System.nanoTime();
		duration = endTime - startTime;

		return n;

	}

	// factorial iterativ
	public static int factorialnerec(int n) {
		long startTime = System.nanoTime();

		int x, fact = 1;
		for (x = n; x > 1; x--)
			fact *= x;
		long endTime = System.nanoTime();
		duration1 = endTime - startTime;
		return fact;

	}

	// fibbonaci recursiv
	public static long Fibonaci(int f) {
		long fibo = 0;
		long startTime = System.nanoTime();
		if (f == 0)
			return 1;
		if (f == 1)
			return 1;
		else
			fibo = Fibonaci(f - 1) + Fibonaci(f - 2);
		long endTime = System.nanoTime();
		duration3 = endTime - startTime;
		return fibo;
	}

	// fubbonaci iterativ
	public static long Fibonaciiterativ(int f) {
		long rez = 0, x = 1, y = 1;
		long startTime = System.nanoTime();
		for (int i = 0; i < f; i++) {
			rez = x;
			x = y;
			y = rez + x;

		}
		long endTime = System.nanoTime();
		duration4 = endTime - startTime;
		return rez;
	}

	public static void main(String[] args) {

		// System.out.println(Mystery(2, 25));
		// System.out.println(Mystery(3, 11));
		System.out.println("Factorial rec:" + factorialrec(3));
		System.out.println("Time:" + duration + " ns");
		System.out.println("Factorial iter:" + factorialnerec(3));
		System.out.println("Time:" + duration1 + " ns\n");
		System.out.println("Fibo:" + Fibonaci(13));
		System.out.println("Time:" + duration3 + " ns");
		System.out.println("Fibo:" + Fibonaciiterativ(13));
		System.out.println("Time:" + duration4 + " ns");

	}

}
