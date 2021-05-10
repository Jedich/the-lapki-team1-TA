import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        int[][] a = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7 ,4, 4},
                {4, 5, 2, 6, 5}
        };

        Triangle tr = new Triangle(a);

        for(int i = 0; i < 3; i++) {
            System.out.println(TriangleDPSolver.minSumPath(tr));
            System.out.println(TriangleDPSolver.maxSumPath(tr));
            for(int j = 0; j < tr.size; j++) {
                System.out.println(Arrays.toString(tr.body[j]));
            }
            tr.body = tr.rotate();
        }

        System.out.println(corruption(5,new  ArrayList<>(Arrays.asList(1000f, 1100f, 1200f, 1300f))));
    }

    static float corruption(int percent, ArrayList<Float> list){
        while(list.size() > 1) {
            float min1 = Collections.min(list);
            list.remove(min1);
            float min2 = Collections.min(list);
            list.remove(min2);
            list.add((min1+min2) - (min1+min2) *((float)percent/100f));
        }
        return list.get(0);
    }
}