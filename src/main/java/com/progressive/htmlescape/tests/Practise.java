package com.progressive.htmlescape.tests;

import com.progressive.htmlescape.model.Employee;
import com.progressive.htmlescape.model.TokenConstants;

public class Practise {
    public static void main(String[] args) {
        Employee employee = new Employee("Ram");

        System.out.println(employee.getCreatedAt());
        System.out.println(employee.getCreatedBy());
    }
}
