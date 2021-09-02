package com.progressive.htmlescape.repo;

import com.progressive.htmlescape.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
