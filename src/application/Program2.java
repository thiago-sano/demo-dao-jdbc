package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        // Assim, o programa conhece apenas a interface DepartmentDao, não a implementação DepartmentDaoJDBC que contém toda a lógica

        System.out.println("=== TEST 1: department findById ===");
        Department department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("\n=== TEST 2: department findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department dep : list){
            System.out.println(dep);
        }

        System.out.println("\n=== TEST 3: department insert ===");
        Department newDepartment = new Department(null, "Home");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n=== TEST 4: department update ===");
            department = departmentDao.findById(7);
        department.setName("TV");
        departmentDao.update(department);
        System.out.println("Updated completed");

        System.out.println("\n=== TEST 5: department delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");
    }
}
