import java.io.*;
import java.util.*;

class StringManipulation {
    final static int size = 200;
    static boolean isAlphaNumeric(int[] charHash) {
        boolean num = false, letter = false;
        for(int i = 48; i < 58; i++) {
            if(charHash[i] > 0) {
                num = true;
                break;
            }
        }
        for(int i = 65; i < 91; i++) {
            if(charHash[i] > 0) {
                letter = true;
                break;
            }
        }
        for(int i = 97; i < 123; i++) {
            if(charHash[i] > 0) {
                letter = true;
                break;
            }
        }
        if(num && letter) {
            return true;
        }
        return false;
    }
    static boolean isString(int[] charHash) {
        // for strings
        for(int i = 48; i < 58; i++) {
            if(charHash[i] > 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            String s = br.readLine();
            boolean num = false;
            try {
                int i = Integer.parseInt(s);
                num = true;
            } catch (NumberFormatException nfx) {
                int[] charHash = new int[size];
                // hash occurence of characters in string s
                for(int i = 0; i < s.length(); i++) {
                    charHash[s.charAt(i)]++;
                }
                if(isAlphaNumeric(charHash)) {
                    try {
                        throw new AlphaNumericException();
                    } catch (AlphaNumericException anx) {
                        System.out.println("Its an AlphaNumeric");
                    }
                }
                else if(isString(charHash)) {
                    try {
                        throw new StringException();
                    } catch (StringException sx) {
                        System.out.println("Its a String");
                    }
                }
                else {
                    System.out.println("Valid Format");
                }
            }
            if(num) {
                System.out.println("Valid Format");
            }
        }
    }
}
class AlphaNumericException extends Exception {
}
class StringException extends Exception {
}
