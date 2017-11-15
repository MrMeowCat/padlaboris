package com.instinctools.padlaboris.application.controller;

import com.instinctools.padlaboris.application.dto.MedicalLeaveDto;
import com.instinctools.padlaboris.domain.model.MedicalLeave;
import com.instinctools.padlaboris.domain.service.DiseaseService;
import com.instinctools.padlaboris.domain.service.MedicalLeaveService;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for {@link com.instinctools.padlaboris.domain.model.MedicalLeave}.
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MedicalLeaveController {

    private final DiseaseService diseaseService;

    private final MedicalLeaveService medicalLeaveService;

    private final DozerBeanMapper dozerBeanMapper;

    /**
     * Gets a medical leave.
     * @param leaveId id of a leave
     * @return a medical leave
     */
    @GetMapping("leaves/{leaveId}")
    public ResponseEntity getLeave(@PathVariable("leaveId") final Integer leaveId) {
        final MedicalLeave medicalLeave = medicalLeaveService.fetch(leaveId);
        final MedicalLeaveDto medicalLeaveDto = dozerBeanMapper.map(medicalLeave, MedicalLeaveDto.class);

        return ResponseEntity.ok(medicalLeaveDto);
    }
}
