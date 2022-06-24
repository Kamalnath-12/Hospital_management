package com.midtree.hospitaldetails;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.midtree.hospitaldetails.entity.Doctor;
import com.midtree.hospitaldetails.entity.Patient;
import com.midtree.hospitaldetails.repository.DoctorRepository;
import com.midtree.hospitaldetails.repository.PatientRepository;
import com.midtree.hospitaldetails.service.HospitalService;

@RunWith(SpringRunner.class)
@SpringBootTest
class HospitaldetailsApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private HospitalService service;
	
	@MockBean
	private DoctorRepository doctorrepository;
	
	
	@MockBean
	private PatientRepository patientrepository;
	 
	@Test  //working 
	public void showDoctorInformation() {
		when(doctorrepository.findAll()).thenReturn(Stream
				.of(new Doctor("chandu",22,"male","neurologist"),new Doctor("rajan",22,"male","neurologist")).collect(Collectors.toList()));
		assertEquals(2,service.getDoctors().size());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void showdoctorinformationTest() {
		String name="kamal";
		when(((DoctorRepository) service).findByName(name)).thenReturn((Doctor) Stream
				.of(new Doctor("chandu",22,"male","neurologist"),new Doctor("rajan",22,"male","neurologist")).collect(Collectors.toList()));
		assertEquals(2,((List<Doctor>) service.showDoctorInformation(name)).size());
				
	}
	
	@Test //working
	public void showAllDOCTORStinformationTest() 
	{
		   List<Doctor> list = (List<Doctor>) doctorrepository.findAll() ;
		  assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void creatingdoctorTest() {
		Doctor d=new Doctor();
		d.setName("k");
		d.setAge(22);
		d.setGender("male");
		d.setField("general");
		d.setPatient_count();
		doctorrepository.save(d);
		//assertNotNull(doctorrepository.findByName("k").getName());
		
	}
	
}


