import java.util.Scanner;

class Student {
    private String name;
    private int[] marks;
    private int totalMarks;
    private double average;
    private char grade;

    public Student(String name, int numberOfSubjects) {
        this.name = name;
        this.marks = new int[numberOfSubjects];
        this.totalMarks = 0;
        this.average = 0.0;
        this.grade = 'F';
    }

    public void enterMarks() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Marks should be between 0 and 100.");
                i--; // Repeat the input for the current subject
            }
        }
    }

    public void calculateTotalMarks() {
        for (int mark : marks) {
            totalMarks += mark;
        }
    }

    public void calculateAverage() {
        average = (double) totalMarks / marks.length;
    }

    public void calculateGrade() {
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    public void displayResults() {
        System.out.println("\nStudent Name: " + name);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + average + "%");
        System.out.println("Grade: " + grade);
    }
}

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter number of subjects: ");
        int numberOfSubjects = scanner.nextInt();
        
        Student student = new Student(name, numberOfSubjects);
        student.enterMarks();
        student.calculateTotalMarks();
        student.calculateAverage();
        student.calculateGrade();
        student.displayResults();
    }
}
