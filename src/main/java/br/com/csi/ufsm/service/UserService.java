package br.com.csi.ufsm.service;

import br.com.csi.ufsm.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public record UserService(UserRepo repo) {
    
}
