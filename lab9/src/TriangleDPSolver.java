
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
        int[][] tri = new int[tr.size][tr.size];
        for(int i=0; i < tr.size; i++)
            for(int j = 0; j < tr.body[i].length; j++)
                tri[i][j] = tr.body[i][j];
        for(int i = tr.size - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                if (tri[i + 1][j] > tri[i + 1][j + 1])
                    tri[i][j] += tri[i + 1][j];
                else
                    tri[i][j] += tri[i + 1][j + 1];
            }
        }
        return tri[0][0];
    }
}
