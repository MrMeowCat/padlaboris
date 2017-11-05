package com.instinctools.padlaboris.controller;

import com.instinctools.padlaboris.dto.DetailDto;
import com.instinctools.padlaboris.model.Detail;
import com.instinctools.padlaboris.service.DetailService;
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

        DetailDto response = dozerBeanMapper.map(detailService.create(dozerBeanMapper.map(detailDto, Detail.class)),
                DetailDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateDetail(@RequestBody final DetailDto detailDto, @PathVariable Integer id) {

        this.dozerBeanMapper = new DozerBeanMapper();

        Detail detail = dozerBeanMapper.map(detailDto, Detail.class);

        detailService.updateById(id, detail);

        return ResponseEntity.ok().body(dozerBeanMapper.map(detailService.fetch(id), DetailDto.class));
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public ResponseEntity fetchDetail(@PathVariable final Integer id) {

        this.dozerBeanMapper = new DozerBeanMapper();

        return ResponseEntity.ok().body(dozerBeanMapper.map(detailService.fetch(id), DetailDto.class));
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public ResponseEntity fetchAllDetails() {

        return ResponseEntity.ok().body(detailService.listDetails());
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDetail(@PathVariable final Integer id) {

        this.dozerBeanMapper = new DozerBeanMapper();

        final DetailDto response = dozerBeanMapper.map(detailService.fetch(id), DetailDto.class);

        detailService.delete(id);

        return ResponseEntity.ok().body(response);
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
