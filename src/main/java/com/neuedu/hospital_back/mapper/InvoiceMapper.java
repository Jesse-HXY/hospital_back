package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.ExaminationApplication;
import com.neuedu.hospital_back.po.Invoice;
import com.neuedu.hospital_back.po.Medicine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvoiceMapper {

    int getInvoiceCountByPostDId(@Param("postDId") String postDId, @Param("beginTime") Long beginTime, @Param("endTime") Long endTime);

    int getInvoiceCountBydId(@Param("dId") String dId, @Param("beginTime") Long beginTime, @Param("endTime") Long endTime);

    int getInvoiceCountByuId(@Param("uId") Integer uId, @Param("beginTime") Long beginTime, @Param("endTime") Long endTime);

    int deleteByPrimaryKey(String iId);

    List<String> selectIId(@Param("cId") Integer cId, @Param("beginTime") Long beginTime, @Param("endTime") Long endTime, @Param("iStatus") String iStatus);

    int insert(Invoice record);

    int update(Invoice record);

    int getNowIId(String profix);

    List<Invoice> selectByCondition(Invoice invoice);

    void insertInvoice(@Param("iId") String iId, @Param("iStatus") String iStatus);

    int updateInvoice(@Param("iId") String iId, @Param("iStatus") String iStatus);

    void insertConnection(@Param("originaliId") String originaliId, @Param("newIId") String newIId);

    List<ExaminationApplication> selectExaminationApplicationByiId(String iId);

    List<Medicine> selectMedicineByiId(String iId);

    List<String> getCancelledInvoice(@Param("cId") Integer cId, @Param("beginTime") Long beginTime, @Param("endTime") Long endTime);
}