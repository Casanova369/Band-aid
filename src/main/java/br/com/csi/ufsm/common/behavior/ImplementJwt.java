package br.com.csi.ufsm.common.behavior;

import org.springframework.security.core.Authentication;

public interface ImplementJwt {

    long EXPIRE = 70000;
    String SECRET = "SUPER_SECRET_STRING";
    
    String generateToken(Authentication authentication);
    
    String getUsernameFromJwt(String token);
    
    Boolean validateToken(String token);

}
