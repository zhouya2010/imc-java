package com.yundian.imc.common.converter;

import com.yundian.imc.common.enums.PoleTypeEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class PoleTypeConverter implements AttributeConverter<PoleTypeEnum,Integer> {
    @Override
    public Integer convertToDatabaseColumn(PoleTypeEnum poleTypeEnum) {
        return poleTypeEnum.getValue();
    }

    @Override
    public PoleTypeEnum convertToEntityAttribute(Integer value) {
        return PoleTypeEnum.fromValue(value);
    }
}
