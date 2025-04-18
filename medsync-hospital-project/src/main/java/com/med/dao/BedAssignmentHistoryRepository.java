package com.med.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.med.model.Bed;
import com.med.model.BedAssignmentHistory;

public interface BedAssignmentHistoryRepository extends JpaRepository<BedAssignmentHistory, Long>{
	
	public Optional<BedAssignmentHistory> findByBedAndVacatedAtIsNull(Bed bed);

}
