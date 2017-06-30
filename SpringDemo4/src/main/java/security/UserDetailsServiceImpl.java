package security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2017/6/22.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (s == null || "".equals(s)) {
            throw new UsernameNotFoundException(s + "not found");
        }

        List<GrantedAuthority> userAuthList = new ArrayList<>();
        userAuthList.add(new SimpleGrantedAuthority("user"));
        userAuthList.add(new SimpleGrantedAuthority("normal"));

        List<GrantedAuthority> adminAuthList = new ArrayList<>();
        adminAuthList.add(new SimpleGrantedAuthority("admin"));

        if (s.equals("admin")) {
            return new User(s, "1111", adminAuthList);
        } else {
            return new User(s, "1111", userAuthList);
        }
    }
}
