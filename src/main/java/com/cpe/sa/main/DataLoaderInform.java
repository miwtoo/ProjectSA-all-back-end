package com.cpe.sa.main;

import com.cpe.sa.main.entity.*;
import com.cpe.sa.main.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderInform implements ApplicationRunner {

    @Autowired
    private PillRepository pillrepository;
    @Autowired
    private Usedrepository usedrepository;
    @Autowired
    private TimePillRepository timepillrepository;
    @Autowired
    private TypePillrepository typepillrepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        usedrepository.save(new Used("ทานครั้งละ 1 เม็ด"));
        usedrepository.save(new Used("ทานครั้งละ 1 ช้อนชา"));
        usedrepository.save(new Used("ยาทาบริเวณกล้ามเนื้อ"));
        usedrepository.findAll().forEach(System.out::println); 

        timepillrepository.save(new TimePill("เช้า"));
        timepillrepository.save(new TimePill("กลางวัน"));
        timepillrepository.save(new TimePill("เย็น"));
        timepillrepository.save(new TimePill("ก่อนนอน"));
        timepillrepository.findAll().forEach(System.out::println);

        pillrepository.save(new Pill("Parasetamon"));
        pillrepository.save(new Pill("Mha"));
        pillrepository.save(new Pill("E"));
        pillrepository.findAll().forEach(System.out::println);

        typepillrepository.save(new TypePill("ยาน้ำ"));
        typepillrepository.save(new TypePill("ยาเม็ด"));
        typepillrepository.save(new TypePill("ยาทาภายนอก"));
        typepillrepository.save(new TypePill("ยาทาภายใน"));
        typepillrepository.findAll().forEach(System.out::println);

   

    };
}
