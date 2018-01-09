package com.mvc.common.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Table;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "legalentities")
public class LegalEntity {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private int id;
    @Column(name = "name", length = 50, nullable = false)
    @Size(min = 5, max = 50, message = "{legalуntity.name.valid}")
    @NotNull
    private String name;
    @Column(name = "inn", length = 12, nullable = false)
    @Size(min = 10, max = 12, message = "{legalуntity.inn.valid}")
    @NotNull
    private String inn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    @Override
    public String toString() {
        return name;
    }
}
