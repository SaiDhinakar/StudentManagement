import lib.StudentManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static void displayMenu() {
        System.out.println("\n******** MENU ********");
        System.out.println(
                "1.ADD NEW STUDENT RECORD\n2.DELETE STUDENT RECORD\n3.UPDATE EXISTING STUDENT RECORD\n4.DISPLAY ALL RECORDS\n5.EXIT");
    }

    static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Handle the exception or fallback to printing new lines
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        clearScreen();
        int choice;
        String id;
        boolean res;
        ArrayList<String> studentInfo = new ArrayList<String>();
        ArrayList<String> updatedInfo = new ArrayList<String>();

        Scanner sc = new Scanner(System.in);

        StudentManagement student = new StudentManagement();
        System.out.println("Populating sample data...");
        student.populateRecord();
        System.out.println("Sample Record");
        student.displayRecords();

        do {
            displayMenu();
            System.out.print("\nEnter your choice : ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline after nextInt()
            clearScreen();
            switch (choice) {
                case 1:
                    studentInfo.clear(); // Clear previous entries
                    System.out.println("Enter the details of the student");
                    System.out.print("Name : ");
                    studentInfo.add(sc.nextLine());
                    System.out.print("Age : ");
                    studentInfo.add(sc.nextLine());
                    System.out.print("ID : ");
                    studentInfo.add(sc.nextLine());
                    System.out.print("Class : ");
                    studentInfo.add(sc.nextLine());

                    res = student.addStudent(studentInfo);

                    if (res) {
                        System.out.println("✅ Student record added successfully...");
                    }
                    break;

                case 2:

                    System.out.print("Enter ID of the student to remove : ");
                    id = sc.nextLine();
                    res = student.deleteStudent(id);

                    if (res) {
                        System.out.println("✅ Student record deleted successfully...");
                    }

                    break;

                case 3:
                    studentInfo.clear(); // Clear previous entries
                    updatedInfo.clear(); // Clear previous entries

                    System.out.println("Enter the student ID : ");
                    id = sc.nextLine();

                    System.out.println("Enter the new details of the student");
                    System.out.print("]nName : ");
                    updatedInfo.add(sc.nextLine());
                    System.out.print("Age : ");
                    updatedInfo.add(sc.nextLine());
                    System.out.print("ID : ");
                    updatedInfo.add(sc.nextLine());
                    System.out.print("Class : ");
                    updatedInfo.add(sc.nextLine());

                    res = student.updateStudent(id, updatedInfo);

                    if (res) {
                        System.out.println("✅ Student record updated successfully...");
                    }

                    break;

                case 4:
                    student.displayRecords();
                    break;
                
                case 5:
                    break;

                default:
                    System.out.println("⚠️ Invalid Choice");
            }

        } while (choice != 5);

        sc.close();

    }
}
