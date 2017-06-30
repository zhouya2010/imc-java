package com.yundian.imc.service.impl;

import com.yundian.imc.common.base.BaseServiceImpl;
import com.yundian.imc.dao.PoleDao;
import com.yundian.imc.entity.Pole;
import com.yundian.imc.service.PoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PoleServiceImpl  extends BaseServiceImpl<Pole, Long> implements PoleService {
    @Autowired
    private PoleDao poleDao;

    @Override
    public Page<Pole> searchPole(String poleId, Pageable pageable) {
        return poleDao.findAllByDelFlagFalseAndPoleIdContains(poleId,pageable);
    }
}
