/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.controller;

import java.util.Scanner;
import javaconsole.entity.Student;
import javaconsole.model.StudentModel;


public class StudentController {
    // 1. getList.
    // 2. add.
    // 3. edit.
    // 4. delete.
    
    private StudentModel studentModel = new StudentModel();

    // Hàm này sẽ phải trả về danh sách sinh viên.
    public void getList() {
        System.out.println("Get list");
        studentModel.getList();
    }

    // Thêm mới sinh viên, thực hiện việc lấy dữ liệu từ người dùng,
    // validate dữ liệu đó, tiến hành lưu thông tin.
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter student information.");
        System.out.println("Please enter name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter email: ");
        String email = scanner.nextLine();
        System.out.println("Name: " + name + ", email: " + email);
        
        // Validate dữ liệu ở đây.
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setId(System.currentTimeMillis());
        // Lưu thông tin sinh viên vào db.
        studentModel.insert(student);
    }

    public void editStudent() {
        System.out.println("Edit");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter student information update.");
        System.out.println("Please enter index of student:");
        boolean checkIndex = true;
        int index;
        do {
            index = scanner.nextInt();
            if (index <= studentModel.getCountList()) {
                checkIndex = false;
            } else {
                System.err.println("Index false. Please input index again: ");
            }
        } while (checkIndex);
        
        
        System.out.println("Please enter name:");
        String name = scanner.nextLine();
        System.out.println("Please enter email:");
        String email = scanner.nextLine();
        System.out.println("Name: " + name + "\n" + "Email: " + email);

       
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setId(System.currentTimeMillis());

        studentModel.update(student, index);
        
        
    }

    public void deleteStudent() {
        System.out.println("Delete");
        
         System.out.println("Please enter student information delete.");
        System.out.println("Please enter index of student:");
        Scanner scanerIndex = new Scanner(System.in);
        boolean checkIndex = true;
        int index;
        do {
            index = scanerIndex.nextInt();
            if (index <= studentModel.getCountList()) {
                checkIndex = false;
            } else {
                System.err.println("Index false. Please input index again: ");
            }
        } while (checkIndex);

        studentModel.delete(index);
    }
}