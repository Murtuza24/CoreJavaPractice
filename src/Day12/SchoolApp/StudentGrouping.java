package Day12.SchoolApp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class StudentGrouping {

    static DBConnection DBMgr = DBConnection.getInstance();
    private static Connection con = DBConnection.getDBConnection();
    private static Statement st = null;
    static ResultSet resultSet;

    public static void main(String[] args) {
        HashMap<String, List<String>> studentsMap = new HashMap<>();

        String[] groups = new String[4];
        groups[0] = "RED";
        groups[1] = "BLUE";
        groups[2] = "GREEN";
        groups[3] = "YELLOW";

        List<String> studentsList = new ArrayList<>();
        studentsList = getStudentsDetails();


        int groupStrength = studentsList.size() / groups.length;
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

        updateGroupsInDB(studentsMap);

        System.out.println("Done");
    }

    private static void updateGroupsInDB(HashMap<String, List<String>> studentsMap) {

        for (String key : studentsMap.keySet()) {
            for (String id : studentsMap.get(key)) {

                String updateQuery = "Update student set `Group` = '" + key + "' where StudentId = '" + id + "'";

                try {
                    st = con.createStatement();
                    int res = st.executeUpdate(updateQuery);
                    con.commit();

                    if (res == 1) {
                        System.out.println("Group for " + id + " updated.!");
                    } else {
                        System.out.println(" group not updated.");
                    }


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        }

    }

    private static List<String> getStudentsDetails() {
        List<String> studList = new ArrayList<>();
        try {
            String query = "SELECT StudentId FROM `student`;";

            System.out.println(query);

            st = con.createStatement();
            resultSet = st.executeQuery(query);

            while (resultSet.next()) {
                String StudentId = resultSet.getString("StudentId");
                studList.add(StudentId);
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

        return studList;
    }
}
