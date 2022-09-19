public class RouteCipherTest {
    public static void main(String[] args) {

        //Encryption
        //Negative key example
        RouteCipher rc1 = new RouteCipher(-5);
        System.out.print(rc1.toString());
        String encryptedText1 = rc1.encrypt("ABORT THE MISSION, YOU HAVE BEEN SPOTTED");
        System.out.println(encryptedText1);
        System.out.println();

        //Positive key example
        RouteCipher rc2 = new RouteCipher(5);
        System.out.print(rc2.toString());
        String encryptedText2 = rc2.encrypt("ABORT THE MISSION, YOU HAVE BEEN SPOTTED");
        System.out.println(encryptedText2);
        System.out.println();



        //Decryption
        //Positive key example
        RouteCipher rc3 = new RouteCipher(4);
        System.out.print(rc3.toString());
        String decryptedText1 = rc3.decrypt("TIEIXTXXEAHSIHSPNTLT");
        System.out.println(decryptedText1);
        System.out.println();

        //Negative key example
        RouteCipher rc4 = new RouteCipher(-4);
        System.out.print(rc4.toString());
        String decryptedText2 = rc4.decrypt("XEAHSIHTIEIXTXTLTSPNT");
        System.out.println(decryptedText2);
        System.out.println();

    }
}
