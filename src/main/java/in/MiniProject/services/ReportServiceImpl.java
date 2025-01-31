package in.MiniProject.services;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.MiniProject.beans.CitizenPlan;
import in.MiniProject.repository.CitizenPlanRepo;
import in.MiniProject.request.SearchCriteria;
import in.MiniProject.utils.EmailUtil;
import in.MiniProject.utils.ExcelGenerator;
import in.MiniProject.utils.PdfGenerator;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private CitizenPlanRepo planRepo;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private EmailUtil emailUtil;
  
	@Override
	public List<String> getPlanNames() {
		List<String> planNames=planRepo.getPlanNames();
		return planNames;
	}

	@Override
	public List<String> getPlanStatus() {
		List<String> planStatus=planRepo.getPlanStatus();
		return planStatus;
	}

	@Override
	public List<CitizenPlan> search(SearchCriteria criteria) {
		CitizenPlan entity=new CitizenPlan();
		
		if(null!=criteria.getPlanName() && !"".equals(criteria.getPlanName())) {
			entity.setPlanName(criteria.getPlanName());
			}
		if(null!=criteria.getPlanStatus() && !"".equals(criteria.getPlanStatus())) {
			entity.setPlanStatus(criteria.getPlanStatus());
			}
		if(null!=criteria.getGender() && !"".equals(criteria.getGender())) {
			entity.setGender(criteria.getGender());
			}
		
		if (criteria.getStartDate() != null) {
		    LocalDate startDate = criteria.getStartDate();
		    entity.setPlanStartDate(startDate);  // Set the LocalDate directly
		}
		
		if (criteria.getEndDate() != null) {
		    LocalDate endDate = criteria.getEndDate();
		    entity.setPlanEndDate(endDate);  // Set the LocalDate directly
		}
		
        return planRepo.findAll(Example.of(entity));
	
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		
		 File file=new File("plans.xls");
		 
	    List<CitizenPlan> records =planRepo.findAll();
	    excelGenerator.generate(response, records, file);
	    
	    String subject = "Test Mail Subject";
	    String body = "<h1>Test Mail Body</h1>";
	    String to = "nikhilkanthali005@gmail.com";
	   
	    emailUtil.sendEmail(subject, body, to, file);
	    file.delete();

		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		
		File file =new File("plans.pdf");
		
		List<CitizenPlan> plans= planRepo.findAll();
		pdfGenerator.generate(response, plans,file);
		
		String subject = "Test Mail Subject";
	    String body = "<h1>Test Mail Body</h1>";
	    String to = "nikhilkanthali005@gmail.com";
	   
	    emailUtil.sendEmail(subject, body, to, file);
	    file.delete();
		
		return true;
	}
}
