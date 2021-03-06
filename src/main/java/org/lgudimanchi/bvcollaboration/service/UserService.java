package org.lgudimanchi.bvcollaboration.service;

import org.lgudimanchi.bvcollaboration.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.lgudimanchi.bvcollaboration.database.dao.UserDAO;

@Service
public class UserService {

    @Autowired
    private UserDAO userdao;

    public User validateUser(String loginID, String password) {

        return userdao.findFirstByLoginIdAndPassword(loginID, password);

    }

    public User findByFirstName(String firstname) {

        return userdao.findByFirstName(firstname);

    }
    //Since it is basic CRUD operation we don't need to create save method in userDAO.
    public User saveUser(User user)
    {
        return userdao.save(user);
    }

}
