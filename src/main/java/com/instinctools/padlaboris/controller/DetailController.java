package com.instinctools.padlaboris.controller;

import com.instinctools.padlaboris.dto.DetailDto;
import com.instinctools.padlaboris.model.Detail;
import com.instinctools.padlaboris.model.Patient;
import com.instinctools.padlaboris.service.DetailService;
import com.instinctools.padlaboris.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DetailController {

    private final DetailService detailService;

    private DozerBeanMapper dozerBeanMapper;

    @RequestMapping(value = "/details", method = RequestMethod.POST)
    public ResponseEntity createDetail(@RequestBody final DetailDto detailDto) {
        dozerBeanMapper = new DozerBeanMapper();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(detailService.create(dozerBeanMapper.map(detailDto, Detail.class)));
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public ResponseEntity fetchDetail(@PathVariable final Integer id) {
        return ResponseEntity.ok().body(detailService.fetch(id));
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public ResponseEntity fetchAllDetails() {
        return ResponseEntity.ok().body(detailService.listDetails());
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDetail(@PathVariable final Integer id) {
        final Detail detail = detailService.fetch(id);

        detailService.delete(id);
        return ResponseEntity.ok().body(detail);
    }

    @RequestMapping(value = "/details/bloodType/{bloodType}", method = RequestMethod.GET)
    public ResponseEntity fetchByBloodType(@PathVariable final Integer bloodType) {
        return ResponseEntity.ok().body(detailService.findByBloodType(bloodType));
    }

    @RequestMapping(value = "/details/rh/{rhesusFactor}", method = RequestMethod.GET)
    public ResponseEntity fetchByRhesusFactor(@PathVariable final String rhesusFactor) {

        return ResponseEntity.ok().body(detailService.findByRhesusFactor(rhesusFactor));
    }
}
