package com.yundian.imc.common.converter;

import com.yundian.imc.common.enums.StationStatusEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class StationStatusConverter implements AttributeConverter<StationStatusEnum,Integer> {
    @Override
    public Integer convertToDatabaseColumn(StationStatusEnum stationStatusEnum) {
        return stationStatusEnum.getValue();
    }

    @Override
    public StationStatusEnum convertToEntityAttribute(Integer value) {
        return StationStatusEnum.fromValue(value);
    }
}
