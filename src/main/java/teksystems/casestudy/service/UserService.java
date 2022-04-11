package teksystems.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.dao.UserRepository;
import teksystems.casestudy.database.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userdao;

    public User getUser(String loginId, String password) {

      return  userdao.validateuser(loginId,password);

    }

}
