package problem2;

public class SquareMatrix {
    private int[][] dataArray;
    private int dimension;

    public SquareMatrix() {
        this.dataArray = new int[][]{{0, 0}, {0, 0}};
        this.dimension = 2;
    }

    public SquareMatrix(int[][] dataArray) {
        this.dataArray = dataArray;
        this.dimension = dataArray.length;
    }

    public SquareMatrix(SquareMatrix newSquareMatrix) {
        this.dataArray = newSquareMatrix.dataArray;
        this.dimension = newSquareMatrix.dimension;
    }

    public int[][] getDataArray() {
        return dataArray;
    }

    //Setting the matrix with random dimension using random generated number for the dimension
    public void setDataArray() {
        //generating random dimension in range [2-12]
        int dimension = (int)(Math.random() * 11) + 2;
        dataArray = new int[dimension][dimension];
        setDimension(dimension);

        for(int i = 0; i < dimension; i++) {
            for(int j = 0; j < dimension; j++) {
                //generating random value for each element in range [0-8]
                dataArray[i][j] = (int)(Math.random() * 9);
            }
        }
    }

    public int getDimension() {
        return this.dimension;
    }

    public void setDimension(int newDimension) {
        if (newDimension >= 2 && newDimension <= 12)
            this.dimension = newDimension;
        else dimension = 2;
    }


    /*Обхождам матрицата на подматрици с размерност 2х2 по следния начин:
    * 1)0 0 1 1   2)1 1 1 1   3)1 1 1 1   4)1 0 0 1   5)...
    *   0 0 1 1     0 0 1 1     1 1 1 1     1 0 0 1
    *   1 1 1 1     0 0 1 1     0 0 1 1     1 1 1 1
    *   1 1 1 1     1 1 1 1     0 0 1 1     1 1 1 1
    * Обхождаме, където са нулите*/
    public int findMaxSum() {
        int i, j;
        int row = 0;
        int col = 0;
        int stop1 = 1;
        int stop2 = 1;
        int maxSum = 0;

        //обхождаме матрицата, докато текущият индекс на колоната е по-малък от размерността на матрицата
        //например: при размерност = 4 обхождаме, докато индексът на колоната е по-малък от 3
        while(col < dimension - 1) {
            int sum = 0;
            //обхождаме първите два елемента на първите два реда
            for(i = row; i <= stop1; i++) {
                for(j = col; j <= stop2; j++) {
                    //сумираме четирите, обходени елемента
                    sum+= dataArray[i][j];
                }
            }

            //ако текущият индекс на реда е равен на индексът на предпоследния ред
            if(row == dimension - 2) {
                //рестартираме индексът на реда
               row = 0;
               //изместваме колоната с едно надясно
               col++;
               stop2++;
               stop1 = 1;
               //в противен случай
            }else {
                //изместваме реда с едно надолу
                row++;
                stop1++;
            }

            if(maxSum < sum) {
                maxSum = sum;
            }
        }

        return maxSum;
    }

    public void printAll() {

        int i, j;
        int row = 0;
        int col = 0;
        int stop1 = 1;
        int stop2 = 1;
        int maxSum = 0;
        int rowIndex = 0;
        int colIndex = 0;

        while(col < dimension - 1) {
            int sum = 0;
            for(i = row; i <= stop1; i++) {
                for(j = col; j <= stop2; j++) {
                    sum+= dataArray[i][j];
                }
            }

            if(maxSum < sum) {
                maxSum = sum;
                rowIndex = row;
                colIndex = col;
            }

            if(row == dimension - 2) {
                row = 0;
                col++;
                stop2++;
                stop1 = 1;
            }else {
                row++;
                stop1++;
            }

        }

        System.out.println("Sub-matrices with max sum = " + findMaxSum() + ":");
        System.out.println("[" + rowIndex + "," + colIndex + "]");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Dimension: ").append(this.dimension).append('\n');

        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                builder.append(dataArray[i][j]).append(" ");
            }
            builder.append('\n');
        }
        return builder.toString();
    }
}
