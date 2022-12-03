/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marisaenjel.gajiservice.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author acer
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gaji {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gajiId;
    private long karyawanId;
    private long golonganId;
    private String gajiTanggal;
    private long tunjanganAnak;
    private long tunjanganSuamiIstri;
    private long totalGaji;  
}
