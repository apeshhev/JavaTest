import java.util.Scanner;

public class Hamming {

    private static int hammingDistance(int fNum, int sNum)
    {
        int helper = fNum ^ sNum;
        System.out.println(helper);
        int bits = 0;

        while (helper > 0)
        {
            bits += helper & 1;
            System.out.println(bits);
            helper >>= 1;
            System.out.println(helper);
        }

        return bits;
    }

    public static String intToBinary(int num)
    {
        String str = "";
        while (num > 0)
        {
            str =  ( (num % 2 ) == 0 ? "0" : "1") + str;
            num /= 2;
        }
        return str;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int fNum, sNum;
        System.out.print("Enter the first number: ");
        fNum = input.nextInt();

        System.out.print("Enter the second number: ");
        sNum = input.nextInt();

        System.out.println("The hamming distance between the first and the second number is: " + hammingDistance(fNum, sNum));
        System.out.println("The binary representation of the first number is: " + intToBinary(fNum));
        System.out.println("The binary representation of the second number is: " + intToBinary(sNum));
    }
}
