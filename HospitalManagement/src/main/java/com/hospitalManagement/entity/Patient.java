package com.hospitalManagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;


@Entity
public class Patient {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message = "Name is required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name should not contain numbers")
    private String name;
	
	@Positive(message = "Age should be a positive number")
    private int age;
	
	@NotBlank(message = "Room is required")
    private String room;
	
	@NotBlank(message = "Doctor name is required")
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Doctor name should not contain numbers")
    private String doctorName;
	
	@NotNull(message = "Admit date is required")
	@PastOrPresent(message = "Admit date should be in the past or present")
    private LocalDate admitDate;
	
	@NotNull(message = "Expenses is required")
    private double expenses;
    
    @Enumerated(EnumType.STRING)
    private PatientStatus status;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public LocalDate getAdmitDate() {
		return admitDate;
	}
	public void setAdmitDate(LocalDate admitDate) {
		this.admitDate = admitDate;
	}
	public double getExpenses() {
		return expenses;
	}
	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}
	public PatientStatus getStatus() {
        return status;
    }

    public void setStatus(PatientStatus status) {
        this.status = status;
    }
    
	public Patient(Long id, String name, int age, String room, String doctorName, LocalDate admitDate, double expenses,
			PatientStatus status) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.room = room;
		this.doctorName = doctorName;
		this.admitDate = admitDate;
		this.expenses = expenses;
		this.status = status;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
    
}
