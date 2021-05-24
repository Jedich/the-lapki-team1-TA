
import hashtable.Containerable;
import hashtable.HashTable;

import java.util.Locale;
import java.util.Random;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;

public class Timer {
	private final HashTable<Integer> hashmap;

	public Timer(HashTable<Integer> amp) {
		this.hashmap = amp;
	}

	public String sortedTimer(BiConsumer<Long, Integer> aMethod, int iterNum) {
		long start = System.nanoTime();
		for (int i = 0; i <= iterNum; i++) {
			aMethod.accept((long)i, i);
		}
		return String.format(Locale.CANADA_FRENCH, "%,d", ((System.nanoTime() - start) / 1000000));
	}

	public String sortedTimer(Function<Long, Integer> aMethod, int iterNum) {
		long start = System.nanoTime();
		for (int i = 0; i <= iterNum; i++) {
			aMethod.apply((long)i);
		}
		return String.format(Locale.CANADA_FRENCH, "%,d", ((System.nanoTime() - start) / 1000000));
	}
}