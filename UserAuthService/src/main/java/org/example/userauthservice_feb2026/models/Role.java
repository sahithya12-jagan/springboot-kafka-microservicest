package org.example.userauthservice_feb2026.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Role extends BaseModel {

    @Column(name = "role_value")
    private String value;
}
