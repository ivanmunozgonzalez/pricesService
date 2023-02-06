package demo.imunoz.application.service.productPrice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class GetProductPriceInDateAndPriorityE2ETest {

    private static final String URI_E2E_TEST = "http://localhost:8080/api/productPrice";

    private static final Long PRODUCT_ID_ALLTEST = 35455l;
    private static final Long BRAND_ID_ALLTEST = 1l;
    private static final String APPLICATION_DATE_TEST1 = "2020-06-14T10:00:00";
    private static final String APPLICATION_DATE_TEST2 = "2020-06-14T16:00:00";
    private static final String APPLICATION_DATE_TEST3 = "2020-06-14T21:00:00";
    private static final String APPLICATION_DATE_TEST4 = "2020-06-15T10:00:00";
    private static final String APPLICATION_DATE_TEST5 = "2020-06-16T21:00:00";

    @BeforeEach
    public void setup() {
	RestAssured.responseSpecification = new ResponseSpecBuilder().build();
    }

    @Test
    @Description("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    public void getProductPriceFilterApplicationDateProductAndBrand_Test1() {
	given().baseUri(URI_E2E_TEST).filter(new RequestLoggingFilter()).filter(new ResponseLoggingFilter())
		.queryParam("dateApplication", APPLICATION_DATE_TEST1)
		.get("/" + PRODUCT_ID_ALLTEST + "/" + BRAND_ID_ALLTEST).then().statusCode(200).and().assertThat()
		.body("productId", equalTo(35455), "startDate", equalTo("2020-06-14T00:00:00"), "endDate",
			equalTo("2020-12-31T23:59:59"), "priceList", equalTo(1), "price", equalTo(35.5F), "curr",
			equalTo("EUR"), "brandId", equalTo(1));
    }

    @Test
    @Description("Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    public void getProductPriceFilterApplicationDateProductAndBrand_Test2() {
	given().baseUri(URI_E2E_TEST).filter(new RequestLoggingFilter()).filter(new ResponseLoggingFilter())
		.queryParam("dateApplication", APPLICATION_DATE_TEST2)
		.get("/" + PRODUCT_ID_ALLTEST + "/" + BRAND_ID_ALLTEST).then().statusCode(200).and().assertThat()
		.body("productId", equalTo(35455), "startDate", equalTo("2020-06-14T15:00:00"), "endDate",
			equalTo("2020-06-14T18:30:00"), "priceList", equalTo(2), "price", equalTo(25.45F), "curr",
			equalTo("EUR"), "brandId", equalTo(1));
    }

    @Test
    @Description("Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    public void getProductPriceFilterApplicationDateProductAndBrand_Test3() {
	given().baseUri(URI_E2E_TEST).filter(new RequestLoggingFilter()).filter(new ResponseLoggingFilter())
		.queryParam("dateApplication", APPLICATION_DATE_TEST3)
		.get("/" + PRODUCT_ID_ALLTEST + "/" + BRAND_ID_ALLTEST).then().statusCode(200).and().assertThat()
		.body("productId", equalTo(35455), "startDate", equalTo("2020-06-14T00:00:00"), "endDate",
			equalTo("2020-12-31T23:59:59"), "priceList", equalTo(1), "price", equalTo(35.5F), "curr",
			equalTo("EUR"), "brandId", equalTo(1));
    }

    @Test
    @Description("Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
    public void getProductPriceFilterApplicationDateProductAndBrand_Test4() {
	given().baseUri(URI_E2E_TEST).filter(new RequestLoggingFilter()).filter(new ResponseLoggingFilter())
		.queryParam("dateApplication", APPLICATION_DATE_TEST4)
		.get("/" + PRODUCT_ID_ALLTEST + "/" + BRAND_ID_ALLTEST).then().statusCode(200).and().assertThat()
		.body("productId", equalTo(35455), "startDate", equalTo("2020-06-15T00:00:00"), "endDate",
			equalTo("2020-06-15T11:00:00"), "priceList", equalTo(3), "price", equalTo(30.5F), "curr",
			equalTo("EUR"), "brandId", equalTo(1));
    }

    @Test
    @Description("Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
    public void getProductPriceFilterApplicationDateProductAndBrand_Test5() {
	given().baseUri(URI_E2E_TEST).filter(new RequestLoggingFilter()).filter(new ResponseLoggingFilter())
		.queryParam("dateApplication", APPLICATION_DATE_TEST5)
		.get("/" + PRODUCT_ID_ALLTEST + "/" + BRAND_ID_ALLTEST).then().statusCode(200).and().assertThat()
		.body("productId", equalTo(35455), "startDate", equalTo("2020-06-15T16:00:00"), "endDate",
			equalTo("2020-12-31T23:59:59"), "priceList", equalTo(4), "price", equalTo(38.95F), "curr",
			equalTo("EUR"), "brandId", equalTo(1));
    }

}
