
package com.midtree.hospitaldetails;

import static org.junit.Assert.assertEquals;
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
	 
	@Test
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
	
	@Test
	public void showPatientInformationTest() {
		Integer id=1;
		when(service.showPatientInformation(id)).thenReturn((Patient) Stream.of(new Patient(1,"kam",22,"chan",LocalDate.now(),"male","has")).collect(Collectors.toList()));
		assertEquals(1,((List<Patient>) service.showPatientInformation(id)).size());
		
	}
	
}



