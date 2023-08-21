package org.sanmarcux.samples.mysql.services;

import org.sanmarcux.samples.mysql.data.entities.ParcelEntity;
import org.sanmarcux.samples.mysql.data.repositories.ParcelRepository;
import org.sanmarcux.samples.mysql.web.models.Parcel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created for sgsbd-distribution on 18/08/2023.
 *
 * @author Cesardl
 */
@Service
public class ParcelService {

    private final ParcelRepository parcelRepository;

    public ParcelService(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    public List<Parcel> getAll() {
        List<Parcel> parcels = new ArrayList<>();
        Collection<ParcelEntity> all = parcelRepository.findAllActiveParcels();
        all.forEach(entity -> parcels.add(this.translateDbToWeb(entity)));
        return parcels;
    }

    private Parcel translateDbToWeb(ParcelEntity entity) {
        Parcel parcel = new Parcel();
        parcel.setId(entity.getId());
        parcel.setDescription(entity.getDescription());
        parcel.setStatus(entity.getStatus());
        return parcel;
    }
}
