
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNo;
    double marks;

    Student(String name, int rollNo, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    String getGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }
}

public class StudentGradeTracker {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add student
    static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();

        for (Student s : students) {
            if (s.rollNo == rollNo) {
                System.out.println("Roll number already exists!");
                return;
            }
        }

        System.out.print("Enter Marks (0-100): ");
        double marks = sc.nextDouble();
        sc.nextLine();

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks! Enter 0 to 100.");
            return;
        }

        students.add(new Student(name, rollNo, marks));
        System.out.println("Student added successfully!");
    }

    // Display all students
    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n--- STUDENT DETAILS ---");
        System.out.printf("%-15s %-12s %-10s %-8s%n",
                "Name", "Roll No", "Marks", "Grade");

        for (Student s : students) {
            System.out.printf("%-15s %-12d %-10.2f %-8s%n",
                    s.name, s.rollNo, s.marks, s.getGrade());
        }
    }

    // Calculate summary report
    static void summaryReport() {
        if (students.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        double total = 0;
        double highest = students.get(0).marks;
        double lowest = students.get(0).marks;

        Student topStudent = students.get(0);
        Student lowStudent = students.get(0);

        for (Student s : students) {
            total += s.marks;

            if (s.marks > highest) {
                highest = s.marks;
                topStudent = s;
            }

            if (s.marks < lowest) {
                lowest = s.marks;
                lowStudent = s;
            }
        }

        double average = total / students.size();

        System.out.println("\n--- SUMMARY REPORT ---");
        System.out.println("Total Students: " + students.size());
        System.out.printf("Average Marks: %.2f%n", average);
        System.out.println("Highest Marks: " + highest);
        System.out.println("Top Student: " + topStudent.name);
        System.out.println("Lowest Marks: " + lowest);
        System.out.println("Lowest Student: " + lowStudent.name);
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("     STUDENT GRADE TRACKER");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Summary Report");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    summaryReport();
                    break;

                case 4:
                    System.out.println("Thank you for using Student Grade Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
