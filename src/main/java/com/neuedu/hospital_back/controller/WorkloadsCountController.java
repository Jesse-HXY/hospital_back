package com.neuedu.hospital_back.controller;

import com.neuedu.hospital_back.po.WorkloadsCount;
import com.neuedu.hospital_back.service.WorkloadsCountService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/workloadsCount")
public class WorkloadsCountController {

    @Resource
    private WorkloadsCountService workloadsCountService;

    @PostMapping("/getWorkloadsCountBydId")
    public WorkloadsCount getWorkloadsCountBydId(@RequestBody JSONObject object){
        return workloadsCountService.getWorkloadsCountBydId(object);
    }

    @PostMapping("/getWorkloadsCountByPostDId")
    public WorkloadsCount getWorkloadsCountByPostDId(@RequestBody JSONObject object){
        return workloadsCountService.getWorkloadsCountByPostDId(object);
    }

    @PostMapping("/getWorkloadsCountByuId")
    public WorkloadsCount getWorkloadsCountByuId(@RequestBody JSONObject object){
        return workloadsCountService.getWorkloadsCountByuId(object);
    }

    @PostMapping("/getWorkloadsCountBycId")
    public WorkloadsCount getWorkloadsCountBycId(@RequestBody JSONObject object){
        return workloadsCountService.getWorkloadsCountBycId(object);
    }
}
