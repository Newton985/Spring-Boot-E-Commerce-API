package com.newtonic.SpringShop.models.Cart;

import com.newtonic.SpringShop.models.user.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: write you class description here
 *
 * @author Newton
 */

public class CustomCartRepositoryImpl implements CustomCartRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cart> findByUserAndStatus(User user, int status) {

        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Cart> query = criteriaBuilder.createQuery(Cart.class);
        Root<Cart> cartRoot = query.from(Cart.class);

        List<Predicate> predicates = new ArrayList<>();

        Predicate predicate = criteriaBuilder.equal(cartRoot.get("user"), user);
        Predicate predicate1 = criteriaBuilder.equal(cartRoot.get("status"), status);

        predicates.add(predicate);
        if (status > -1){
            predicates.add(predicate1);
        }

        query.select(cartRoot).where(criteriaBuilder.and(predicates.toArray(Predicate[]::new)));
        return this.entityManager.createQuery(query).getResultList();
    }


}
