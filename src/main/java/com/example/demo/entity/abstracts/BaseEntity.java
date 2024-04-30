package com.example.demo.entity.abstracts;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {
    @Column(name = "CDATE")
    private LocalDateTime cDate;

    @Column(name = "CCUST")
    private Long cCustomer;

    @Column(name = "UDATE")
    private LocalDateTime uDate;

    @Column(name = "UCUST")
    private Long uCustomer;

    public BaseEntity(LocalDateTime cDate, Long cCustomer, LocalDateTime uDate, Long uCustomer) {
        this.cDate = cDate;
        this.cCustomer = cCustomer;
        this.uDate = uDate;
        this.uCustomer = uCustomer;
    }

    public BaseEntity() {
    }

    // Güncellenmeden önce çalışacak kod
    @PreUpdate
    public void onUpdate()
    {
        this.uCustomer = 4L;
        this.uDate = LocalDateTime.now();
    }

    // Eklenmeden önce çalışacak kod
    @PrePersist
    public void onCreate()
    {
        this.cCustomer = 4L;
        this.cDate = LocalDateTime.now();
    }

    public LocalDateTime getcDate() {
        return cDate;
    }

    public void setcDate(LocalDateTime cDate) {
        this.cDate = cDate;
    }

    public Long getcCustomer() {
        return cCustomer;
    }

    public void setcCustomer(Long cCustomer) {
        this.cCustomer = cCustomer;
    }

    public LocalDateTime getuDate() {
        return uDate;
    }

    public void setuDate(LocalDateTime uDate) {
        this.uDate = uDate;
    }

    public Long getuCustomer() {
        return uCustomer;
    }

    public void setuCustomer(Long uCustomer) {
        this.uCustomer = uCustomer;
    }
}
