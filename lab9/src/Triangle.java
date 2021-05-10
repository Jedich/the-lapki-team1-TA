public class Triangle {
    public int[][] body;
    public int size;

    public Triangle(int[][] body) {
        this.body = body;
        size = body.length;
    }

//    {7},
//    {3, 8},
//    {8, 1, 0},
//    {2, 7 ,4, 4},
//    {4, 5, 2, 6, 5}
    public int[][] rotate(){
        var t = this.body;
        int[][] res= new int[t.length][];
        for(int i = 1; i <= size; i++) {
            res[i-1] = new int[i];
        }
        int p = t[t.length-1].length -1;

        for (int i = 0; i <= t.length-1; i++) {
            var z = t.length-1-i;
            for (int j = 0; j < i+1; j++) {

                res[i][j] = t[z+j][p-i];
            }
        }

        return res;

    }

//    public void print(){
//        var t = this.body;
//        for (int i = 0; i < t.length; i++) {
//            for (int j = 0; j < t[System.out.println();
//            }
//    }
//        }
//    }



}
