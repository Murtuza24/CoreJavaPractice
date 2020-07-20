package Day12.SchoolApp;

import java.util.*;

public class StudentGrouping {
    public static void main(String[] args) {
        String[] groups = new String[4];
        groups[0] = "RED";
        groups[1] = "BLUE";
        groups[2] = "GREEN";
        groups[3] = "YELLOW";

        HashMap<String, List<String>> studentsMap = new HashMap<>();

        System.out.println("Enter total number of students: ");
        int n = new Scanner(System.in).nextInt();


        List<String> studentsList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            studentsList.add("Student" + i);
        }

//        studentsList.forEach(System.out::println);
//        studentsMap.forEach((key, value) -> System.out.println(key + " " + value));


        int groupStrength = studentsList.size() / groups.length;
//        System.out.println(groupStrength);
//        System.out.println(studentsList.size() % groups.length);
        int remainder = studentsList.size() % groups.length;
        Random rand = new Random();
        for (String key : groups) {
            studentsMap.put(key, new ArrayList<>());
            for (int j = 0; j < groupStrength; j++) {
                int randomIndex = rand.nextInt(studentsList.size());

                studentsMap.get(key).add(studentsList.get(randomIndex));

                // Remove selected element from orginal list
                studentsList.remove(randomIndex);

            }
            // allotting the remainders
            if (remainder > 0) {
                int randomIndex = rand.nextInt(studentsList.size());

                studentsMap.get(key).add(studentsList.get(randomIndex));

                // Remove selected element from orginal list
                studentsList.remove(randomIndex);
                remainder--;
            }


        }
        studentsMap.forEach((key, value) -> System.out.println(key + " " + value));
        System.out.println("Done");
    }
}
