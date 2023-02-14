package br.com.csi.ufsm.controllers;

import br.com.csi.ufsm.dto.AuthDTO;
import br.com.csi.ufsm.dto.LoginDTO;
import br.com.csi.ufsm.dto.RegisterDTO;
import br.com.csi.ufsm.models.Role;
import br.com.csi.ufsm.models.UserEntity;
import br.com.csi.ufsm.repository.RoleRepo;
import br.com.csi.ufsm.repository.UserRepo;
import br.com.csi.ufsm.security.JwtGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthenticationManager authenticationManager;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder encoder;
    private final JwtGenerator jwtGenerator;
    

    @PostMapping("login")
    public ResponseEntity<AuthDTO> login(@RequestBody LoginDTO dto){
        
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                )
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String token = jwtGenerator.generateToken(authentication);
        
        return new ResponseEntity<>(new AuthDTO(token), HttpStatus.OK);
    }
    
    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO dto) {
        
        if (userRepo.existsByUsername(dto.getUsername())) 
            return new ResponseEntity<>("Username is already taken", HttpStatus.BAD_REQUEST);
        
        Role roles = roleRepo.findByName("USER").get();

        UserEntity user = UserEntity.builder()
            .username(dto.getUsername())
            .password(encoder.encode(dto.getPassword()))
            .roles(Collections.singletonList(roles))
            .build();
        
        userRepo.save(user);
        
        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
}
