package org.lgudimanchi.bvcollaboration.security;

import org.lgudimanchi.bvcollaboration.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.lgudimanchi.bvcollaboration.database.dao.UserDAO;

import java.util.ArrayList;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByLoginId(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username '" + username + "' not found in database");
        }

        // check the account status
        boolean accountIsEnabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        GrantedAuthority authority;
        ArrayList<GrantedAuthority> springRoles = new ArrayList<>();

        String password = user.getPassword();

        // setup user roles
        if (user.isBuyer()) {
            authority = new SimpleGrantedAuthority("BUYER");
            springRoles.add(authority);
        }
        else
        {
            authority = new SimpleGrantedAuthority("VENDOR");
            springRoles.add(authority);
        }

        return new org.springframework.security.core.userdetails.User(username, password,
                accountIsEnabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
                springRoles);

    }


}
