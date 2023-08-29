package org.sanmarcux.samples.mysql.sgsbddistribution;

import org.junit.jupiter.api.Test;
import org.sanmarcux.samples.mysql.data.entities.DistributionEntity;
import org.sanmarcux.samples.mysql.data.entities.ParcelEntity;
import org.sanmarcux.samples.mysql.data.repositories.DistributionRepository;
import org.sanmarcux.samples.mysql.data.repositories.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SgsbdDistributionApplicationTests {

    @Autowired
    private DistributionRepository distributionRepository;
    @Autowired
    private ParcelRepository parcelRepository;

    @Test
    void allDistributions() {
        Iterable<DistributionEntity> result = distributionRepository.findAll();

        long size = StreamSupport.stream(result.spliterator(), false).count();

        assertEquals(0, size);
    }

    @Test
    void allParcels() {
        Collection<ParcelEntity> result = parcelRepository.findAllActiveParcels();

        long size = result.size();

        assertEquals(4, size);
    }
}
