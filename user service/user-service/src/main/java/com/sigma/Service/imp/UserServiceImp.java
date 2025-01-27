package com.sigma.Service.imp;

import com.sigma.Exception.UserException;
import com.sigma.Model.User;
import com.sigma.Repository.Userrepository;
import com.sigma.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {


    private final Userrepository userrepository;

    @Override
    public User createUser(User user) {
        return userrepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserException {
        Optional<User> opt= userrepository.findById(id);
        if(opt.isPresent()){
            return opt.get();

        }
        throw  new UserException("User not Found");
    }

    @Override
    public List<User> getAllUsers() {
        return userrepository.findAll();
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        Optional<User> opt= userrepository.findById(id);
        if(opt.isEmpty()){
            throw new Exception("user not exist with id"+id);
        }
        userrepository.deleteById(opt.get().getId());

    }

    @Override
    public User updateUser(Long id, User user) throws UserException {
        Optional<User> opt= userrepository.findById(id);
        if(opt.isEmpty()){
            throw new UserException("User not Found with id"+id);
        }
        User u=opt.get();
        u.setFullName(user.getFullName());
        u.setEmail(user.getEmail());
        u.setRole(user.getRole());
        u.setUsername(user.getUsername());
        return userrepository.save(u);
    }
}
