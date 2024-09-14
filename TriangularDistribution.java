/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class TriangularDistribution {

	/**
	 * a, c, b are the three parameters on the x axis of
	 * https://en.wikipedia.org/wiki/File:Triangular_distribution_PMF.png
	 */
	int a, c, b;

	/**
	 * Constructor for TriangularDistribution
	 * @param a is the lower limit of the distribution
	 * @param c is the mode
	 * @param b is the upper limit of the distribution
	 */
	public TriangularDistribution(int a, int c, int b) {
		if (a < c && c < b) {
			this.a = a;
			this.c = c;
			this.b = b;
		} else {
			throw new IllegalArgumentException("Invalid parameters for TriangularDistribution");
		}
	}

	/**
	 * @param x is a point on the x axis
	 * @return the probability density at point x
	 */
	public Rational pdf(int x) {

		if (x < a)
			return Rational.zero;

		if (x >= a && x <= c)
			return new Rational(2 * (x - a), (b - a) * (c - a));

		if (x > c && x <= b)
			return new Rational(2 * (b - x), (b - a) * (b - c));

		return Rational.zero;
	}
}