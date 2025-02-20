package task1;

import java.util.ArrayList;
import java.util.List;

public class task1 {
    public static void main(String[] args) {
        int n=0;
        int m=0;
        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
            m = Integer.parseInt(args[1]);

            List<Integer> list = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
                list1.add(i);
            }
            for (int i = 1; true; i++) {
                int vstavka = list.get(i * m - 1);
                list.add(i * m, vstavka);
                list.addAll(list1);

                if (list.get(0) == list.get(i * m - 1)) {
                    for (int j = 0; j < i; j++) {
                        System.out.print(list.get(j * m));
                    }
                    break;
                }
            }
        }
    }
}