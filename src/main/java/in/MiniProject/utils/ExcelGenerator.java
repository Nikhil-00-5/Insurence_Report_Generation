package in.MiniProject.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import in.MiniProject.beans.CitizenPlan;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class ExcelGenerator {
public void generate(HttpServletResponse response,List<CitizenPlan> plans,File file) throws Exception {
	
	
    Workbook workbook=new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("plan-data");
    Row headerRow=sheet.createRow(0);
    
    headerRow.createCell(0).setCellValue("ID");
    headerRow.createCell(1).setCellValue("Citizen Name");
    headerRow.createCell(2).setCellValue("Plan Name");
    headerRow.createCell(3).setCellValue("Plan Status");
    headerRow.createCell(4).setCellValue("Plan Start Date");
    headerRow.createCell(5).setCellValue("Plan End Date");
    headerRow.createCell(6).setCellValue("Benefit Amt");
    

    int dataRowindex=1;
    for(CitizenPlan plan : plans) {
        Row dataRow=sheet.createRow(dataRowindex);
        dataRow.createCell(0).setCellValue(plan.getCitizenId());
        dataRow.createCell(1).setCellValue(plan.getCitizenName());
        dataRow.createCell(2).setCellValue(plan.getPlanName());
        dataRow.createCell(3).setCellValue(plan.getPlanStatus());
        if(null!= plan.getPlanStartDate()) {
        dataRow.createCell(4).setCellValue(plan.getPlanStartDate()+"");
        }else {dataRow.createCell(4).setCellValue("N/A");
        }
        if(null!=plan.getPlanEndDate()) {
        dataRow.createCell(5).setCellValue(plan.getPlanEndDate()+"");
        }else {dataRow.createCell(5).setCellValue("N/A");
        }
        if(null!=plan.getBenefitAmt()) {
        dataRow.createCell(6).setCellValue(plan.getBenefitAmt());
        }else { dataRow.createCell(6).setCellValue("N/A");
        }
        dataRowindex++;
    }  
    
    FileOutputStream fos =new FileOutputStream(file);
    workbook.write(fos);	
    fos.close();
    
    ServletOutputStream outputstream =response.getOutputStream();
    workbook.write(outputstream);	
    workbook.close();
		
	}

}
