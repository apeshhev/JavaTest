package Problem2;

import java.util.Random;
import java.text.NumberFormat;

public class DrawRandomNumber {
    public static void main(String[] args) {
        calculateProbability(10000);
        calculateProbability(60000);
    }

    public static int drawRandomNumber() {
        Random random = new Random();
        final int randomNumber = random.nextInt(100);
        if (randomNumber > 50) { // P(3)=0.5
            return 3;
        } else if (randomNumber > 20) { //P(2)=0.3
            return 2;
        } else {
            return 1; //P(1)=0.2
        }
    }

    public static void calculateProbability(int range) {
        int randomNumber;
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        double p1, p2, p3; //probability variables

        for (int i = 0; i < range; i++) {
            randomNumber = drawRandomNumber();
            if (randomNumber == 1) {
                cnt1++;
            }
            else if (randomNumber == 2) {
                cnt2++;
            }
            else  {
                cnt3++;
            }
        }
        //calculating the probability
        p1 = (double)cnt1 / range ;
        p2 = (double)cnt2 / range ;
        p3 = (double)cnt3 / range ;

        System.out.println(range + " times:");
        NumberFormat format = NumberFormat.getPercentInstance();
        String percentage1 = format.format(p1);
        System.out.println("P(1): " + p1 + percentage1);

        String percentage2 = format.format(p2);
        System.out.println("P(2): " + p2 + percentage2);

        String percentage3 = format.format(p3);
        System.out.println("P(3): " + p3 + percentage3);

    }
}
