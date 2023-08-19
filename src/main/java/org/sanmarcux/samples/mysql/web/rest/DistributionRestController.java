package org.sanmarcux.samples.mysql.web.rest;

import org.sanmarcux.samples.mysql.services.DistributionService;
import org.sanmarcux.samples.mysql.web.errors.BadRequestException;
import org.sanmarcux.samples.mysql.web.models.Distribution;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created for sgsbd-distribution on 18/08/2023.
 *
 * @author Cesardl
 */
@RestController
@RequestMapping("/api/distributions")
public class DistributionRestController {

    private final DistributionService distributionService;

    public DistributionRestController(DistributionService distributionService) {
        this.distributionService = distributionService;
    }

    @GetMapping
    public List<Distribution> getAll(@RequestParam(name = "cost", required = false) String cost) {
        return this.distributionService.getAll(cost);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Distribution create(@RequestBody Distribution distribution) {
        return this.distributionService.createOrUpdate(distribution);
    }

    @GetMapping("/{id}")
    public Distribution get(@PathVariable("id") int id) {
        return this.distributionService.get(id);
    }

    @PutMapping("/{id}")
    public Distribution update(@PathVariable("id") int id, @RequestBody Distribution distribution) {
        if (id != distribution.getId()) {
            throw new BadRequestException("Ids do not match");
        }
        return this.distributionService.createOrUpdate(distribution);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void delete(@PathVariable("id") int id) {
        this.distributionService.delete(id);
    }
}
