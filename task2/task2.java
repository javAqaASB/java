package task2;

import java.io.*;
import java.math.BigDecimal;

public class task2 {
    public static void main(String[] args) {

        BigDecimal x0;
        BigDecimal y0;
        BigDecimal r;
        BigDecimal[] arr;
        String str;
        String string;

        try {
            str = args[0];    //    file1.txt
            string = args[1]; //    file2.txt

            BufferedReader reader = new BufferedReader(new FileReader(str));
            String str1 = "";
            String str2 = reader.readLine();
            while (str2 != null) {
                str1 += str2;
                str2 = reader.readLine();
                str1 += "\n";
            }
            reader.close();

            String[] strings = str1.trim().split("[\n ]");

            x0 = new BigDecimal(strings[0]);
            y0 = new BigDecimal(strings[1]);
            r = new BigDecimal(strings[2]);

            BufferedReader reader2 = new BufferedReader(new FileReader(string));
            String string1 = "";
            String string2 = reader2.readLine();
            while (string2 != null) {
                string1 += string2;
                string2 = reader2.readLine();
                string1 += "\n";
            }
            reader2.close();

            String[] strings2 = string1.trim().split("[\n ]");

            arr = new BigDecimal[strings2.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new BigDecimal(strings2[i]);
            }

            for (int i = 0; i < arr.length; i += 2) {
                BigDecimal x1 = arr[i];
                BigDecimal y1 = arr[i + 1];
                method(x1, x0, y1, y0, r);
            }
        } catch (IOException exception) {
            // System.out.println();
        }
    }

    public static void method(BigDecimal x1, BigDecimal x0, BigDecimal y1, BigDecimal y0, BigDecimal r) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(x1.subtract(x0).multiply((x1.subtract(x0))).add(y1.subtract(y0).multiply((y1.subtract(y0))))));
        if (bigDecimal.compareTo(r.multiply(r)) == 0) {
            System.out.println(0);
        } else if (bigDecimal.compareTo(r.multiply(r)) < 0) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}
