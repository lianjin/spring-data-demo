/**
 * @(#)EntranceController.java, 二月 07, 2017.
 * <p>
 * Copyright 2017 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.ctrl;

import com.example.simple.SimpleUserRepository;
import com.example.simple.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinlian
 */
@RestController
public class EntranceController {

    @Autowired
    private SimpleUserRepository simpleUserRepository;

    @RequestMapping("/users/{username}")
    public User getByUsername(@PathVariable("username") String username) {
        return simpleUserRepository.findByUsername(username);
    }
}