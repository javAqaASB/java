package task3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class task3 {
    public static void main(String[] args) {
        String str;
        String json;
        String strjson;

        try {
            str = args[0];    //    values.json
            BufferedReader reader = new BufferedReader(new FileReader(str));
            String str1 = "";
            String str2 = reader.readLine();
            while (str2 != null) {
                str1 += str2;
                str2 = reader.readLine();
                str1 += "\n";
            }
            reader.close();

            str1 = str1.replaceAll("\n", " ");

            String[] strings = str1.split("}, ");
            for (int i = 0; i < strings.length; i++) {
                strings[i] = strings[i]
                        .replaceAll("\"values\": ", "")
                        .replaceAll("[{}]", "")
                        .replaceAll("[\\[\\]]", "")
                        .trim();
            }

            List<String> id = new ArrayList<>();
            List<String> value = new ArrayList<>();

            for (int i = 0; i < strings.length; i++) {
                String string = strings[i]
                        .replaceAll("[^0-9]", "");
                id.add("\"id\": " + string);
            }

            for (int i = 0; i < strings.length; i++) {
                String string = strings[i].substring(strings[i].indexOf(",") + 1).trim();
                value.add(string);
            }

            json = args[1];    //    tests.json
            BufferedReader reader2 = new BufferedReader(new FileReader(json));
            String string1 = "";
            String string2 = reader2.readLine();
            while (string2 != null) {
                string1 += string2;
                string2 = reader2.readLine();
                string1 += "\n";
            }
            reader2.close();

            String json2 = string1.replaceAll("\"id\"", "ID\"id\"");
            String[] strings2 = json2.split("ID");
            for (int i = 0; i < strings2.length; i++) {
                if (strings2[i].contains("\"value\": \"\"")) {
                    for (int j = 0; j < id.size(); j++) {
                        if (strings2[i].contains(id.get(j)))
                            strings2[i] = strings2[i].replace("\"value\": \"\"", value.get(j));
                    }
                }
            }
            String strjson2 = String.join("", strings2);
            strjson = args[2];      // report.json;

            FileWriter fileWriter = new FileWriter(strjson);
            fileWriter.write(strjson2);
            fileWriter.close();

        } catch (IOException exception) {
           // System.out.println();
        }
    }
}