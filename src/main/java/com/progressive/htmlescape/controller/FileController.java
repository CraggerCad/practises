package com.progressive.htmlescape.controller;

import com.progressive.htmlescape.model.Employee;
import com.progressive.htmlescape.repo.EmployeeRepo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@RestController
@CrossOrigin(origins = "*")
public class FileController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/downloadFile")
    public ResponseEntity<?> downloadFile(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);
        List<Employee> employees = employeeRepo.findAll();

        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }

        ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Employee id", "Name", "Description", "firstName", "lastName"};
        String[] nameMapping = {"id", "name", "description", "first_name", "last_name"};

        csvBeanWriter.writeHeader(csvHeader);
        for (Employee employee : employees) {
            csvBeanWriter.write(employee, nameMapping);
        }
        csvBeanWriter.close();

        return null;
    }


    @GetMapping("/download")
    public ResponseEntity download(HttpServletResponse response) throws Exception {
        File file = new File("/home/progressive/Downloads/Book2.xlsx");

        response.setContentType("text/xlsx");
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", "attachment; filename=users.xlsx");
        headers.add("Content-Type", "application/vnd.ms-excel");
        ByteArrayInputStream in = new ByteArrayInputStream(FileUtils.readFileToByteArray(file));
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
    }

    @GetMapping("/dbBkp")
    public ResponseEntity dbBkp() throws IOException, InterruptedException {
        String command = "pg_dump --file /home/progressive/pgBkp/commands/asdf123.sql --host localhost --port 5432 --username postgres --no-password --verbose --format=p --section=data --column-inserts --schema accounting accounting";

        Process process = Runtime.getRuntime().exec(command);
        int complete = process.waitFor();
        InputStream inputStream = process.getErrorStream();

        File file;
        if (complete == 0) {
            file = new File("/home/progressive/pgBkp/commands/asdf123.sql");
        } else {
            return null;
        }

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(FileUtils.readFileToByteArray(file));
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        System.out.println("-------------");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=asdf123.sql");
        headers.add("Content-Type", "application/octet-stream");
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(byteArrayInputStream));
    }
}
