package com.mann.repository;

import com.mann.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vladimir Mann
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
