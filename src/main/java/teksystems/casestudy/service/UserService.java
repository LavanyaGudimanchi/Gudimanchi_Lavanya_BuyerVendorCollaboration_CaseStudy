package teksystems.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDAO userdao;


    public User getUserbyID(Integer Id) {

        return userdao.getById(Id);

    }

    public User saveUser(User user)
    {
        return userdao.save(user);
    }

}
