package com.hj.aftersaleservice.dao;

import com.hj.aftersaleservice.domain.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataDictionaryMapper {
    List<DataDictionary> getDataDictionaryList(@Param(value = "typeCode") String typeCode);
}
