package nl.appli.garage.controllers;

import nl.appli.garage.model.Owner;
import nl.appli.garage.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
