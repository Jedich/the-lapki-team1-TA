
public class TriangleDPSolver {

    public static int minSumPath(Triangle tr) {
        int[] memory = new int[tr.size];
        int n = tr.size - 1;
        System.arraycopy(tr.body[n], 0, memory, 0, tr.body[n].length);
        for (int i = tr.size - 2; i >= 0; i--) {
            for (int j = 0; j < tr.body[i].length; j++) {
                memory[j] = tr.body[i][j] + Math.min(memory[j], memory[j + 1]);
            }
        }
        return memory[0];
    }

    public static int maxSumPath(Triangle tr) {
        int[] memory = new int[tr.size];
        int n = tr.size - 1;
        System.arraycopy(tr.body[n], 0, memory, 0, tr.body[n].length);
        for (int i = tr.size - 2; i >= 0; i--) {
            for (int j = 0; j < tr.body[i].length; j++) {
                memory[j] = tr.body[i][j] + Math.max(memory[j], memory[j + 1]);
            }
        }
        return memory[0];
    }
}
