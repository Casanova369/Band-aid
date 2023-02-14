package br.com.csi.ufsm.repository;

import br.com.csi.ufsm.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
    
    // Todo: check if username exists
    Boolean existsByUsername(String username);
}
