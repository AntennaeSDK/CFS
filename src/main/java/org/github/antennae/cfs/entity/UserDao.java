package org.github.antennae.cfs.entity;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by snambi on 6/23/17.
 */
public interface UserDao extends CrudRepository<User, Long> {

    /**
     * Return the user having the passed email or null if no user is found.
     *
     * @param email the user email.
     */
    User findByEmail(String email);

    /*

     */
    List<User> findUsersByNameContaining(String name);
}
