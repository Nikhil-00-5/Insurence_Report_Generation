package in.MiniProject.request;
import java.time.LocalDate;
import lombok.Data;


@Data
public class SearchCriteria {
	private String planName;
	private String planStatus;
	private String gender;
	private LocalDate startDate;
	private LocalDate endDate;
	
	

}
