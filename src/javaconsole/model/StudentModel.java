/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.model;

import java.util.ArrayList;
import java.util.Scanner;
import javaconsole.controller.StudentController;
import javaconsole.entity.Student;

public class StudentModel {

    private static ArrayList<Student> listStudent;

    public void getList() {

        if (listStudent == null) {
            listStudent = new ArrayList<Student>();
            System.out.println("List student is empty!");
        } else {

            
            System.out.println("======List student======");
            listStudent.forEach(listStudent -> {
                System.out.println("ID: " + listStudent.getId());
                System.out.println("Name: " + listStudent.getName());
                System.out.println("Email: " + listStudent.getEmail());
                System.out.println("");
            });
        }
    }

    public void insert(Student student) {
        if (listStudent == null) {
            listStudent = new ArrayList<Student>();
        }
        listStudent.add(student);
        System.out.println("======List name student======");
        for (Student student1 : listStudent) {
            System.out.println(student1.getName());
        }
        System.out.println("==============================");
    }
    
    public int getCountList() {
        return listStudent.size();
    }


    public void update(Student student, int index) {
        
            index--;
        listStudent.set(index, student);
        
    }

     public void delete(int index) {
        index--;
        listStudent.remove(index);
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "Nguyen Ba Danh", "vodanh@master.top.co");
        Student student2 = new Student(2, "Vu Van Truong", "truong@fpt.edu.vn");
        Student student3 = new Student(3, "Leo Messi", "messi@fifa.bar");
        listStudent.add(student1);
        listStudent.add(student2);
        listStudent.add(student3);

    }

   

}
