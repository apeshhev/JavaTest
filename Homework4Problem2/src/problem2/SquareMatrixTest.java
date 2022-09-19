package problem2;

public class SquareMatrixTest {
    public static void main(String[] args) {

        //Generate random matrix
        SquareMatrix randomMatrix = new SquareMatrix();
        randomMatrix.setDataArray();
        System.out.println(randomMatrix.toString());

        System.out.println("Maximum sum: " + randomMatrix.findMaxSum());
        randomMatrix.printAll();
        System.out.println();

        //The matrix from the example
//        int[][] matrix =
//                new int[][]{{2, 3, 3, 4},
//                        {0, 2, 3, 4},
//                        {3, 7, 1, 2},
//                        {4, 3, 3, 2}};
//        SquareMatrix example = new SquareMatrix(matrix);
//        System.out.println(example.toString());
//        System.out.println("Maximum sum: " + example.findMaxSum());
//        example.printAll();
    }

}

