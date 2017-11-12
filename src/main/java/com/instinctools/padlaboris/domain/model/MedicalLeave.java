package com.instinctools.padlaboris.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
 * Entity of MedicalLeave.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medical_leave")
public class MedicalLeave implements Serializable {

    private static final long serialVersionUID = 4534131348802359050L;

    @Id
    @Column(name = "medical_leave_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    @NonNull
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    @NonNull
    private Date endDate;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "MEDICAL_DOCTOR")
//    private String md;
}
