package com.progressive.htmlescape.repo;

import com.progressive.htmlescape.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface EscapeRepo extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "select id,code from user")
    List<Map<String, Object>> getAllData();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update user set temp='rolledBack' where id in (2,3)")
    void update();

    @Query(nativeQuery = true, value = "call kpi_report(:year_in)")
    List<Map<String, Object>> report(@Param("year_in") Integer year_in);


}
