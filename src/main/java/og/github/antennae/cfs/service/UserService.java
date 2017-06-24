package og.github.antennae.cfs.service;

import og.github.antennae.cfs.entity.User;
import og.github.antennae.cfs.entity.UserDao;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by snambi on 6/23/17.
 */
@Component
public class UserService {

    @Inject
    UserDao userDao;

    public User getUser( String email ){

        User user = userDao.findByEmail(email);

        return user;
    }

    public User getUser( long id ){
        return userDao.findOne(id);
    }

    public Collection<User> getAllUsers(){

        List<User> result = new ArrayList<>();

        Iterator<User> iterator = userDao.findAll().iterator();
        while( iterator.hasNext() ){
            result.add(iterator.next());
        }

        return result;
    }
}
