package com.mann.repository;

import com.mann.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vladimir Mann
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
