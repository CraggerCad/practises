//package com.progressive.htmlescape;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@RestControllerAdvice
//public class MyExceptionHandler {
//
//    @ExceptionHandler(ArithmeticException.class)
//    public final ResponseEntity<?> arithmeticException(ArithmeticException arithmeticException){
//        System.out.println("Exception handler------------------->"+arithmeticException.getLocalizedMessage());
//        return new ResponseEntity<>(arithmeticException.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<?> nullException(NullPointerException nullPointerException){
//        System.out.println("Exception handler null exception------------------->"+nullPointerException.getLocalizedMessage());
//        return new ResponseEntity<>(nullPointerException.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
//    }
//}
//    /*@org.springframework.web.bind.annotation.ExceptionHandler(RecordNotFoundException.class)
//    public final ResponseEntity<ErrorResponse> handleNotFound(RecordNotFoundException ex, WebRequest request) {
//        List<String> details = new ArrayList<>();
//        details.add(ex.getLocalizedMessage());
//        ErrorResponse error = new ErrorResponse("INCORRECT_REQUEST", details);
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }*/
