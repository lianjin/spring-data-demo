package com.example.ctrl;

import com.example.simple.SimpleUserRepository;
import com.example.simple.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping("/users")
    public List<User> getByFirstName(@RequestParam("firstname") String firstname) {
        return simpleUserRepository.findByFirstname(firstname);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User save(@RequestBody User user) {
        return simpleUserRepository.save(user);
    }

    @RequestMapping("/users/getAll")
    public Page<User> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC, "username");
        Pageable pageRequest = new PageRequest(page, pageSize, sort);
        return simpleUserRepository.findAll(pageRequest);
    }

}