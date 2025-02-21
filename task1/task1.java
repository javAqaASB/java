package task1;

import java.util.ArrayList;
import java.util.List;

public class task1 {
    public static void main(String[] args) {
        int n;
        int m;

        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
            m = Integer.parseInt(args[1]);

            int count = m / n + 1;
            List<Integer> list = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();

            for (int i = 1; i <= count; i++) {
                for (int j = 1; j <= n; j++) {
                    list.add(j);
                    list1.add(j);
                }
            }

            for (int i = 1; true; i++) {
                list.addAll(list1);
                int vstavka = list.get(i * m - 1);
                list.add(i * m, vstavka);

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