package com.yundian.imc.service;

import com.yundian.imc.common.base.BaseService;
import com.yundian.imc.entity.Pole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * Created by dell on 2017/6/30.
 */
public interface PoleService extends BaseService<Pole, Long> {
    Page<Pole> searchPole(String poleId,Pageable pageable);
}
