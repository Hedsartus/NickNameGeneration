import java.util.Arrays;

public class CheckNick {

    public static boolean isPalindrome(String checkNick) {
        StringBuilder stringBuilder = new StringBuilder(checkNick);
        return checkNick.equals(stringBuilder.reverse().toString()) && !isOneWord(checkNick);
    }

    public static boolean isOneWord(String checkNick) {
        for (int i = 0; i < checkNick.length(); i++) {
            if (checkNick.charAt(i) != checkNick.charAt(0)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSorted(String checkNick) {
        char[] arrayChar = checkNick.toCharArray();
        Arrays.sort(arrayChar);
        return checkNick.equals(String.valueOf(arrayChar)) && !isOneWord(checkNick);
    }
}
