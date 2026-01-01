import java.util.Scanner;

public class StudentGradeTracker {

    static class Student {
        String name;
        int marks;
        char grade;

        void calculateGrade() {
            if (marks >= 90) {
                grade = 'A';
            } else if (marks >= 75) {
                grade = 'B';
            } else if (marks >= 60) {
                grade = 'C';
            } else if (marks >= 40) {
                grade = 'D';
            } else {
                grade = 'F';
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[50];
        int count = 0;

        while (true) {
            System.out.println("\n--- Student Grade Tracker ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    students[count] = new Student();

                    System.out.print("Enter Student Name: ");
                    sc.nextLine(); // consume newline
                    students[count].name = sc.nextLine();

                    System.out.print("Enter Marks (0-100): ");
                    students[count].marks = sc.nextInt();

                    students[count].calculateGrade();
                    count++;

                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No student records found.");
                    } else {
                        System.out.println("\nName\tMarks\tGrade");
                        System.out.println("-----------------------");
                        for (int i = 0; i < count; i++) {
                            System.out.println(
                                students[i].name + "\t" +
                                students[i].marks + "\t" +
                                students[i].grade
                            );
                        }
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using Student Grade Tracker!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}