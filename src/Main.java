import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger wordLength3 = new AtomicInteger();
        AtomicInteger wordLength4 = new AtomicInteger();
        AtomicInteger wordLength5 = new AtomicInteger();

        List<String> textNicks = getNickNames(100);

        new Thread(() -> {
            for (String nick : textNicks) {
                if (nick.length() == 3 && CheckNick.isPalindrome(nick)) {
                    wordLength3.incrementAndGet();
                }
                if (nick.length() == 4 && CheckNick.isPalindrome(nick)) {
                    wordLength4.incrementAndGet();
                }
                if (nick.length() == 5 && CheckNick.isPalindrome(nick)) {
                    wordLength5.incrementAndGet();
                }
            }
        }).start();

        new Thread(() -> {
            for (String nick : textNicks) {
                if (nick.length() == 3 && CheckNick.isOneWord(nick)) {
                    wordLength3.incrementAndGet();
                }
                if (nick.length() == 4 && CheckNick.isOneWord(nick)) {
                    wordLength4.incrementAndGet();
                }
                if (nick.length() == 5 && CheckNick.isOneWord(nick)) {
                    wordLength5.incrementAndGet();
                }
            }
        }).start();

        new Thread(() -> {
            for (String nick : textNicks) {
                if (nick.length() == 3 && CheckNick.isSorted(nick)) {
                    wordLength3.incrementAndGet();
                }
                if (nick.length() == 4 && CheckNick.isSorted(nick)) {
                    wordLength4.incrementAndGet();
                }
                if (nick.length() == 5 && CheckNick.isSorted(nick)) {
                    wordLength5.incrementAndGet();
                }
            }
        }).start();

        System.out.println("Красивых слов с длиной 3 : " + wordLength3 + " шт");
        System.out.println("Красивых слов с длиной 4 : " + wordLength4 + " шт");
        System.out.println("Красивых слов с длиной 5 : " + wordLength5 + " шт");
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public static List<String> getNickNames(int count) {
        Random random = new Random();
        List<String> texts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            texts.add(generateText("abc", 3 + random.nextInt(3)));
        }
        return texts;
    }
}
