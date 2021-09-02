package com.progressive.htmlescape.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.progressive.htmlescape.model.TempModel;
import com.progressive.htmlescape.model.TokenConstants;
import com.progressive.htmlescape.model.User;
import com.progressive.htmlescape.model.User2;
import com.progressive.htmlescape.repo.EscapeRepo;
import com.progressive.htmlescape.service.Check;
import io.sentry.Breadcrumb;
import io.sentry.Sentry;
import io.sentry.SentryLevel;
import org.apache.http.client.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class HTML {

    private static final Logger logger = LoggerFactory.getLogger(HTML.class);

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
    SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private TokenConstants tokenConstants;

    @Autowired
    private EscapeRepo escapeRepo;

    @Autowired
    private Check check;

    @PersistenceContext
    private EntityManager entityManager;


    @GetMapping("/get")
    public List<?> getData() {
        check.greet();
        String s = "1";

        List numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9, 10, 12, 16);
        Long count = numbers.stream().filter(x -> (int) x % 2 == 0).count();
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            Sentry.captureException(e);
        }

//        System.out.println(1/0);
//        escapeRepo.allData().orElseThrow(()->new NullPointerException("Null val7e"));
//        Sentry.addBreadcrumb("Bread crumb message","Breadcrumb");


        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setCategory("My breadcrumb");
        breadcrumb.setMessage("Breadcrumb message");
        breadcrumb.setLevel(SentryLevel.INFO);
        Sentry.addBreadcrumb(breadcrumb);

        logger.error("Divide by zero attempted");

        Sentry.init(options -> {
            options.setBeforeSend(((sentryEvent, o) -> {
                System.out.println("Event data------------------>" + sentryEvent.getMessage());
                return sentryEvent;
            }));
        });

        System.out.println(1 / 0);


//        Sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
//                .setMessage("Generatubg the HTML warning symbol").setLevel(Level.WARNING).setType(Breadcrumb.Type.USER).setCategory("custom").build());
//        System.out.println(count);

//        String test = "the world the and";
//        Pattern p = Pattern.compile("the");
//        Matcher m = p.matcher(test);
//        System.out.println(m.matches());
//        System.out.println(m.group());

//        List odd = numbers.stream().filter(x->x%2!=0).collect(Collectors.toList());

        /*Data data1 = new Data(1L,"a",true);
        Data data2 = new Data(1L,"a",false);
        Data data3 = new Data(1L,"a",false);
        Data data4 = new Data(1L,"a",false);
        Data data5 = new Data(1L,"a",true);

        List<Data> dataList = new ArrayList<>();
        dataList.add(data1);
        dataList.add(data2);
        dataList.add(data3);
        dataList.add(data4);
        dataList.add(data5);

        Long count = dataList.stream().filter(data -> !data.getRead()).count();
*/


        /*logger.error("Generating the html warning symbol");

        String warning = "<span>&#9888;</span> Account expired";

        Date now = new Date();
        System.out.println("Now------------------->"+now);
        Date tomorrow = new Date(new Date().getTime() - TimeUnit.HOURS.toMillis(24L));
        System.out.println("Now=24 hrs------------------->"+tomorrow);
        List<Data> dataList = new ArrayList<>();
        dataList = escapeRepo.allData();
        System.out.println(dataList.size());
        if(dataList != null && dataList.size()>1){
            System.out.println("1st if statement"+ dataList.size());
        }
        if(dataList == null){
            System.out.println("Second if statement");
        }*/
/*        System.out.println("size------------------------>"+dataList.size());
        Sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("Generatubg the HTML warning symbol").setLevel(Level.WARNING).setType(Breadcrumb.Type.USER).setCategory("custom").build());

        breadcrumb.setLevel();
        Sentry.addBreadcrumb();


        Sentry.captureEvent()*/
      /*  String danger = "<span>&#128308;</span> Danger sign";
        String accepted = "<span>&#128994</span> Normal sign";
        String escaped = HtmlUtils.htmlEscape(warning);
        String toReplace;
        String replaceWith = "Class_Clicked";
        String span = "<img src=\"32.png\" style=\"vertical-align:middle;\"><span class='class_name'> content</span>";
        System.out.println("Before---------->" + span);
        String[] split = span.split("'");
        toReplace = split[1];
        String changed = span.replace(toReplace, replaceWith);
        for (String s : split) {
            System.out.println(s);
        }*/
//        System.out.println("After---------->" + changed);


/*        Map<String, Object> map1 = new HashMap<>();
        map1.put("message",escaped);
        map1.put("redirect_link","google.com");
        map1.put("created_at","2020-10-13");
        System.out.println("First------->"+map1.get("message"));
        map1.replace("message",HtmlUtils.htmlUnescape(map1.get("message").toString()));
        System.out.println("Second------->"+map1.get("message"));*/
//        Data data2 = new Data();
//        data2.setCode(danger);
//        data2 = escapeRepo.save(data2);
//
//        Data data = new Data();
//        data.setCode(escaped);
//        data = escapeRepo.save(data);


