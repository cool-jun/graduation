package com.hj.aftersaleservice.service;

import com.hj.aftersaleservice.domain.DataDictionary;

import java.util.List;

public interface DataDictionaryService {
    List<DataDictionary> getDataDictionaryList(String typeCode);
}
