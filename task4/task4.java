package task4;

import java.io.*;
import java.util.*;

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

            String[] strings = str1.trim().split("[\n]");
            int[] arr = new int[strings.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(strings[i].trim());
            }

            Arrays.sort(arr);
            int min = arr[0];
            int max = arr[arr.length - 1];

            List<Integer> list = new ArrayList<>();
            for (int i = min; i <= max; i++) {
                list.add(i);
            }

            List<Integer> ilist = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                int n = list.get(i);
                int sum = 0;
                for (int j = 0; j < arr.length; j++) {
                    int count = Math.abs(arr[j] - n);
                    sum += count;
                }
                ilist.add(sum);
            }
            int i = Collections.min(ilist);
            System.out.println(i);

        } catch (IOException exception) {
            // System.out.println();
        }
    }
}