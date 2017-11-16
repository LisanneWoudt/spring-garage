package nl.appli.garage.services;

import nl.appli.garage.model.Car;
import org.springframework.stereotype.Repository;
import rx.Observable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class CarService {

    @PersistenceContext
    private EntityManager em;

    public Car addCar(Car car) {
        em.persist(car);
        return car;
    }

    public List<Car> getAllCars() {
        return em.createQuery("from " + Car.class.getSimpleName()).getResultList();
    }

    public Car getCar(int id) {

        Car c = em.find(Car.class, id);
        return c;
    }

    public void deleteCar(Integer id) {
        Car car = getCar(id);
        em.remove(car);
    }

    public List<Car> getFilteredCars(String param) {
        List<Car> carList = em.createQuery("from " + Car.class.getSimpleName()).getResultList();
        return Observable.from(carList)
                .filter(car -> car.getBrand().toLowerCase().equals(param.toLowerCase()))
                .toList()
                .toBlocking()
                .single();
    }

    public Car updateStatus(int id, String status) {
        Car car2 = em.find(Car.class, id);
        car2.setStatus(status);
        em.merge(car2);
        return car2;
    }

}

