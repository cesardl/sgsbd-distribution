package org.sanmarcux.samples.mysql.data.repositories;

import org.sanmarcux.samples.mysql.data.entities.DistributionEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created for sgsbd-distribution on 18/08/2023.
 *
 * @author Cesardl
 */
public interface DistributionRepository extends CrudRepository<DistributionEntity, Integer> {

    DistributionEntity findByCost(String filterCost);
}
