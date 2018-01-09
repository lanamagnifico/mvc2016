package com.mvc.common.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private int id;
    @Column(name = "name", length = 50, nullable = false)
    @Size(min = 3, max = 50,message = "{department.name.valid}")
    @NotNull
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "entity_id", nullable = false)
    @NotNull
    private LegalEntity legalEntity;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "department_id")
    private Department parent;

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

    public LegalEntity getEntity() {
        return legalEntity;
    }

    public void setEntity(LegalEntity legalEntity) {
        this.legalEntity = legalEntity;
    }

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return name;
    }
}
