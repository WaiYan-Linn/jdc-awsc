package com.jdc.mappings;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Classes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private LocalDate startDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private double months;
	private int fees;
	
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private List<Days> days;
	
	public enum Days{
			MON,TUE,WED,THU,FRI,SAT,SUN
	}
	
	@ManyToOne
	private Course course;
	
	@ManyToOne
	private Teacher head;
	
	@OneToMany
	private List<Teacher> teacher;
	
}
