package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner {


	StudentRepository studentRepository;
	EmployeeRepository employeeRepository;
	TaskRepository taskRepository;

	public DemoApplication(StudentRepository studentRepository,
						   EmployeeRepository employeeRepository,
						   TaskRepository taskRepository) {
		this.studentRepository = studentRepository;
		this.employeeRepository = employeeRepository;
		this.taskRepository = taskRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// STUDENT
//		log.info("Student id 10001 -> {}", studentRepository.findById(1L));
//		log.info("All users 1 -> {}", studentRepository.findAll());
//		log.info("Find by name -> {}", studentRepository.findByName("Janusz"));
//		log.info("Find by name -> {}", studentRepository.findByName("Romek"));
//		log.info("Find by name -> {}", studentRepository.findByName("Niema"));
//		//Insert
//		log.info("Inserting -> {}", studentRepository.save(new Student("John", "A1234657")));
//		//Update
//		log.info("Update 10001 -> {}", studentRepository.save(new Student(10001L, "Name-Updated", "New-Passport")));
//		studentRepository.deleteById(10002L);
//		log.info("All users 2 -> {}", studentRepository.findAll());

		// EMPLOYEE + TASK
		Task task1 = new Task();
		Task task2 = new Task();
		Task task3 = new Task();
		Task task4 = new Task();

		Employee employee1 = new Employee();
		employee1.setTasks(Arrays.asList(task1, task2));

		log.info("Inserting 4 tasks: " + taskRepository.saveAll(Arrays.asList(task1, task2, task3, task4)));

		log.info("Inserting an employee: " + employeeRepository.save(employee1));

		log.info("Deleting an employee along with his tasks:");
		employeeRepository.delete(employee1);

		// Update works by default?

	}
}
