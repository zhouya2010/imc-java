package com.yundian.imc.common.converter;

import com.yundian.imc.common.enums.StationTypeEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class StationTypeConverter implements AttributeConverter<StationTypeEnum, Integer> {
    @Override
    public Integer convertToDatabaseColumn(StationTypeEnum stationType) {
        return stationType.getValue();
    }

    @Override
    public StationTypeEnum convertToEntityAttribute(Integer integer) {
        return StationTypeEnum.fromValue(integer);
    }
}
