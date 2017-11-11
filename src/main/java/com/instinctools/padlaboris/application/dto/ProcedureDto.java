package com.instinctools.padlaboris.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Dto for {@link com.instinctools.padlaboris.domain.model.Procedure}.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureDto implements Serializable {

    private static final long serialVersionUID = -5138973605695519394L;

    private Integer id;
    private String procedureName;
    private Long date;
    private PatientDto patient;
}
