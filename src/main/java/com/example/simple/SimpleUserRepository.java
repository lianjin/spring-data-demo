package com.example.simple;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author jinlian
 */
public interface SimpleUserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(String username);

    List<User> findByLastname(String lastname);

    @Query("select u from User u where u.firstname = :firstname")
    List<User> findByFirstname(String firstname);
}