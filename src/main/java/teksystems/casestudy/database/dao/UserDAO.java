package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import teksystems.casestudy.database.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    User findFirstByLoginIdAndPassword(String loginID, String passowrd);

    User findByEmail(String email);

    User findByLoginId(String username);
}
