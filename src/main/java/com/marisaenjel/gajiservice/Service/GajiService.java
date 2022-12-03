/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marisaenjel.gajiservice.Service;

import com.marisaenjel.gajiservice.Entity.Gaji;
import com.marisaenjel.gajiservice.Repository.GajiRepository;
import com.marisaenjel.gajiservice.Vo.Golongan;
import com.marisaenjel.gajiservice.Vo.Karyawan;
import com.marisaenjel.gajiservice.Vo.ResponseTemplateVo;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author acer
 */
@Service
public class GajiService {
    @Autowired
    private SimpleDateFormat formatTanggal;
    
    @Autowired
    private GajiRepository gajiRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public Gaji saveGaji(Gaji gaji){
        String tglSekarang = formatTanggal.format(new Date());   
        Golongan golongan = restTemplate.getForObject("http://localhost:8008/golongan/" 
                + gaji.getGolonganId(), Golongan.class);
        long totalGaji = golongan.getGolonganGajiPokok() + gaji.getTunjanganAnak() + gaji.getTunjanganSuamiIstri();
        gaji.setTotalGaji(totalGaji);
        gaji.setGajiTanggal(tglSekarang);
        return gajiRepository.save(gaji);
    }
    
    public ResponseTemplateVo getGaji(Long gajiId){
        ResponseTemplateVo vo = new ResponseTemplateVo();
        Gaji gaji = gajiRepository.findByGajiId(gajiId);
        Karyawan karyawan = restTemplate.getForObject("http://localhost:8009/karyawan/" 
              + gaji.getKaryawanId(), Karyawan.class);
        Golongan golongan = restTemplate.getForObject("http://localhost:8008/golongan/" 
                + gaji.getGolonganId(), Golongan.class);
        vo.setGaji(gaji);
        vo.setKaryawan(karyawan);
        vo.setGolongan(golongan);
        return vo;
    }
}
