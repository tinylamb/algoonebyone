package basic;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by samo on 2018/4/3.
 *
 * @author samo
 * @date 2018/04/03
 */
public class ArrayBasic {

    public static void shuffle() {
        String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };

        String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"
        };
        final int suitslen = SUITS.length;
        final int rankslen = RANKS.length;

        String[] poker = new String[suitslen * rankslen];
        int pos;
        for (int i = 0; i < suitslen; i++) {
            for (int j = 0; j < rankslen; j++) {
                pos = i * rankslen + j;
                poker[pos] = SUITS[i].concat("_").concat(RANKS[j]);
            }
        }
        poker = knuthDurstenfeld(poker);
        System.out.println(poker.length);
        Test.printArr(poker);
    }

    public static String[] fisherYates(String[] poker) {
        if (poker == null || poker.length == 0) {
            return null;
        }
        String[] shuffle = new String[poker.length];
        int pos;
        int index = 0;
        while (poker.length > 0) {
            pos = (int)(Math.random() * poker.length);
            shuffle[index++] = poker[pos];
            //这里remove 值得学习
            poker = ArrayUtils.remove(poker, pos);
        }
        return shuffle;
    }

    public static String[] knuthDurstenfeld(String[] poker) {
        if (poker == null || poker.length == 0) {
            return null;
        }
        int len = poker.length;
        int pos;
        for (int i = len - 1; i >= 0; i--) {
            pos = (int)(Math.random() * (i + 1));
            swap(poker, i, pos);
        }
        return poker;
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T tmp;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        shuffle();
    }

}
