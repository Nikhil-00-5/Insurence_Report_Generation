package in.MiniProject.controller;

import java.util.List;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.MiniProject.beans.CitizenPlan;
import in.MiniProject.request.SearchCriteria;
import in.MiniProject.services.ReportService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MyController {
	
	@Autowired
	private ReportService service;
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {
    response.setContentType("application/octet-stream");
    response.addHeader("Content-Disposition", "attachment;filename=plans.xls");
    service.exportExcel(response);	
	}
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
    response.setContentType("application/pdf");
    response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");
    service.exportPdf(response);	
	}
	
	@GetMapping("/") 
	public String startIndexPage(Model model) {
		model.addAttribute("search",new SearchCriteria());
		init(model);
		return "index";
	}

	private void init(Model model) {
		
		model.addAttribute("names",service.getPlanNames());
		model.addAttribute("status",service.getPlanStatus());
	}
	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search") SearchCriteria criteria,Model model) {
		System.out.println(criteria);
		List<CitizenPlan> plans=service.search(criteria);
		model.addAttribute("plans",plans); 
		
		init(model);
		return "index";
	}
}
