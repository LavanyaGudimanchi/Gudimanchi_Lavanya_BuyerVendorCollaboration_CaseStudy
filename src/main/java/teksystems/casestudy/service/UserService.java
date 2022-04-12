package teksystems.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entity.User;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDAO userdao;

    public User validateUser(String loginID, String password) {

        return userdao.findFirstByLoginIdAndPassword(loginID,password);

    }

    public User saveUser(User user)
    {
        return userdao.save(user);
    }

}
