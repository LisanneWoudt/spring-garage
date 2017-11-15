import nl.appli.garage.model.Car;
import nl.appli.garage.services.CarService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring-context.xml" })
public class CarTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;


    @Autowired
    private CarService carService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
      //  carService.addCar(new Car("Citroen", "NL-123-A", "done"));
      //  carService.addCar(new Car("Audi", "123-BBB", "Processing"));
    }

    @Test
    public void testGetCar() throws Exception {
        mockMvc.perform(get("/car/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("{'id':1,'brand':'Citroen','numberPlate':'NL-123-A','status':'done'}"));

    }

/*    @Test
    public void testGetStatus(){
        this.car = new Car();
        float actual = car.add(1, 2);
        assertEquals(3, actual);
    };*/


//    @Test
//    public void testCarServiceGetCar(){
//        int carId = 5;
//        String carBrand = "Peugeot";
//        String numberPlate = "123-AB-2";
//        this.carService = new CarService();
//        Car c = carService.getCar(5);
//        assertEquals(carId, c.getId());
//        assertEquals(carBrand, c.getBrand());
//        assertEquals(numberPlate, c.getNumberPlate());
//    };


}
