package com.java4all.scalogtask;

import com.java4all.scalogtask.entity.LogInfo;
import com.java4all.scalogtask.service.LogInfoService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScalogTaskApplicationTests {

    @Autowired
    private LogInfoService logInfoService;


    @Test
    void contextLoads() {
    }

    @Test
    void getAll(){
        System.out.println("aaaaa");
        List<LogInfo> all = logInfoService.getAll();
        System.out.println(all.toString());
    }

}
