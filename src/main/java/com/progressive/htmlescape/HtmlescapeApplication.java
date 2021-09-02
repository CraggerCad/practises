package com.progressive.htmlescape;

import com.progressive.htmlescape.model.Test;
import com.progressive.htmlescape.model.TokenConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
@EnableScheduling
public class HtmlescapeApplication {


    public static void main(String[] args) {

       /* Sentry.init(options -> {
            options.setDsn("https://d7b26e798a924c409328b5106ea23486@o460846.ingest.sentry.io/5461749");
        });*/
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+5:30"));
        SpringApplication.run(HtmlescapeApplication.class, args);


    }

    @Bean
    public Test testAndTime() {
        return new Test();
    }


}
