package teksystems.casestudy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entity.User;
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
