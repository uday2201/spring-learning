package com.example.spring_learning.leetcode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class ComparatorLearning {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "Alice", "EEE"));
        students.add(new Student(100, "Uday", "EEE"));
        students.add(new Student(102, "Charlie", "ECE"));
        students.add(new Student(103, "Alice", "CSE"));

        students.sort(new NameComparator().thenComparing(new RollNoComparator()));
        for(Student s: students) {
            System.out.println(s);
        }

        String name = students.stream().filter(s -> s.department.equals("EEE")).map(student -> student.name.toUpperCase()).findFirst().orElse("");
//        System.out.println("Student in EEE department is : " + name);

        List<Student> nameMatch = students.stream().filter(s -> s.name.equals("Uday")).toList();
        Consumer<Student> printer = Student::print;
        nameMatch.forEach(printer);


        List<List<Student>> studentsList = new ArrayList<>(List.of(students));
        List<String> eeeStudents = studentsList.stream().flatMap(Collection::stream).filter(s -> s.department.equals("EEE")).map(student -> student.name.toUpperCase()).toList();

        eeeStudents.forEach(System.out::println);


        Student s1 = new Student(0, "Alice", "");
        int index= Collections.binarySearch(students, s1, new NameComparator());
        if(index>=0) {
            System.out.println("Student with name Alice is found: "+ students.get(index).toString());
        }

        List<Integer> numsList = List.of(1, 2, 3, 4, 5,6, 7, 4, 5, 6,3);
        Map<Integer, Integer> countMap = numsList.stream().collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum));

        countMap.forEach((key, value) -> System.out.println("The number " + key +
                " present in the array for " + value + " times."));

    }


    static class NameComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.name.compareTo(s2.name);
        }
    }

    static class RollNoComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Integer.compare(s2.getRollNo(), s1.getRollNo());
        }
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Student implements Comparable<Student> {
        private int rollNo;
        private String name;
        private String department;
        @Override
        public int compareTo(Student o) {
            return Integer.compare(o.rollNo, this.rollNo);
        }

        @Override
        public String toString() {
            return rollNo + " " + name + " " + department;
        }

        public void print() {
            System.out.println(this.toString());
        }

    }
}
