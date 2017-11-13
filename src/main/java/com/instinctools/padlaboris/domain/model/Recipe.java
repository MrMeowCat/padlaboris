package com.instinctools.padlaboris.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Entity of Recipe.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recipes")
public class Recipe implements Serializable {

    private static final long serialVersionUID = 5202257027329539131L;

    @Id
    @Column(name = "recipe_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "issue_date")
    @NonNull
    private Date issueDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "expire_date")
    @NonNull
    private Date expireDate;

    @Column(name = "medicine_name")
    @NonNull
    private String medicineName;

    @Column(name = "dosage")
    @NonNull
    private String dosage;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "disease_id")
    private Disease disease;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "MEDICAL_DOCTOR")
//    private String md;
}
