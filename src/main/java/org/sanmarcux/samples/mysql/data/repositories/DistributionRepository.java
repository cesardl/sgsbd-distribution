package org.sanmarcux.samples.mysql.data.repositories;

import org.sanmarcux.samples.mysql.data.entities.Distribution;
import org.springframework.data.repository.CrudRepository;

/**
 * Created for sgsbd-distribution on 18/08/2023.
 *
 * @author Cesardl
 */
public interface DistributionRepository extends CrudRepository<Distribution, Integer> {
}
