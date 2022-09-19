public class RouteCipher {

    private int key;

    public RouteCipher() {
        setKey(1);
    }

    public RouteCipher(int key) {
        setKey(key);
    }

    public RouteCipher(RouteCipher rc) {
        this.key = rc.key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    //method for printing each matrix we want to print
    private void print(char[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //method for filling the matrix with the given text and X at the end of the matrix if it is needed
    private char[][] fill(char[] text, int rows, int cols) {

        char[][] matrix = new char[rows][cols];
        int pos = 0;

        for (int i = 0; i < rows; i++) {
            for (int  j = 0; j < cols; j++) {
                if (text.length <= pos) {
                    matrix[i][j] = 'X';
                }
                else {
                    matrix[i][j] = text[pos];
                }
                ++pos;
            }
        }
        return matrix;
    }

    //if we have positive key we read the matrix from the top left corner counter clockwise
    private char[] positiveSpiral(char[][] matrix, int rows, int cols) {

        //char array for stacking the encrypted text
        char[] encryptedArray = new char[rows * cols];
        int cnt = 0;

        int i;
        int rowStart=0;
        int rowEnd=rows-1;
        int colStart=0;
        int colEnd=cols-1;
        int allElements = rows * cols;

        while(colStart<=colEnd && rowStart<=rowEnd) {

            //Top-left to bottom-left
            for (i = rowStart; i < rowEnd; i++) {
               encryptedArray[cnt] = matrix[i][rowStart];
               cnt++;
                if (cnt == allElements)
                    break;
            }

            //Bottom-left to bottom-right
            for (i = colStart; i < colEnd; i++) {
                encryptedArray[cnt] = matrix[rowEnd][i];
                cnt++;
                if (cnt == allElements)
                    break;
            }

            //Bottom-right to top-right
            for (i = rowEnd; i > rowStart; i--) {
                encryptedArray[cnt] = matrix[i][colEnd];
                cnt++;
                if (cnt == allElements)
                    break;
            }

            //Top-right to top-left
            for (i = colEnd; i > colStart; i--) {
                encryptedArray[cnt] = matrix[rowStart][i];
                cnt++;
                if (cnt == allElements)
                    break;
            }

            rowStart++;
            colEnd--;
            rowEnd--;
            colStart++;

        }

        return encryptedArray;
    }

    //if we have negative key we read the matrix from the bottom-right corner counter clockwise
    private char[] negativeSpiral(char[][] matrix, int rows, int cols) {

        char[][] rotatedMatrix = rotateMatrix(matrix, rows, cols);
        return positiveSpiral(rotatedMatrix, rows, cols);

    }

    //help method to rotate the matrix 180 degrees for the negative key encryption
    private char[][] rotateMatrix(char[][] matrix, int rows, int cols) {

        for (int i = 0; i < rows / 2; i++) {
            for (int j = 0; j < cols; j++) {
                char temp = matrix[i][j];
                matrix[i][j] = matrix[rows - i - 1][cols - j - 1];
                matrix[rows - i - 1][cols - j - 1] = temp;
            }
        }

        //for odd rows
        if (rows % 2 != 0) {
            for (int i = 0; i < cols / 2; i++) {
                char temp = matrix[rows / 2][i];
                matrix[rows / 2][i] = matrix[rows - rows / 2 - 1][cols - i - 1];
                matrix[rows - rows / 2 - 1][cols - i - 1] = temp;
            }
        }
        return matrix;
    }


    public String encrypt(String plainText) {

        String input = plainText.replaceAll("\\W","");
        char[] text = input.toCharArray();
        int cols = (Math.abs(this.key));
        int rows = (text.length / cols) + 1;

        System.out.println();
        System.out.println("Encryption:");
        System.out.println(text);

        char[][] filledMatrix = fill(text, rows, cols);
        print(filledMatrix, rows, cols);
        System.out.println("Result:");

        String positiveKey = new String(positiveSpiral(filledMatrix, rows, cols));
        String negativeKey = new String(negativeSpiral(filledMatrix, rows, cols));

        if (this.key > 0) {
            return positiveKey;
        } else {
            return negativeKey;
        }
    }

    //filling the matrix for top-right element
    private char[][] fillEncryptedText(char[] matrix, int rows, int cols) {

        char[][] matrixWithEncText = new char[rows][cols];

        int i;
        int rowStart = 0;
        int rowEnd = rows - 1;
        int colStart = cols - 1;
        int colEnd = 0;
        int cnt = 0;

        while (rowStart <= rowEnd && colStart >= colEnd) {

            //first row
            for (i = colStart; i >= colEnd; --i) {
                matrixWithEncText[rowStart][i] = matrix[cnt];
                cnt++;
            }
            rowStart++;

            //first column
            if (colStart >= colEnd) {
                for (i = rowStart; i <= rowEnd; ++i) {
                    matrixWithEncText[i][colEnd] = matrix[cnt];
                    cnt++;
                }
                colEnd++;
            }

            //last row
            if (rowStart <= rowEnd) {
                for (i = colEnd; i <= colStart; i++) {
                    matrixWithEncText[rowEnd][i] = matrix[cnt];
                    cnt++;
                }
                rowEnd--;
            }

            //last column
            if (colStart >= colEnd) {
                for (i = rowEnd; i >= rowStart; i--) {
                    matrixWithEncText[i][colStart] = matrix[cnt];
                    cnt++;
                }
                colStart--;
            }
        }
        return matrixWithEncText;
    }

    //reading the filled matrix by columns
    private char[] decryptPositive(char[][] filledMatrix, int rows, int cols) {
        char[] temp = new char[rows * cols];
        int cnt = 0;
        for (int i = cols - 1; i >= 0; i--) {
            for (int j = 0; j < rows; j++) {
                temp[cnt] = filledMatrix[j][i];
                cnt++;
            }
        }
        return temp;
    }

    //same as the negative key encryption
    private char[] decryptNegative(char[][] filledMatrix, int rows, int cols) {
        char[][] rotatedMatrix = rotateMatrix(filledMatrix, rows, cols);
        return decryptPositive(rotatedMatrix, rows, cols);
    }

    public String decrypt(String encryptedText) {

        String input = encryptedText.replaceAll("\\W", "");
        char[] text = input.toCharArray();

        int rows = (Math.abs(this.key));
        int cols = (text.length / rows);

        System.out.println();
        System.out.println("Decrypting:");
        System.out.println(text);

        char[][] filledMatrix = fillEncryptedText(text, rows, cols);
        print(filledMatrix, rows, cols);


        char[] withPositiveKey = decryptPositive(filledMatrix, rows, cols);
        char[] withNegativeKey = decryptNegative(filledMatrix, rows, cols);

        int cnt = countX(withNegativeKey);
        String positiveKey = new String(removeXs(cnt, withPositiveKey));
        String negativeKey = new String(removeXs(cnt, withNegativeKey));

        System.out.println("Result:");
        return (this.key > 0) ? positiveKey : negativeKey;
    }

    //remove X characters at the end
    private char[] removeXs(int amountOfXs, char[] textWithX) {
        char[] textWithoutX = new char[textWithX.length - amountOfXs];
        for (int i = 0; i < textWithX.length - amountOfXs; i++) {
            textWithoutX[i] = textWithX[i];
        }
        return textWithoutX;
    }

    //count X characters at the end
    private int countX(char[] text) {
        int cnt = 0;
        if (key < 0) {
            for (int i = text.length - 1; i > 0; i--) {
                if (text[i] == 'X') {
                    cnt++;
                } else {
                    break;
                }
            }
        }
        if (key > 0) {
            for (int i = 0; i < text.length; i++) {
                if (text[i] == 'X') {
                    cnt++;
                } else {
                    break;
                }
            }
        }
        return cnt;
    }

    @Override
    public String toString() {
        return "RouteCipher{" +
                "key=" + key +
                '}';
    }
}
