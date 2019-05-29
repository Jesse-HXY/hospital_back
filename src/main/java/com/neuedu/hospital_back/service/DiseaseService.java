package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.DiseaseMapper;
import com.neuedu.hospital_back.po.Disease;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DiseaseService {

    @Resource
    private DiseaseMapper diseaseMapper;

    public List<String> getDiseaseType() {
        List<String> diseases = diseaseMapper.getDiseaseType();
        return diseases;
    }

    public List<Disease> getDiseaseByType(String disType){
        List<Disease> diseases =diseaseMapper.getDiseaseByType(disType);
    return diseases;
    }

    public List<Disease> getDiseaseByPage(String disType,int begin, int pageSize){
        List<Disease> diseases=diseaseMapper.getDiseaseByPage(disType,begin,pageSize);
        return diseases;
    }
    public List<Disease> getDiseases(Disease disease) {
        List<Disease> diseases = diseaseMapper.getDiseases(disease);
        return diseases;
    }

    public boolean insert(Disease record) {
       return diseaseMapper.insert(record)==1;

    }

    public boolean updateDisease(Disease disease){
      return   diseaseMapper.updateByPrimaryKeySelective(disease)==1;

    }

    public boolean deleteDisease(int disId){
       return diseaseMapper.deleteByPrimaryKey(disId)==1;

    }

    public int getDiseaseCount(){return diseaseMapper.getDiseaseCount();}
}


