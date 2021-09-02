package com.progressive.htmlescape.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.OptionalInt;

@RestController
public class MyRestCall {

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @GetMapping("/rest_call_test")
    public ResponseEntity<?> restCall(HttpServletRequest request) {
        System.out.println("Incoming request");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MDg1NzA5ODEsInVzZXJfbmFtZSI6ImthcmtpLm5pa3NAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiU1RVREVOVCJdLCJqdGkiOiI0MGUzMjlkYi1iMjllLTQ4ZmItOTlmNS1hMzY0ZTU2NzVmNTMiLCJjbGllbnRfaWQiOiJtZWRpY2FsLXRlc3QiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXX0.Exor61_lTWxR5vJN5P38qXuF0LxhQ890WpE8SHcvMws");
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange("http://192.168.0.113:8081/user/push_notification?url=" + "custom_url", HttpMethod.POST, entity, String.class);
        return new ResponseEntity<>("custom data", HttpStatus.OK);

    }

    @GetMapping("/threadTest")
    public ResponseEntity<?> threadTest() {
        Thread t1 = new Thread(new MyRunnable("Task1"));
        Thread t2 = new Thread(new MyRunnable("Task2"));
        Thread t3 = new Thread(new MyRunnable("Task3"));
        Thread t4 = new Thread(new MyRunnable("Task4"));
        Thread t5 = new Thread(new MyRunnable("Task5"));
        t1.start();
        t1.setName("Thread1");
        t2.start();
        t2.setName("Thread2");
        t3.start();
        t3.setName("Thread3");
        t4.start();
        t4.setName("Thread4");
        t5.start();
        t5.setName("Thread5");
        return new ResponseEntity<>("lsd", HttpStatus.OK);
    }

    @GetMapping("/longest_substring/{input}")
    public ResponseEntity<?> longestSubstring(@PathVariable String input) {
        char[] chars = input.toCharArray();
        int[] counts = new int[chars.length];
        int count = 0;
        int i = 0;
        char prev = '1';
        String previous="";
        char current;
        for (char c : chars) {
            current = c;
            System.out.println("current="+current+"\n"+"prev="+prev);
            if(current != prev){
                System.out.println("Count increased");
                count++;
            }else {
                System.out.println("Count reset");
                counts[i] = count;
                count = 1;
                i++;
            }
            counts[i] = count;
            previous = previous.concat(String.valueOf(current));
        }
        int max = Arrays.stream(counts).max().getAsInt();
        return new ResponseEntity<>(counts, HttpStatus.OK);
    }

    @GetMapping("/file")
    public ResponseEntity<?> file(@RequestParam MultipartFile file) throws Exception {
        Context context = new Context();
        Path path = Paths.get("/home/progressive/Desktop/html/bulkTemplate.html");
        String data = new String(Files.readAllBytes(path));
        String data2 = new String(file.getBytes(), StandardCharsets.UTF_8);
        return new ResponseEntity<>(data2, HttpStatus.OK);
    }

    @GetMapping("/fill_missing_values")
    public ResponseEntity<?> fillMissingValues() {
        double[] u1 = {80, 0, 0, 0, 0, 80};
        double[] u2 = {50, 50, 50, 50, 50, 50};
        double[] avg = {65, 25, 25, 25, 25, 65};
        double[] sd = {21.21, 25, 25, 25, 25, 21.21};
        int i = 0;
        for(double a : u1){
            if( a == 0){
                u1[i] = avg[i]*0.9;
            }
            i++;
        }
        Arrays.stream(u1).forEach(System.out::println);
        return new ResponseEntity<>(u1, HttpStatus.OK);
    }

    @PostConstruct
    public void print(){
        System.out.println(new Date());
    }
}
