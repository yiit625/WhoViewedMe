package com.example.Assignment.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(
        autoApply = true
)
public class EnumStatusConverter implements AttributeConverter<EnumStatus, Integer> {
    public EnumStatusConverter() {
    }

    public Integer convertToDatabaseColumn(EnumStatus attribute) {
        return attribute == null ? null : attribute.getVal();
    }

    public EnumStatus convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : EnumStatus.get(dbData);
    }
}
