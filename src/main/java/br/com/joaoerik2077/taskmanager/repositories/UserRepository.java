package br.com.joaoerik2077.taskmanager.repositories;

import br.com.joaoerik2077.taskmanager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
