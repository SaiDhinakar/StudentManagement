import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    Map<Integer, ArrayList<String>> sampleRecord = new HashMap<>();

    void populateRecord() {
        // Define arrays with student information
        String[] names = {"Alex", "John", "Bob", "Alice", "Elsa"};
        String[] ages = {"18", "19", "17", "18", "19"};
        String[] ids = {"A12", "J45", "B67", "A89", "E34"};
        String[] classes = {"XI", "XII", "X", "XI", "XII"};

        // Populate the sampleRecord map with student information
        for (int i = 0; i < names.length; i++) {
            ArrayList<String> studentInfo = new ArrayList<>();
            studentInfo.add(names[i]);    // Add name
            studentInfo.add(ages[i]);     // Add age
            studentInfo.add(ids[i]);      // Add ID
            studentInfo.add(classes[i]);  // Add class
            
            // Put the student info in the map with a student ID as the key
            sampleRecord.put(i + 1, studentInfo);
        }
    }
    void displayRecords() {
        System.out.println("Student Name\tAge\tID\tclass");
        
        for(Map.Entry<Integer, ArrayList<String>> entry : sampleRecord.entrySet()) {
            ArrayList<String> studentInfo = entry.getValue();
            String name = studentInfo.get(0);
            String age = studentInfo.get(1);
            String id = studentInfo.get(2);
            String className = studentInfo.get(3);
            
            System.out.println(name + "\t\t" + age + "\t" + id + "\t" + className);
        }
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.populateRecord();
        obj.displayRecords();
    }
}
