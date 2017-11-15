package com.instinctools.padlaboris.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Intermediate class of Recipe and controller work.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto implements Serializable {

    private static final long serialVersionUID = -1290561905472902453L;

    private Integer id;

    private Long issueDate;

    private Long expireDate;

    private String medicineName;

    private String dosage;

    private DiseaseDto disease;
}
