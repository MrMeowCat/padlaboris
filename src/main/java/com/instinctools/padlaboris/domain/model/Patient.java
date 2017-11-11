package com.instinctools.padlaboris.domain.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity that describes the patient.
 */
@Data
@Entity
@Table(name = "patients")
public class Patient implements Serializable {

    private static final long serialVersionUID = -3036693743601488048L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "home_number")
    private String homeNumber;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "last_change_date")
    @UpdateTimestamp
    private Date lastChangeDate;

    @Column(name = "death_date")
    private Date deathDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "detail_id")
    private Detail details;

    @Fetch(FetchMode.SELECT)
    @OneToMany(
            mappedBy = "patient",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Procedure> procedures = new ArrayList<>();
}
