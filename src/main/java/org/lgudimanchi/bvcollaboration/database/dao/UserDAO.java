package org.lgudimanchi.bvcollaboration.database.dao;

import org.lgudimanchi.bvcollaboration.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    User findFirstByLoginIdAndPassword(String loginID, String passowrd);

    User findByEmail(String email);

    User findByLoginId(String username);

    User findByFirstName(String firstname);
}
