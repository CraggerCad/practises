package com.progressive.htmlescape.service;

import com.progressive.htmlescape.model.User;
import com.progressive.htmlescape.model.User2;
import com.progressive.htmlescape.repo.EscapeRepo;
import com.progressive.htmlescape.repo.User2Repo;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;


@Service
public class CheckImpl implements Check {
    private static final Logger logger = LoggerFactory.getLogger(Check.class);

    @Autowired
    private EscapeRepo escapeRepo;

    @Autowired
    private User2Repo user2Repo;

    @Autowired
    DataSource dataSource;


    @PersistenceContext
    private EntityManager entityManager;

    /*EntityManagerFactory factory = null;
    SessionFactory sessionFactory = factory.unwrap(SessionFactory.class);
    Session session = sessionFactory.openSession();*/

    @Override
    public String greet() {
        logger.info("Checking log information");
        return null;
    }

    @Override
    public String save(User user) {
        escapeRepo.save(user);
        return "saved";
    }


    @Override
    public String save2(User2 user2) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();

        user2Repo.save(user2);
        if (user2.getName().equals("temp")) {
            System.out.println("Roll back");

        }
        return "saved";
    }

    @Override
    public JasperPrint asd() {
        try {
            Connection connection = dataSource.getConnection();
            File file = new File("classpath:asd.xml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            Map<String, Object> sd = new HashMap<>();
            sd.put("kapp", "123");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, sd, connection);
            return jasperPrint;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
