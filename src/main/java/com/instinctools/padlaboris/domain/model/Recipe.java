package com.instinctools.padlaboris.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Getter
@Setter
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
    private Date issueDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "expire_date")
    private Date expireDate;

    @Column(name = "medicine_name")
    private String medicineName;

    @Column(name = "dosage")
    private String dosage;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "disease_id")
    private Disease disease;
}
