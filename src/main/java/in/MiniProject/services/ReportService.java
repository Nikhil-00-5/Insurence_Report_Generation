package in.MiniProject.services;

import java.util.List;



import in.MiniProject.beans.CitizenPlan;
import in.MiniProject.request.SearchCriteria;
import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {
	public List<String> getPlanNames();
	public List<String> getPlanStatus();
	public List<CitizenPlan> search(SearchCriteria criteria);
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	public boolean exportPdf(HttpServletResponse response) throws Exception;
}
