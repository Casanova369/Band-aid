package br.com.csi.ufsm.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Postgres implements InitializingBean {
    
    @Override
    public void afterPropertiesSet() {
        log("Successful! Server Port: 9000");
    }
    
    void log(String LOG) {
        System.out.println(LOG);
    }

}
