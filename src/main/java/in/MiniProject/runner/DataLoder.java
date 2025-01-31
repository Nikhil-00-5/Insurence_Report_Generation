package in.MiniProject.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.MiniProject.beans.CitizenPlan;
import in.MiniProject.repository.CitizenPlanRepo;
@Component
public class DataLoder implements ApplicationRunner{
	@Autowired
	private CitizenPlanRepo repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();
		
		CitizenPlan c1=new CitizenPlan();
		c1.setCitizenName("Karan");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now().minusMonths(1));
		c1.setPlanEndDate(LocalDate.now().plusMonths(5));
		c1.setBenefitAmt(5000.00);
		
		CitizenPlan c2=new CitizenPlan();
		c2.setCitizenName("Ganesh");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setDenialReason("Rental Income");
		
		CitizenPlan c3=new CitizenPlan();
		c3.setCitizenName("Sanket");
		c3.setGender("Male");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(5));
		c3.setPlanEndDate(LocalDate.now().plusMonths(1));
		c3.setBenefitAmt(85000.00);
		c3.setTerminationDate(LocalDate.now());
		c3.setTerminationRsn("Employed");
		
		
		CitizenPlan c4=new CitizenPlan();
		c4.setCitizenName("Nikhil");
		c4.setGender("Male");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now().minusMonths(4));
		c4.setPlanEndDate(LocalDate.now().plusMonths(2));
		c4.setBenefitAmt(65000.00);
		
		CitizenPlan c5=new CitizenPlan();
		c5.setCitizenName("Sourabh");
		c5.setGender("Male");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setDenialReason("Property  Income");
		
		CitizenPlan c6=new CitizenPlan();
		c6.setCitizenName("Ram");
		c6.setGender("Male");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setPlanEndDate(LocalDate.now().plusMonths(2));
		c6.setBenefitAmt(25000.00);
		c6.setTerminationDate(LocalDate.now());
		c6.setTerminationRsn("Employed");
		
		
		CitizenPlan c7=new CitizenPlan();
		c7.setCitizenName("Prashant");
		c7.setGender("Male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenefitAmt(10000.00);
		
		CitizenPlan c8=new CitizenPlan();
		c8.setCitizenName("Mauli");
		c8.setGender("Male");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denied");
		c8.setDenialReason("Govt Job");
		
		CitizenPlan c9=new CitizenPlan();
		c9.setCitizenName("Tejas");
		c9.setGender("Male");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(3));
		c9.setPlanEndDate(LocalDate.now().plusMonths(3));
		c9.setBenefitAmt(20000.00);
		c9.setTerminationDate(LocalDate.now());
		c9.setTerminationRsn("Employed");
		
		CitizenPlan c10=new CitizenPlan();
		c10.setCitizenName("Anuj");
		c10.setGender("Male");
		c10.setPlanName("Employment");
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenefitAmt(55000.00);
		
		CitizenPlan c11=new CitizenPlan();
		c11.setCitizenName("Sachin");
		c11.setGender("Male");
		c11.setPlanName("Employment");
		c11.setPlanStatus("Denied");
		c11.setDenialReason("Rental Income");
		
		CitizenPlan c12=new CitizenPlan();
		c12.setCitizenName("Prakash");
		c12.setGender("Male");
		c12.setPlanName("Employment");
		c12.setPlanStatus("Terminated");
		c12.setPlanStartDate(LocalDate.now().minusMonths(2));
		c12.setPlanEndDate(LocalDate.now().plusMonths(4));
		c12.setBenefitAmt(5000.00);
		c12.setTerminationDate(LocalDate.now());
		c12.setTerminationRsn("Govt Job");
		
		CitizenPlan c13=new CitizenPlan();
		c13.setCitizenName("Radha");
		c13.setGender("Female");
		c13.setPlanName("Cash");
		c13.setPlanStatus("Approved");
		c13.setPlanStartDate(LocalDate.now().minusMonths(3));
		c13.setPlanEndDate(LocalDate.now().plusMonths(3));
		c13.setBenefitAmt(50000.00);
		
		CitizenPlan c14=new CitizenPlan();
		c14.setCitizenName("Sita");
		c14.setGender("Female");
		c14.setPlanName("Cash");
		c14.setPlanStatus("Denied");
		c14.setDenialReason("Rental Income");
		
		CitizenPlan c15=new CitizenPlan();
		c15.setCitizenName("Gita");
		c15.setGender("Female");
		c15.setPlanName("Cash");
		c15.setPlanStatus("Terminated");
		c15.setPlanStartDate(LocalDate.now().minusMonths(1));
		c15.setPlanEndDate(LocalDate.now().plusMonths(5));
		c15.setBenefitAmt(80000.00);
		c15.setTerminationDate(LocalDate.now());
		c15.setTerminationRsn("Employed");
		
		
		CitizenPlan c16=new CitizenPlan();
		c16.setCitizenName("Babita");
		c16.setGender("Female");
		c16.setPlanName("Food");
		c16.setPlanStatus("Approved");
		c16.setPlanStartDate(LocalDate.now());
		c16.setPlanEndDate(LocalDate.now().plusMonths(6));
		c16.setBenefitAmt(40000.00);
		
		CitizenPlan c17=new CitizenPlan();
		c17.setCitizenName("Priya");
		c17.setGender("Female");
		c17.setPlanName("Food");
		c17.setPlanStatus("Denied");
		c17.setDenialReason("Property  Income");
		
