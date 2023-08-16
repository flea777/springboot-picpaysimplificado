package flea777.picpaysimplificado.repositories;

import flea777.picpaysimplificado.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserbyDocument(String document);

    Optional<User> findUserbyId(Long id);
}
