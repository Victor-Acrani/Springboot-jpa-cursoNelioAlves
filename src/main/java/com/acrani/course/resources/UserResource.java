package com.acrani.course.resources;

import com.acrani.course.entities.UserEntity;
import com.acrani.course.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll(){
        List<UserEntity> allUsers = userService.findAll();
        return ResponseEntity.ok().body(allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable Long id){
        UserEntity user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<UserEntity> insert(@RequestBody UserEntity user){
        var newUser = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(newUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserEntity> deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> update(@PathVariable Long id, @RequestBody UserEntity user){
        user = userService.update(id, user);
        return ResponseEntity.ok().body(user);
    }
}