//		CitizenPlan c18=new CitizenPlan();
//		c18.setCitizenName("Anjali");
//		c18.setGender("Female");
//		c18.setPlanName("Food");
//		c18.setPlanStatus("Terminated");
//		c18.setPlanStartDate(LocalDate.now().minusMonths(1));
//		c18.setPlanEndDate(LocalDate.now().plusMonths(5));
//		c18.setBenefitAmt(30000.00);
//		c18.setTerminationDate(LocalDate.now());
//		c18.setTerminationRsn("Employed");
		
		
		CitizenPlan c19=new CitizenPlan();
		c19.setCitizenName("Divya");
		c19.setGender("Female");
		c19.setPlanName("Medical");
		c19.setPlanStatus("Approved");
		c19.setPlanStartDate(LocalDate.now());
		c19.setPlanEndDate(LocalDate.now().plusMonths(6));
		c19.setBenefitAmt(35000.00);
		
		CitizenPlan c20=new CitizenPlan();
		c20.setCitizenName("Shturi");
		c20.setGender("Female");
		c20.setPlanName("Medical");
		c20.setPlanStatus("Denied");
		c20.setDenialReason("Govt Job");
		
		CitizenPlan c21=new CitizenPlan();
		c21.setCitizenName("Shnehal");
		c21.setGender("Female");
		c21.setPlanName("Medical");
		c21.setPlanStatus("Terminated");
		c21.setPlanStartDate(LocalDate.now().minusMonths(2));
		c21.setPlanEndDate(LocalDate.now().plusMonths(4));
		c21.setBenefitAmt(54000.00);
		c21.setTerminationDate(LocalDate.now());
		c21.setTerminationRsn("Employed");
		
		CitizenPlan c22=new CitizenPlan();
		c22.setCitizenName("Siddhi");
		c22.setGender("Female");
		c22.setPlanName("Employment");
		c22.setPlanStatus("Approved");
		c22.setPlanStartDate(LocalDate.now().minusMonths(3));
		c22.setPlanEndDate(LocalDate.now().plusMonths(3));
		c22.setBenefitAmt(15000.00);
		
		CitizenPlan c23=new CitizenPlan();
		c23.setCitizenName("Prachi");
		c23.setGender("Female");
		c23.setPlanName("Employment");
		c23.setPlanStatus("Denied");
		c23.setDenialReason("Rental Income");
		
		CitizenPlan c24=new CitizenPlan();
		c24.setCitizenName("Gauri");
		c24.setGender("Female");
		c24.setPlanName("Employment");
		c24.setPlanStatus("Terminated");
		c24.setPlanStartDate(LocalDate.now().minusMonths(4));
		c24.setPlanEndDate(LocalDate.now().plusMonths(2));
		c24.setBenefitAmt(25000.00);
		c24.setTerminationDate(LocalDate.now());
		c24.setTerminationRsn("Govt Job");
		
	List<CitizenPlan> list=Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c19,c20,c21,c22,c23,c24);
	repo.saveAll(list);
		
	
		
		
		
		
	}

}

