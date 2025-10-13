package com.synergistics.javacore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student{
    int id;
    String department;
    String subjectName;

    public Student(int id, String department, String subjectName) {
        this.id = id;
        this.department = department;
        this.subjectName = subjectName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}

public class StudentCollection {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1001,"Engineering","Pulse Technology"));
        studentList.add(new Student(1002,"Engineering","MicroProcessors"));
        studentList.add(new Student(1003,"Biology","Biology 101"));
        studentList.add(new Student(1004,"Biology","Molecular Biology"));
        studentList.add(new Student(1005,"Chemistry","Study of Elements"));
        studentList.add(new Student(1006,"Chemisty","Organic Chemisty"));

        //Putting the output to a Map
        Map<String,List<Student>> map = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));

        System.out.println(map);
    }


}
