/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marisaenjel.gajiservice.Vo;

import com.marisaenjel.gajiservice.Entity.Gaji;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author acer
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVo {
    private Gaji gaji;
    private Karyawan karyawan;
    private Golongan golongan;  
}
