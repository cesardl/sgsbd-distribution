package org.sanmarcux.samples.mysql.services;

import org.sanmarcux.samples.mysql.data.entities.DistributionEntity;
import org.sanmarcux.samples.mysql.data.repositories.DistributionRepository;
import org.sanmarcux.samples.mysql.web.errors.NotFoundException;
import org.sanmarcux.samples.mysql.web.models.Distribution;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created for sgsbd-distribution on 18/08/2023.
 *
 * @author Cesardl
 */
@Service
public class DistributionService {

    private final DistributionRepository distributionRepository;

    public DistributionService(DistributionRepository distributionRepository) {
        this.distributionRepository = distributionRepository;
    }

    public List<Distribution> getAll(String filterCost) {
        List<Distribution> distributions = new ArrayList<>();
        if (StringUtils.hasLength(filterCost)) {
            DistributionEntity entity = this.distributionRepository.findByCost(filterCost);
            distributions.add(this.translateDbToWeb(entity));
        } else {
            Iterable<DistributionEntity> entities = this.distributionRepository.findAll();
            entities.forEach(entity -> {
                distributions.add(this.translateDbToWeb(entity));
            });
        }
        return distributions;
    }

    public Distribution get(int id) {
        Optional<DistributionEntity> optional = this.distributionRepository.findById(id);
        if (optional.isEmpty()) {
            throw new NotFoundException("Distribution not found with id");
        }
        return this.translateDbToWeb(optional.get());
    }

    public Distribution createOrUpdate(Distribution distribution) {
        DistributionEntity entity = this.translateWebToDb(distribution);
        entity = this.distributionRepository.save(entity);
        return this.translateDbToWeb(entity);
    }

    public void delete(int id) {
        this.distributionRepository.deleteById(id);
    }

    private DistributionEntity translateWebToDb(Distribution distribution) {
        DistributionEntity entity = new DistributionEntity();
        entity.setId(distribution.getId());
        entity.setProduction(distribution.getProduction());
        entity.setCost(distribution.getCost());
        return entity;
    }

    private Distribution translateDbToWeb(DistributionEntity entity) {
        Distribution distribution = new Distribution();
        distribution.setId(entity.getId());
        distribution.setProduction(entity.getProduction());
        distribution.setCost(entity.getCost());
        return distribution;
    }
}
