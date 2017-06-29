package com.yundian.imc.common.converter;

import com.yundian.imc.common.enums.ConstructionEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class ConstructionConverter implements AttributeConverter<ConstructionEnum,Integer> {
    @Override
    public Integer convertToDatabaseColumn(ConstructionEnum constructionEnum) {
        return constructionEnum.getValue();
    }

    @Override
    public ConstructionEnum convertToEntityAttribute(Integer value) {
        return ConstructionEnum.fromValue(value);
    }
}
