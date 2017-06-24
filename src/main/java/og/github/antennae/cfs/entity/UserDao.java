package og.github.antennae.cfs.entity;

import org.springframework.data.repository.CrudRepository;

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

}
