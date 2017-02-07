/**
 * @(#)SimpleUserRepository.java, 二月 07, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.simple;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author jinlian
 */
public interface SimpleUserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    List<User> findByLastname(String lastname);

    @Query("select u from User u where u.firstname = :firstname")
    List<User> findByFirstname(String firstname);
}