package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("stores")
                .then().statusCode(200);

    }

    @Test
    public void test01() {

        //1. Extract the limit
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test002() {
        //2. Extract the total
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total is : " + total);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test003() {
        //3. Extract the name of 5th store
        String storeName = response.extract().path("data[5].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th store is : " + storeName);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test004() {
        //4. Extract the names of all the store
        List<String> storeNames = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the name of all the stores are : " + storeNames);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test005() {
        //5. Extract the storeId of all the store
        List<Integer> storeIds = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the storesids are : " + storeIds);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test006() {
        //6. Print the size of the data list
        List<Integer> sizeOfList = response.extract().path("data.length");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data list is : " + sizeOfList.size());
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test007() {
        //7. Get all the value of the store where store name = St Cloud
        List<HashMap<?, ?>> values = response.extract().path("data.findAll{it.name == 'St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the store where store name = St Cloud are: " + values);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test008() {
        //8. Get the address of the store where store name = Rochester
        List<HashMap<?, ?>> address = response.extract().path("data.findAll{it.name == 'Rochester'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address of the store where store name = Rochester is : " + address);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test009() {
        //9. Get all the services of 8th store
        List<HashMap<?, ?>> allServices = response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("all the services of 8th store are: " + allServices);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test010() {
        //10. Get storeservices of the store where service name = Windows Store
        List<HashMap<String, ?>> servicesList = response.extract().path("data[0].services.findAll{it.name == 'Windows Store'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeservices of the store where service name = Windows Store are : " + servicesList);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test011() {
        //11. Get all the storeId of all the store
        List<Integer> allStoreId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of all the stores are : " + allStoreId);
        System.out.println("------------------End of Test---------------------------");


    }

    @Test
    public void test012() {
        //12. Get id of all the store
        List<Integer> storeIds = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the id of all the store are : " + storeIds);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test013() {
        //13. Find the store names Where state = ND
        List<HashMap<?, ?>> storeName = response.extract().path("data.findAll{it.state == 'ND'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the store names Where state = ND are : " + storeName);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test014() {
        //14. Find the Total number of services for the store where store name = Rochester
        List<HashMap<?, ?>> srv = response.extract().path("data.findAll{it.name == 'Rochester'}.services[0]");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the Total number of services for the store where store name = Rochester are : " + srv.size());
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test015() {
        //15. Find the createdAt for all services whose name = “Windows Store”

        List<HashMap<String, ?>> createdAt = response.extract().path("data[0].services.findAll{it.name == 'Windows Store'}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the createdAt for all services whose name = “Windows Store” are : " + createdAt);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test016() {
        //16. Find the name of all services Where store name = “Fargo”
        List<?> servicesList = response.extract().path("data.findAll{it.name == 'Fargo'}.services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the name of all services Where store name = “Fargo” are : " + servicesList);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test017() {
        //17. Find the zip of all the store
        List<Integer> allZip = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the zip of all the store are : " + allZip);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test018() {
        //18. Find the zip of store name = Roseville
        List<Integer> zip = response.extract().path("data.findAll{it.name == 'Roseville'}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the zip of store name = Roseville is : " + zip);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test019() {
        //19. Find the storeservices details of the service name = Magnolia Home Theater
        List<HashMap<?, ?>> details = response.extract().path("data[0].services.findAll{it.name == 'Magnolia Home Theater'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the storeservices details of the service name = Magnolia Home Theater are : " + details);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test020() {
        //20. Find the lat of all the stores
        List<Integer> allLat = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the lat of all the stores are : " + allLat);
        System.out.println("------------------End of Test---------------------------");

    }
}

