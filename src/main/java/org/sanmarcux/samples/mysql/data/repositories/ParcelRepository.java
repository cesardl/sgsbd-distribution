package org.sanmarcux.samples.mysql.data.repositories;

import org.sanmarcux.samples.mysql.data.entities.ParcelEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Created for sgsbd-distribution on 18/08/2023.
 *
 * @author Cesardl
 */
public interface ParcelRepository extends CrudRepository<ParcelEntity, Integer> {

    @Query("SELECT p FROM ParcelEntity p WHERE p.status = '1'")
    Collection<ParcelEntity> findAllActiveParcels();
}
