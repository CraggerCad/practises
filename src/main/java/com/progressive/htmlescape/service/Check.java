package com.progressive.htmlescape.service;

import com.progressive.htmlescape.model.User;
import com.progressive.htmlescape.model.User2;
import net.sf.jasperreports.engine.JasperPrint;


public interface Check {
    String greet();

    String save(User user);

    String save2(User2 user2);

    JasperPrint asd();
}
