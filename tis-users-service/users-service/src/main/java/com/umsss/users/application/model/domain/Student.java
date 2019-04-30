package com.umsss.users.application.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "student_table")
@PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name = "studentid", referencedColumnName = "userid")
})
public class Student extends User {

    @Column(name = "note")
    private Integer note;

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }
}
