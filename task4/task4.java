package task4;

import java.io.*;

public class task4 {
    public static void main(String[] args) {
        try {
            String str = args[0];   // file4.txt

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
            int sum = 0;
            for (int i = 0; i < strings.length; i++) {
                sum += Integer.parseInt(strings[i]);
            }

            int i = sum % strings.length;
            int avg;
            if (i == 0) {
                avg = sum / strings.length;
            } else {
                avg = sum / strings.length + 1;
            }

            int count = 0;
            for (int j = 0; j < strings.length; j++) {
                int c = Integer.parseInt(strings[j]) - avg;
                count += Math.abs(c);
            }
            System.out.println(count);

        } catch (IOException exception) {
            // System.out.println();
        }
    }
}