package com.instinctools.padlaboris.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Intermediate class of MedicalLeave and controller work.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalLeaveDto implements Serializable {

    private static final long serialVersionUID = 1501799540307879889L;

    private Integer id;

    private Long startDate;

    private Long endDate;
}
