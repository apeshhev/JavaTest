public class MonetaryCoinTest {
    public static int getSum(int value1, int value2, int value3) {
        return value1 + value2 + value3;
    }

    public static void main(String[] args) {
        MonetaryCoin mc1 = new MonetaryCoin(Face.HEAD, 2);
        MonetaryCoin mc2 = new MonetaryCoin(Face.TAIL, 100);
        MonetaryCoin mc3 = new MonetaryCoin(Face.HEAD, 20);

        System.out.println("Sum = " + getSum(mc1.getMonetaryCoinValue(), mc2.getMonetaryCoinValue(), mc3.getMonetaryCoinValue()));

        for (int i = 0; i < 3; i++) {
            mc1.flip();
            System.out.println("Coin1 after flipping:");
            System.out.println(mc1 + " " + mc1.isHeads());

            mc2.flip();
            System.out.println("Coin2 after flipping:");
            System.out.println(mc2 + " " + mc2.isHeads());

            mc3.flip();
            System.out.println("Coin3 after flipping:");
            System.out.println(mc3 + " " + mc3.isHeads());
        }
    }
}
