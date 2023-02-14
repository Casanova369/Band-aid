package br.com.csi.ufsm.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "role")
@Data
public class Role {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    
    private String name;
}
