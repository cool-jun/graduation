package com.hj.aftersaleservice.service.impl;

import com.hj.aftersaleservice.dao.DataDictionaryMapper;
import com.hj.aftersaleservice.domain.DataDictionary;
import com.hj.aftersaleservice.service.DataDictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Resource
    private DataDictionaryMapper dataDictionaryMapper;

    @Override
    public List<DataDictionary> getDataDictionaryList(String typeCode) {
        return dataDictionaryMapper.getDataDictionaryList(typeCode);
    }
}
