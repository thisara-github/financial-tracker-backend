package com.financial.tracker.repository;

import com.financial.tracker.entity.GoalTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalTrackingRepository extends JpaRepository<GoalTracking, Long> {
}
