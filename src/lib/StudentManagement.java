package lib;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentManagement {
    Map<Integer, ArrayList<String>> Record = new HashMap<>();

    public void populateRecord() {
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
            Record.put(i + 1, studentInfo);
        }
    }
    public void displayRecords() {
        System.out.println("******** Student Records ********");
        System.out.println("Student Name\tAge\tID\tclass");
        
        for(Map.Entry<Integer, ArrayList<String>> entry : Record.entrySet()) {
            ArrayList<String> studentInfo = entry.getValue();
            String name = studentInfo.get(0);
            String age = studentInfo.get(1);
            String id = studentInfo.get(2);
            String className = studentInfo.get(3);
            
            System.out.println(name + "\t\t" + age + "\t" + id + "\t" + className);
        }
    }

    public boolean addStudent(ArrayList<String> studentInfo){
        if (studentInfo == null || studentInfo.size() < 4) {
            System.out.println("❌ Invalid Input");
            return false;
        }

        for(Map.Entry<Integer, ArrayList<String>> entry: Record.entrySet()){
            String studentID = entry.getValue().get(2);
            if(studentID.equals(studentInfo.get(2))){
                System.out.println("⚠️ Student ID already exists!");
                return false;
            }
        }
        
        int newKey = Record.size() + 1;
        Record.put(newKey, studentInfo);
        return true;
    }

    public boolean deleteStudent(String deleteStudentID){
        if (deleteStudentID == null){
            System.out.println("❌ Invalid Input");
            return false;
        }

        for(Map.Entry<Integer, ArrayList<String>> entry: Record.entrySet()){
            String studentID = entry.getValue().get(2);
            if(studentID.equals(deleteStudentID)){
                Record.remove(entry.getKey());
                return true;
            }
        }
        System.out.println("⚠️ ID is not matched with any student");
        return false;
    }

    public boolean updateStudent(String studentID, ArrayList<String> updatedEntry) {
        if (studentID == null || updatedEntry == null || updatedEntry.size() < 4) {
            System.out.println("❌ Invalid Input");
            return false;
        }

        for (Map.Entry<Integer, ArrayList<String>> entry : Record.entrySet()) {
            ArrayList<String> studentInfo = entry.getValue();
            
            if (studentID.equals(studentInfo.get(2))) {
                Record.put(entry.getKey(), updatedEntry);
                return true;
            }
        }
        
        System.out.println("⚠️ No student found with ID: " + studentID);
        return false;
    }
}