//        System.out.println(escaped);
//        return warning;
//        return HtmlUtils.htmlUnescape(data.getCode());
//        scheduler.scheduledMethod();
        return Arrays.asList(1, 2, 3);
    }

    @GetMapping("/list_of_map")
    public ResponseEntity<?> customData() {
        List<Map<String, Object>> data = escapeRepo.getAllData();
        System.out.println("size---------------->" + data.size());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/update")
    public String update() {
        escapeRepo.update();
        return "check db";
    }

    @PostConstruct
    @GetMapping("/date")
    public Date date() throws ParseException {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = "2021-01-27 12:00:00 AM";
        Date dateIn = inputDateFormat.parse(date1);
        Date current  = new Date(System.currentTimeMillis() - 120*1000);
//        System.out.println(outputDateFormat.format(dateIn));
        System.out.println("without formatting "+ new Date());
        System.out.println(outputDateFormat.format(current));
        return outputDateFormat.parse(date1);
    }

    @GetMapping("/report")
    public ResponseEntity<?> report() {
        return new ResponseEntity<>(escapeRepo.report(1), HttpStatus.OK);
    }

    @GetMapping("/optionalCheck")
    public ResponseEntity<?> optionalCheck() {
        TempModel tempModelNull = null;
        TempModel tempModel = new TempModel("Ram", 1);
        return new ResponseEntity<>(tempModel.test(tempModelNull), HttpStatus.OK);
    }

    @GetMapping("/saveUser")
    public String save() {
        User user = new User();

        user.setCode("F");
        user.setTemp("lll");
        check.save(user);
        return "saved";
    }

    @GetMapping("/saveUser2")
    public String save2() throws Exception {
        User2 user2 = new User2();
        user2.setName("temp");
        User user = new User();
        user.setCode("F");
        user.setTemp("lll");
        check.save2(user2);
        return "Saved";
    }

    @GetMapping("/path")
    public Path path() {
//        https://res.cloudinary.com/dr5bn1n0t/video/upload/v1606214540/test/498_LEGACY_-_Spring_Security_4_-_Create_Security_Config_muybfe.mp4
        String videoLocation = "/home/progressive/Documents/workbench-spring/Webflux-Streaming-Service-master/videos";
        Path path1 = Paths.get("https://res.cloudinary.com/dr5bn1n0t/video/upload/v1606214540/test/", "498_LEGACY_-_Spring_Security_4_-_Create_Security_Config_muybfe.mp4");
        Path path = Paths.get(videoLocation);

        Path path3 = Paths.get(URI.create("https://res.cloudinary.com/dr5bn1n0t/video/upload/v1606214540/test/498_LEGACY_-_Spring_Security_4_-_Create_Security_Config_muybfe.mp4"));
        System.out.println("Relative file service---->" + path3.toFile().length());
        File file = path.toFile();
        System.out.println("Length-->" + file.length());

        return path;

    }

    @GetMapping("/cloudinary")
    public ResponseEntity<?> cloudinary() {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dr5bn1n0t",
                "api_key", "192276572324486",
                "api_secret", "Z2RQqbmdyUAX6sjfgJC2zCRZLWI"
        ));

        System.out.println(cloudinary.url());
        Map<String, String> attributes = new HashMap<>();
        attributes.put("video", "");
        System.out.println(cloudinary.url().videoTag("test/498_LEGACY_-_Spring_Security_4_-_Create_Security_Config_muybfe", attributes));
        String html = cloudinary.url().videoTag("test/498_LEGACY_-_Spring_Security_4_-_Create_Security_Config_muybfe", new HashMap<>());
       /* String[] htm = html.split(">");
        for(String s:htm){
            System.out.println("1111  "+s);
        }*/
//        return new ResponseEntity<>(cloudinary.url().videoTag("test/498_LEGACY_-_Spring_Security_4_-_Create_Security_Config_muybfe", new HashMap<>()), HttpStatus.OK);
        return new ResponseEntity<>("<h1>kappa123</h1>", HttpStatus.OK);

    }

    @GetMapping("/webClient")
    public ResponseEntity<?> webClnt() {
        List<Map<String, Object>> data = null;
        int id = 0;

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/string")
    public ResponseEntity<?> stringTest(){
        String s1  = "2021-03-26 10:00:00 PM";
        Date testDate = new Date();
        try {
            testDate = format.parse(s1);
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        System.out.println("Test date "+DateUtils.formatDate(testDate,"yyyy-MM-dd"));
        System.out.println("Today's date "+DateUtils.formatDate(new Date(),"yyyy-MM-dd"));
        if(DateUtils.formatDate(testDate,"yyyy-MM-dd").equals(DateUtils.formatDate(new Date(),"yyyy-MM-dd"))){
            System.out.println("Dates equal.................");
        }else {
            System.out.println("Test Date................ = "+testDate);
        }


        return new ResponseEntity<>(s1.isEmpty(), HttpStatus.OK);
    }

    @PostConstruct
    @GetMapping("/print")
    public void print(){
        System.out.println("90909090");
        System.out.println(tokenConstants.getSigningKey());
        System.out.println(tokenConstants.getValiditySeconds());
    }

}
