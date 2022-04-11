package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teksystems.casestudy.database.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

   // User validateuser(String loginID, String passowrd);


}
