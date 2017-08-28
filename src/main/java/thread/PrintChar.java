package thread;

/**
 * Created by samo on 2017/8/28.
 *
 * @author samo
 * @date 2017/08/28
 */
public class PrintChar implements Runnable {

    private char chartoprint;
    private int printnum;

    public PrintChar(char chartoprint, int printnum) {
        this.chartoprint = chartoprint;
        this.printnum = printnum;
    }

    @Override
    public void run() {
        for (int i = 0; i < printnum; i++) {
            System.out.print(chartoprint);
        }
        System.out.println(chartoprint+"-thread");
    }

    public char getChartoprint() {
        return chartoprint;
    }

    public void setChartoprint(char chartoprint) {
        this.chartoprint = chartoprint;
    }

    public int getPrintnum() {
        return printnum;
    }

    public void setPrintnum(int printnum) {
        this.printnum = printnum;
    }
}
