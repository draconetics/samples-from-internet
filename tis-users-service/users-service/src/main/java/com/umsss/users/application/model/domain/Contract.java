package com.umsss.users.application.model.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contract_table")
public class Contract {

    @Id
    @Column(name = "contractid", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "initdate", nullable = false, updatable = false)
    private Date initDate;

    @Column(name = "endtdate", nullable = false, updatable = false)
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "contractchid", referencedColumnName = "teacherid", nullable = false)
    private Teacher teacher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
