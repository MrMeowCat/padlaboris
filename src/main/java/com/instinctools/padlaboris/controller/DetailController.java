package com.instinctools.padlaboris.controller;

import com.instinctools.padlaboris.dto.DetailDto;
import com.instinctools.padlaboris.model.Detail;
import com.instinctools.padlaboris.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DetailController {

    private final DetailService detailService;

    private DozerBeanMapper dozerBeanMapper;

    @RequestMapping(value = "/details", method = RequestMethod.POST)
    public ResponseEntity createDetail(@RequestBody DetailDto detailDto) {
        dozerBeanMapper = new DozerBeanMapper();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(detailService.create(dozerBeanMapper.map(detailDto, Detail.class)));
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public ResponseEntity fetchDetail(@PathVariable Integer id) {
        return ResponseEntity.ok().body(detailService.fetch(id));
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public ResponseEntity fetchAllDetails() {
        return ResponseEntity.ok().body(detailService.listDetails());
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDetail(@PathVariable Integer id) {
        Detail detail = detailService.fetch(id);

        detailService.delete(id);
        return ResponseEntity.ok().body(detail);
    }

    @RequestMapping(value = "/details/bloodType/{bloodType}", method = RequestMethod.GET)
    public ResponseEntity fetchByBloodType(@PathVariable Integer bloodType) {
        return ResponseEntity.ok().body(detailService.findByBloodType(bloodType));
    }

    @RequestMapping(value = "/details/bmi/{bmi}", method = RequestMethod.GET)
    public ResponseEntity fetchByBMI(@PathVariable final double bmi) {

        return ResponseEntity.ok().body(detailService.findByBMI(bmi));
    }
}
