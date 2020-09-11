package cn.neyzoter.exam.oppo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Test1
 * @author neyzoter
 */
public class Test2 {
    public static void main(String[] args) {
        String path = "d:/readme.md";
        try {
            read(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void read(String path) throws Exception {
        if (path == null) {
            throw  new Exception("File Path is NULL");
        }
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(path);
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (br != null) {
                br.close();
            }
        }

    }
}

