package org.sanmarcux.samples.mysql.data.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created for sgsbd-distribution on 18/08/2023.
 *
 * @author Cesardl
 */
@Entity
@Table(name = "sgs_parcela")
@Data
@ToString
public class ParcelEntity {

    @Id
    @Column(name = "n_parcela_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "s_parcela_descripcion")
    private String description;

    @Column(name = "s_parcela_estado")
    private String status;
}
