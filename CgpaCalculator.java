import java.util.*;
import java.util.Scanner;

public class CgpaCalculator {

    static void line(int lines) {
        for (int i = 0; i < lines; i++) {
            System.out.print("- ");
        }
    }

    static void getCgpaClass(double gpa) {
        if (gpa > 4.49)
            System.out.println(" [1st Class Honours]");
        else if (gpa <= 4.49 && gpa >= 3.50)
            System.out.println(" [2nd Class Honours (Upper)]");
        else if (gpa <= 3.49 && gpa >= 2.40)
            System.out.println(" [2nd Class Honours (Lower)]");
        else if (gpa <= 2.39 && gpa >= 1.50)
            System.out.println(" [3rd Class Honours]");
        else if (gpa <= 1.49 && gpa >= 1.00)
            System.out.println(" [Pass]");
        else
            System.out.println(" [Fail]");
    }

    static double getGpa(double firstSemester, double secondSemester, int year) {
        double sessionGpa = (firstSemester + secondSemester) / (double) 2;
        System.out.printf("\n\nYour GPA for your year %d is %.2f\n", year, sessionGpa);
        return sessionGpa;
    }

    static int getScore(char grade, int unitLoad) {
        int score = 0;
        switch (grade) {
            case 'A':
            case 'a':
                score = 5 * unitLoad;
                break;
            case 'B':
            case 'b':
                score = 4 * unitLoad;
                break;
            case 'C':
            case 'c':
                score = 3 * unitLoad;
                break;
            case 'D':
            case 'd':
                score = 2 * unitLoad;
                break;
            case 'E':
            case 'e':
                score = 1 * unitLoad;
                break;
            case 'F':
            case 'f':
                score = 0 * unitLoad;
                break;
            default:
                score = 0;
        }
        return score;
    }

    static double getSemesterGpa(String semester) {
        Scanner yourInput = new Scanner(System.in);
        int courses, unitLoad, courseScore, totalCourseScore = 0, totalUnitLoad = 0;
        char grade;
        double gpa = 0.0;
        String courseName = "";
        System.out.printf("\n\n%s Semester\n", semester);
        System.out.print("How many courses did you offer this semester?(it should be a digit number): ");
        courses = yourInput.nextInt();

        for (int i = 0; i < courses; i++) {
            yourInput.nextLine();
            System.out.print("name of course: ");
            courseName = yourInput.nextLine();
            System.out.print("how many unit load is the course?(it should be a digit number): ");
            unitLoad = yourInput.nextInt();
            System.out.print("What grade did you get?(should be single alphabet character): ");
            grade = yourInput.next().charAt(0);
            System.out.println();
            courseScore = getScore(grade, unitLoad);

            totalUnitLoad = totalUnitLoad + unitLoad;
            totalCourseScore = totalCourseScore + courseScore;
        }

        gpa = (double) totalCourseScore / (double) totalUnitLoad;
        // gpa = (Math.round(gpa * 100.0) / 100.0);
        System.out.printf("\nYour Gpa for %s semester is %.2f", semester, gpa);
        return gpa;

    }

    static void getCgpa(int years, String name) {
        double cgpa, totalGpa = 0;
        System.out.printf(
                "\nHello %s, you are studying a %d years course\nwe need to get your GPA for each year before getting your CGPA\n",
                name, years);

        line(45);

        for (int i = 0; i < years; i++) {
            System.out.printf("\n\nCalculating gpa for your year %d...", i + 1);
            double firstSemesterGpa, secondSemesterGpa;
            firstSemesterGpa = getSemesterGpa("first");
            secondSemesterGpa = getSemesterGpa("second");
            totalGpa = totalGpa + getGpa(firstSemesterGpa, secondSemesterGpa, (i + 1));
        }
        cgpa = totalGpa / years;

        line(35);

        System.out.printf("\n\n Dear %s, Your CGPA is %.2f\n", name, cgpa);
        getCgpaClass(cgpa);

        System.out.printf("Congratulations! \\{^_^}/\n");

        line(35);
    }

    public static void main(String[] args) {
        Scanner yourInput = new Scanner(System.in);

        int years;
        String name, regNo, department;
        System.out.printf("\n\t\t\t\t\tHello there! Welcome to Jerry's Cgpa Calculator.\n");

        line(62);

        System.out.println();
        System.out.print("What is your name: ");
        name = yourInput.nextLine();
        System.out.print("Reg number: ");
        regNo = yourInput.nextLine();
        System.out.print("Department: ");
        department = yourInput.nextLine();
        System.out.print("How many years is your course(it should be a digit number): ");
        years = yourInput.nextInt();

        getCgpa(years, name);

        yourInput.close();

    }

}