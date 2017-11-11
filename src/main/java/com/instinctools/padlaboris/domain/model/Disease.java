package com.instinctools.padlaboris.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Entity that describes the diseases.
 */
@Entity
@Table(name = "diseases")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disease implements Serializable {

    private static final long serialVersionUID = -7297453128549936965L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "disease_name")
    private String diseaseName;

    @Column(name = "disease_code")
    private String diseaseCode;

    @Column(name = "disease_description")
    private String diseaseDescription;

    @Column(name = "disease_class")
    private String diseaseClass;

    @Temporal(TemporalType.DATE)
    @Column(name = "startDate")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "endDate")
    private Date endDate;
}
