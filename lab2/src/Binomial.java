import interfaces.Binomialable;

public class Binomial implements Binomialable {
	@Override
	public int findCoefficient(int m, int n) {
		if (m == 0 | m == n) return 1;
		return findCoefficient(m,n-1) + findCoefficient(m-1,n-1);
	}
}
