package nl.appli.garage.controllers;

import nl.appli.garage.model.Car;
import nl.appli.garage.model.Owner;
import nl.appli.garage.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @ResponseBody
    @RequestMapping(value = "/owners", method = RequestMethod.GET)
    public List<Owner> getAllOwners() {
        List<Owner> owners = ownerService.getAllOwners();
        return owners;
    }

    @ResponseBody
    @RequestMapping(value = "/new_owner", method = RequestMethod.POST)
    public Owner addOwner(@RequestBody Owner owner) {
        return ownerService.addOwner(owner);
    }

    @ResponseBody
    @RequestMapping(value = "/car_owner/{id}", method = RequestMethod.PUT)
    public Car updateCarOwner(@PathVariable Integer id,  @RequestBody Owner owner) {
        return ownerService.updateCarOwner(id, owner);
    }
}
