package com.umsss.users.application.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.umsss.users.api.model.AccountState;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account_table",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {
                        "email"
                })
        })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Account {

    @Id
    @Column(name = "accountid", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "avatarId")
    private String avatarId;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", length = 20, nullable = false)
    private AccountState state;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createddate", nullable = false)
    private Date createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(String avatarId) {
        this.avatarId = avatarId;
    }

    public AccountState getState() {
        return state;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
