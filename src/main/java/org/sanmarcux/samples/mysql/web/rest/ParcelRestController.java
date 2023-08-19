package org.sanmarcux.samples.mysql.web.rest;

import org.sanmarcux.samples.mysql.services.ParcelService;
import org.sanmarcux.samples.mysql.web.models.Parcel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created for sgsbd-distribution on 18/08/2023.
 *
 * @author Cesardl
 */
@RestController
@RequestMapping("/api/parcels")
public class ParcelRestController {

    private final ParcelService parcelService;

    public ParcelRestController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    @GetMapping
    public List<Parcel> getAll() {
        return this.parcelService.getAll();
    }
}
