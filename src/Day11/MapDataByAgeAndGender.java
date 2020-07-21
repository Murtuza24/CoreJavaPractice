package Day11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MapDataByAgeAndGender {

    static List<Person> personList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        getPersonData();

        // grouping by Age as key
        Map<Integer, List<Person>> ageMap = personList.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        // grouping by Gender as key
        Map<String, List<Person>> genderMap = personList.stream()
                .collect(Collectors.groupingBy(Person::getGender));


        System.out.println("ageMap: " + ageMap);
        System.out.println("genderMap: " + genderMap);
    }

    private static void getPersonData() throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader("M:\\UT ARLINGTON\\IMCS\\datafiles\\people.txt"));

        while (true) {
            String line = bfr.readLine();
            if (line == null) {
                break;
            } else {
                String[] data = line.split("\t");
                Person p = new Person();
                p.setName(data[0]);
                p.setAge(Integer.parseInt(data[1]));
                p.setGender(data[2]);
                personList.add(p);
            }
        }
    }

    private static class Person {
        String Name;
        int Age;
        String Gender;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public int getAge() {
            return Age;
        }

        public void setAge(int age) {
            Age = age;
        }

        public String getGender() {
            return Gender;
        }

        public void setGender(String gender) {
            Gender = gender;
        }
    }
}
