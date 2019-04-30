package com.umsss.users.application.model.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher_Table")
@PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name = "teacherid", referencedColumnName = "userid")
})
public class Teacher extends User {

    private String profession;

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
