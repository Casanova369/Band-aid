package br.com.csi.ufsm.common.config;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class ApplicationProperties implements CommandLineRunner, InitializingBean {
    
    @Value("${custom.welcome}")
    private String welcome;
    
    @Value("${server.port}")
    private String port;
    
    public static void log(String message) {
        System.out.println("\n" + message);
    }
    
    @Override
    public void afterPropertiesSet() {
        log(welcome);
    }

    @Override
    public void run(String... args) {
        log(welcome);
        log(port);
    }

}
