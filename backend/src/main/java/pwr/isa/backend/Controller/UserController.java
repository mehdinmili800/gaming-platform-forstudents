package pwr.isa.backend.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwr.isa.backend.Security.auth.TokenService;
import pwr.isa.backend.entity.User;
import pwr.isa.backend.service.UserService;


@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private UserService userService;
    private TokenService tokenService;

    public UserController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @GetMapping(path= "/")
    public Iterable<User> readUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path= "/{id}")
    public ResponseEntity<User> readUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.FOUND);
    }

    @PostMapping(path= "/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping(path= "{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user,id), HttpStatus.OK);
    }

    @PatchMapping(path= "/{id}")
    public ResponseEntity<User> patchUser(
            @PathVariable Long id,
            @RequestBody User user) {
        return new ResponseEntity<>(userService.patchUser(user,id), HttpStatus.OK);
    }

    @DeleteMapping(path= "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
