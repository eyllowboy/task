package com.example.tasl004.repositories;

import com.example.tasl004.entities.House;
import com.example.tasl004.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HouseRepositoryCustomImpl implements HouseRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<House> getAllHousesAreaAmountOfRooms(String name, int area, int amountOfRooms, int page, int size, String sorted, User user) {


        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery cq = qb.createQuery();
        Root<House> root = cq.from(House.class);


        List<Predicate> predicates = new ArrayList<Predicate>();


        if (area != 0) {
            predicates.add(qb.equal(root.get("area"), area));
        }
        if (amountOfRooms != 0) {
            predicates.add(qb.equal(root.get("amountOfRooms"), amountOfRooms));
        }
        if (user != null) {
            predicates.add(qb.equal(root.get("user"), user));
        }
        if (name != null) {
            predicates.add(qb.equal(root.get("name"), name));
        }
         predicates.add(qb.equal(root.get("deleted"), false));



        cq.select(root)
                .where(predicates.toArray(new Predicate[]{}));
        cq.orderBy(qb.asc(root.get(sorted)));
        System.out.println(em.createQuery(cq).setFirstResult(page*5).setMaxResults(size).getResultList());
        return em.createQuery(cq).setFirstResult(page*5).setMaxResults(size).getResultList();
    }


}
