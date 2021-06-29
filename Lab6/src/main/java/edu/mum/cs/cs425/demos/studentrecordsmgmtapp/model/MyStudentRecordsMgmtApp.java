package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

import com.sun.deploy.util.StringUtils;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MyStudentRecordsMgmtApp {
    public static void main(String[] args) {
        Student[] students = new Student[]{
          new Student(110001, "Dave", LocalDate.of(1951, 11, 18)),
          new Student(110002, "Anna", LocalDate.of(1990, 12, 7)),
          new Student(110003, "Erica", LocalDate.of(1974, 1, 31)),
          new Student(110004, "Carlos", LocalDate.of(2009, 8, 22)),
          new Student(110005, "Bob", LocalDate.of(1990, 3, 5))
        };
        System.out.println("\n---------- All Students ---------\n");
        printListOfStudents(students, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println("\n---------- Platinum Alumni Students ---------\n");
        printListOfStudents(
                getListOfPlatinumAlumniStudents(students),
                (s1, s2) -> s2.getDateOfAdmission().compareTo(s1.getDateOfAdmission())
        );
    }

    public static void printListOfStudents(Student[] students, Comparator<Student> comparator) {
        Student[] copyOFStudents = new Student[students.length];
        System.arraycopy(students, 0, copyOFStudents, 0, students.length);
        Arrays.sort(copyOFStudents, comparator);
        int count = 1;
        for (Student student : copyOFStudents)
        {
            System.out.printf("s%d: studentId:%d, name:%s, \tdateOfAdmission: %s\n",
                    count++, student.getStudentId(), student.getName(),
                    student.getDateOfAdmission().format(
                            DateTimeFormatter.ofPattern("MM/dd/YYYY")
                    ));
        }
    }
    public static Student[] getListOfPlatinumAlumniStudents(Student[] students)
    {
        return Arrays
                .stream(students)
                .filter(student -> LocalDate.now().isAfter(student.getDateOfAdmission().plusYears(30).minusDays(1)))
                .toArray(Student[]::new);
    }
}
