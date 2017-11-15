package nl.appli.garage.services;
import nl.appli.garage.model.Owner;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class OwnerService {

    @PersistenceContext
    private EntityManager em;

    public Owner addOwner(Owner owner) {
        em.persist(owner);
        return owner;
    }

    public List<Owner> getAllOwners() {
        return em.createQuery("from " + Owner.class.getSimpleName()).getResultList();
    }


}
