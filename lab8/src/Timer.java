
import hashtable.HashTable;

import java.util.Locale;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class Timer {
	private final Object obj;

	public Timer(HashTable<Integer> amp) {
		this.obj = amp;
	}

	public String randomTimer(BiConsumer<Long, Integer> aMethod, int iterNum) {
		long start = System.nanoTime();
		for (int i = 0; i <= iterNum; i++) {
			aMethod.accept((long)Math.random()*iterNum, i);
		}
		return String.format(Locale.US, "%.3f", ((float)(System.nanoTime() - start) / 1000000));
	}

	public String randomTimer(Function<Long, Integer> aMethod, int iterNum) {
		long start = System.nanoTime();
		for (int i = 0; i <= iterNum; i++) {
			aMethod.apply((long) Math.random()*iterNum);
		}
		return String.format(Locale.US, "%.3f", ((float)(System.nanoTime() - start) / 1000000));
	}
}