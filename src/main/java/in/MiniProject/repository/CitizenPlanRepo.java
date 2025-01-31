package in.MiniProject.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.MiniProject.beans.CitizenPlan;

public interface CitizenPlanRepo extends JpaRepository<CitizenPlan, Integer>{
	
	@Query(value = "select distinct (planName) from CitizenPlan")
	public List<String> getPlanNames();
	
	@Query("select distinct (planStatus) from CitizenPlan")
	public List<String> getPlanStatus();
	
    @Query("SELECT c FROM CitizenPlan c WHERE " +
            "(:planName IS NULL OR c.planName = :planName) AND " +
            "(:planStatus IS NULL OR c.planStatus = :planStatus) AND " +
            "(:gender IS NULL OR c.gender = :gender) AND " +
            "(:planStartDate IS NULL OR c.planStartDate >= :startDate) AND " +
            "(:planEndDate IS NULL OR c.planEndDate <= :endDate)")
     List<CitizenPlan> search(@Param("planName") String planName,
                               @Param("planStatus") String planStatus,
                               @Param("gender") String gender,
                               @Param("startDate") LocalDate startDate,
                               @Param("endDate") LocalDate endDate);

}
