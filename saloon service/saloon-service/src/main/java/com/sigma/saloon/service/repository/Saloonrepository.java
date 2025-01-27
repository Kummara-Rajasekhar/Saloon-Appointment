package com.sigma.saloon.service.repository;

import com.sigma.saloon.service.Model.Saloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface Saloonrepository  extends JpaRepository<Saloon,Long> {

    Saloon findByOwnerId(Long id);

    @Query(
            "select s from Saloon s where "+
                    "(lower(s.city) like lower(concat('%',:keyword,'%') )  OR +" +
                    "(lower(s.name) like lower(concat('%', :keyword,'%') )  OR " +
                    "(lower(s.address) like lower(concat('%',:keyword,'%') ))"
    )

    List<Saloon> searchSaloons(@Param("keyword") String keyword);
}
