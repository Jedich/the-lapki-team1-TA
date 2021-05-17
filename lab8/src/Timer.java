import tree.Tree;

import java.util.Locale;
import java.util.Random;

import java.util.function.IntConsumer;

public class Timer {
	private final Tree tree;

	public Timer(Tree tree) {
		this.tree = tree;
	}

	public String sortedTimer(IntConsumer aMethod) {
		tree.clear();
		long start = System.nanoTime();
		for (int i = 0; i <= 1000; i++) {
			aMethod.accept(i);
		}
		return String.format(Locale.CANADA_FRENCH, "%,d", ((System.nanoTime() - start) / 1000));
	}

	public String randomTimer(IntConsumer aMethod) {
		tree.clear();
		Random random = new Random();

		long start = System.nanoTime();
		for (int i = 0; i <= 1000; i++) {
			aMethod.accept(random.nextInt());
		}
		return String.format(Locale.CANADA_FRENCH, "%,d", ((System.nanoTime() - start) / 1000));
	}

	public String balancingTimer() {
		long start = System.nanoTime();
		tree.balancing();
		return String.format(Locale.CANADA_FRENCH, "%,d", ((System.nanoTime() - start) / 100));
	}
}
