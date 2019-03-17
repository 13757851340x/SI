package autonomoNetwork.myApp.Service;

import autonomoNetwork.myApp.Model.User;
import autonomoNetwork.myApp.Repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.security.Principal;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
public class UserService implements UserDetailsService {

    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = this.read(username);
        return withUsername(user.getUsername()).password(user.getPassword()).roles(user.getRole()).build();
    }

    public User read(String username) {
        return this.repo.findById(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public User getCurrentUser() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return this.read(principal.getName());
    }
}