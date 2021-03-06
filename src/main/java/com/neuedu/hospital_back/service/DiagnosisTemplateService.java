package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.*;
import com.neuedu.hospital_back.po.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiagnosisTemplateService {

    @Resource
    private DiagnosisTemplateMapper diagnosisTemplateMapper;

    @Resource
    private DepartmentMapper departmentMapper;

    @Resource
    private DepartmentUserMapper departmentUserMapper;

    @Resource
    private DiagnosisTemplateDepartmentMapper diagnosisTemplateDepartmentMapper;

    @Resource
    private DiagnosisTemplateUserMapper diagnosisTemplateUserMapper;

    @Resource
    private DiagnosisTemplateMedicineMapper diagnosisTemplateMedicineMapper;


    public boolean deleteByPrimaryKey(JSONObject object) {
        Integer datId = object.getInt("datId");
        String scope = object.getString("datScope");
        //删除与item连接中间表
        int result;
        result = diagnosisTemplateMedicineMapper.deleteBydatId(datId);
        if (scope.equals("科室")) {
            //删除与科室相连中间表
            result = diagnosisTemplateDepartmentMapper.deleteBydatId(datId);
        } else if (scope.equals("个人")) {
            //删除与个人相连中间表
            result = diagnosisTemplateUserMapper.deleteBydatId(datId);
        }
        //删除模板表中数据
        result = diagnosisTemplateMapper.deleteByPrimaryKey(datId);
        return result == 1;

    }

    public boolean insert(JSONObject object) {

        DiagnosisTemplate diagnosisTemplate = new DiagnosisTemplate();
        diagnosisTemplate.setDatName(object.getString("datName"));
        long datTime = object.getInt("datTime") / 1000;
        diagnosisTemplate.setDatTime(datTime);
        String datScope = object.getString("datScope");
        diagnosisTemplate.setDatScope(datScope);
        diagnosisTemplate.setDiaType(object.getString("diaType"));
        int result = diagnosisTemplateMapper.insert(diagnosisTemplate);
        Integer datId = diagnosisTemplate.getDatId();
        JSONArray jsonArray = object.getJSONArray("diagnosisTemplateMedicines");
        List<DiagnosisTemplateMedicine> list1 = (List) JSONArray.toCollection(jsonArray, DiagnosisTemplateMedicine.class);
        //List<JSONObject> list=object.getJSONArray("diagnosisTemplateMedicines");
        if (datScope.equals("个人")) {
            DiagnosisTemplateUser diagnosisTemplateUser = new DiagnosisTemplateUser();
            diagnosisTemplateUser.setDatId(datId);
            diagnosisTemplateUser.setuId(object.getInt("uId"));
            result = diagnosisTemplateUserMapper.insert(diagnosisTemplateUser);
        } else if (datScope.equals("科室")) {
            DiagnosisTemplateDepartment diagnosisTemplateDepartment = new DiagnosisTemplateDepartment();
            diagnosisTemplateDepartment.setDatId(datId);
            diagnosisTemplateDepartment.setdId(object.getString("dId"));
            result = diagnosisTemplateDepartmentMapper.insert(diagnosisTemplateDepartment);
        }
        for (DiagnosisTemplateMedicine d : list1) {
            d.setDatId(datId);
            diagnosisTemplateMedicineMapper.insert(d);
        }
        return result == 1;
    }


    public List<DiagnosisTemplate> selectByCondition(JSONObject object) {
        String diaType = object.getString("diaType");
        String datScope = object.getString("datScope");
        String datName = object.getString("datName");
        int uId = object.getInt("uId");
        switch (datScope) {
            case "科室":
                String dId = object.getString("dId");
                return diagnosisTemplateMapper.selectDiagnosisTemplateBydId(datName, diaType, dId);
            case "个人":
                return diagnosisTemplateMapper.selectDiagnosisTemplateByuId(datName, diaType, uId);
            case "全院":
                return diagnosisTemplateMapper.selectByCondition(datName, "全院", diaType);
            default:
                DiagnosisTemplate e = new DiagnosisTemplate();
                List<DiagnosisTemplate> el = new ArrayList<>();
                List<String> dIdList = departmentUserMapper.selectByuId(uId);
                for (String s : dIdList) {
                    el.addAll(diagnosisTemplateMapper.selectDiagnosisTemplateBydId(datName, diaType, s));
                }
                el.addAll(diagnosisTemplateMapper.selectDiagnosisTemplateByuId(datName, diaType, uId));
                el.addAll(diagnosisTemplateMapper.selectByCondition(datName, "全院", diaType));
                return el;
        }
    }

    public DiagnosisTemplate checkDetail(JSONObject object) {
        Integer datId = object.getInt("datId");
        DiagnosisTemplate e = diagnosisTemplateMapper.selectDiagnosisTemplateBydatId(datId);
        e.setMedicines(diagnosisTemplateMapper.selectMedicineBydatId(datId));
        if (e.getDatScope().equals("科室")) {
            e.setDepartment(departmentMapper.getDepartmentBydId(diagnosisTemplateDepartmentMapper.getDId(datId)));
        }
        return e;
    }


    public int updateByPrimaryKeySelective(DiagnosisTemplate record) {
        return diagnosisTemplateMapper.updateByPrimaryKeySelective(record);
    }

    public int updateDiagnosisTemplateMedicine(DiagnosisTemplateMedicine m) {
        return diagnosisTemplateMedicineMapper.updateBydatIdAndmId(m);
    }
}
