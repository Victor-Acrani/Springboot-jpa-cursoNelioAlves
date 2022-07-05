package com.acrani.course.services;

import com.acrani.course.entities.UserEntity;
import com.acrani.course.repositories.UserRepository;
import com.acrani.course.services.exceptions.DatabaseException;
import com.acrani.course.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public UserEntity findById(Long id){
        Optional<UserEntity> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public UserEntity insert(UserEntity user){
        return userRepository.save(user);
    }

    public void deleteById(Long id){
        try{
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }

    }

    public UserEntity update(Long id, UserEntity user){

        try{
            var updatedUser = userRepository.getReferenceById(id);
            updateData(updatedUser, user);
            return userRepository.save(updatedUser);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }


    }

    private void updateData(UserEntity updatedUser, UserEntity user) {
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPhone(user.getPhone());
    }
}
