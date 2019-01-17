package org.evan.study;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Xuejiao {
    public static void main(String []args){
        new Xuejiao().getHttp();
//        System.out.println("haha");
    }


    public void getHttp(){
        Response response = given().get("http://app.58.com/api/community/local/cbd?cbd=1057400606");
        response.print();
    }
}
