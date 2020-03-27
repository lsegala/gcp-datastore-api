package br.edu.lsegala.simplecrudapi.repository;

import br.edu.lsegala.simplecrudapi.model.Role;
import br.edu.lsegala.simplecrudapi.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepository {
    List<User> users;

    @PostConstruct
    public void init(){
        users = new ArrayList<>();
        User user = new User();
        user.name = "test";
        user.password = "test";
        user.roles = new ArrayList<>();
        user.roles.add(Role.ROLE_CLIENT);
        users.add(user);
    }

    public Optional<User> findByNameAndPassword(final String name, final String password){
        return users.stream()
                .filter(p -> p.name.equals(name) && p.password.equals(password))
                .findFirst();
    }

    public Optional<User> findByName(final String username) {
        return users.stream()
                .filter(p -> p.name.equals(username))
                .findFirst();
    }
}
