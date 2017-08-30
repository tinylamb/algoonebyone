package nio;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by samo on 2017/8/29.
 *
 * @author samo
 * @date 2017/08/29
 */
public final class MyStdIn {

    private static final Locale LOCALE = Locale.US;
    private static final String CHARSET_NAME = "UTF-8";
    private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

    private static Scanner scanner;
    static {
        resync();
    }

    private static void setScanner(Scanner scanner) {
        //this.scanner = scanner;
        //Static member 'nio.MyStdIn.scanner' can not accessed via instance reference
        MyStdIn.scanner = scanner;
        MyStdIn.scanner.useLocale(LOCALE);
    }

    private static void resync() {
        setScanner(new Scanner(new BufferedInputStream(System.in), CHARSET_NAME));
    }

    /**
     * 禁止实例化
     */
    private MyStdIn() {
    }

    /**
     * Reads and returns the remainder of the input, as a string.
     * @return the remainder of the input, as a string
     */
    public static String readAll() {
        if (!scanner.hasNextLine()) {
            return "";
        }

        String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
        // not that important to reset delimeter, since now scanner is empty
        scanner.useDelimiter(WHITESPACE_PATTERN); // but let's do it anyway
        return result;
    }

    public static String readFileAll(File file) {
        try {
            setScanner(new Scanner(file, CHARSET_NAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        }
        if (!scanner.hasNextLine()) {
            return "";
        }
        String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
        scanner.useDelimiter(WHITESPACE_PATTERN);
        scanner.close();
        return result;
    }

    public static void main(String[] args) {
        ;
    }

}
