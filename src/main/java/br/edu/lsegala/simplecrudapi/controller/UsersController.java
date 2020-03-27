package br.edu.lsegala.simplecrudapi.controller;

import br.edu.lsegala.simplecrudapi.model.Token;
import br.edu.lsegala.simplecrudapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/signin")
    public ResponseEntity<Token> signin(@RequestParam String username, @RequestParam String password){
        Token token = new Token();
        token.value = userService.signin(username, password);
        return ResponseEntity
                .status(token.value != null? HttpStatus.OK : HttpStatus.UNAUTHORIZED)
                .body(token);
    }
}
