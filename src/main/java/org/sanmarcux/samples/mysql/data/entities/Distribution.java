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
@Table(name = "sgs_distribucion")
@Data
@ToString
public class Distribution {

    @Id
    @Column(name = "sgs_parcela_n_parcela_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sgs_distribucion_produccion")
    private String production;

    @Column(name = "sgs_distribucion_utilidad")
    private String utility;

    @Column(name = "sgs_distribucion_costo")
    private String cost;

//    @Column(name = "sgs_demanda_sgs_demanda_n_id")
//    @Column(name = "sgs_producto_n_producto_id")
//    @Column(name = "sgs_temporada_n_temporada_id1")
}
