package cn.neyzoter.exam.cts;

import java.util.*;

/**
 * Test2
 * @author neyzoter
 */
public class Test2 {
    public static final String REDO = "redo";
    public static final String UNDO = "undo";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String phase = sc.nextLine();
        String[] words = phase.split("\t| ");
        List<String> list = new ArrayList<>();
        Stack<String> undoStack = new Stack<>();
        for (String w : words) {
            if (w.length() == 0) {
                continue;
            }
            if (w.equals(UNDO)) {
                if (list.size() > 0) {
                    String rmdWord = list.remove(list.size() - 1);
                    undoStack.add(rmdWord);
                }
            } else if (w.equals(REDO)) {
                if (undoStack.size() > 0) {
                    String redoWord = undoStack.pop();
                    list.add(redoWord);
                }
            } else {
                list.add(w);
                undoStack.clear();
            }
        }
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String word = iter.next();
            System.out.print(word);
            if (iter.hasNext()) {
                System.out.print(" ");
            }
        }
    }
}

