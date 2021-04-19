import java.util.Locale;
import java.util.Random;
import java.util.function.IntConsumer;

public class Timer {
    private final BTree tree;

    public Timer(BTree tree) {
        this.tree = tree;
    }

    public String sortedTimer(IntConsumer aMethod) {

        long start = System.nanoTime();
        for (int i = 0; i <= 1000; i++) {
            aMethod.accept(i);
        }
        return String.format(Locale.CANADA_FRENCH, "%,d", ((System.nanoTime() - start) / 1000));
    }

    public String randomTimer(IntConsumer aMethod) {

        Random random = new Random();

        long start = System.nanoTime();
        for (int i = 0; i <= 1000; i++) {
            aMethod.accept(random.nextInt());
        }
        return String.format(Locale.CANADA_FRENCH, "%,d", ((System.nanoTime() - start) / 1000 ));
    }

    public String balancingTimer() {
        long start = System.nanoTime();
        tree.balance(0);
        return String.format(Locale.CANADA_FRENCH, "%,d", ((System.nanoTime() - start) / 100 ));
    }
}

