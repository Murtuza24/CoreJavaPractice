package Day9;

import Day11.MapDataByAgeAndGender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class SortingLinkedHashMap {
    static LinkedHashMap<String, List<String>> linkedHashMap = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        getPersonData();
        System.out.println("-------------Before Sorting----------------");
        System.out.println(linkedHashMap);


        List<String> keys = new ArrayList(linkedHashMap.keySet());
        Collections.sort(keys);


        System.out.println("-------------Sorting using stream API------------------------");
        linkedHashMap = linkedHashMap.entrySet().stream().sorted((k1, k2) -> k1.getKey().compareTo(k2.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e2, LinkedHashMap::new));




        System.out.println("-------------Sorted------------------------");
        System.out.println(linkedHashMap);

    }

    private static void getPersonData() throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader("M:\\UT ARLINGTON\\IMCS\\datafiles\\people.txt"));

        while (true) {
            String line = bfr.readLine();
            if (line == null) {
                break;
            } else {
                List<String> data = Arrays.asList(line.split("\t"));
                System.out.println(data.get(0) + " " + data.get(1) + " " + data.get(2));

                linkedHashMap.put(data.get(0), data);

            }
        }
    }
}
