package com.vince.service;

import com.vince.bean.Clothes;
import com.vince.utils.BusinessException;

import java.util.List;

/**
 * Created by vince on 2017/7/20.
 */
public interface ClothesService {
    public List<Clothes> list()throws BusinessException;
    public Clothes findById(String cid)throws BusinessException;
    public void update()throws BusinessException;
}
