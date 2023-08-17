package flea777.picpaysimplificado.services;

import flea777.picpaysimplificado.domain.user.User;
import flea777.picpaysimplificado.domain.user.UserType;
import flea777.picpaysimplificado.dtos.UserDTO;
import flea777.picpaysimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Merchant users are not allowed to do transactions");
        }

        if (sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Balance is not enough");
        }
    }

    public User findUserById(Long id) throws Exception{
        return repository.findById(id).orElseThrow(() -> new Exception("User not found"));
    }

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
       return repository.findAll();
    }

    public void saveUser(User user) {
        repository.save(user);
    }
}
