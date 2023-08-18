package org.sanmarcux.samples.mysql.sgsbddistribution;

import org.junit.jupiter.api.Test;
import org.sanmarcux.samples.mysql.data.entities.Distribution;
import org.sanmarcux.samples.mysql.data.repositories.DistributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SgsbdDistributionApplicationTests {

    @Autowired
    private DistributionRepository distributionRepository;

    @Test
    void contextLoads() {
        Iterable<Distribution> result = distributionRepository.findAll();

        long size = StreamSupport.stream(result.spliterator(), false).count();

        assertEquals(0, size);
    }

}
