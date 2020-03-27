package br.edu.lsegala.simplecrudapi.service;

import br.edu.lsegala.simplecrudapi.repository.UserRepository;
import br.edu.lsegala.simplecrudapi.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    public String signin(String username, String password) {
        return userRepository.findByNameAndPassword(username, password)
                .map(u -> jwtTokenProvider.createToken(username, u.roles))
                .orElse(null);
    }
}