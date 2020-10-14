package com.example.Assignment.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonFormat(
        shape = Shape.OBJECT
)
@ApiModel(
        value = "EnumStatus",
        description = "EnumStatus Enumeration"
)
public enum EnumStatus  {
    ACTIVE(1, "ACTIVE"),
    PASSIVE(0, "PASSIVE");

    private int val;
    private String desc;

    public static EnumStatus match(String val, EnumStatus def) {
        EnumStatus[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            EnumStatus enm = var2[var4];
            if (enm.name().equalsIgnoreCase(val)) {
                return enm;
            }
        }

        return def;
    }

    public static EnumStatus match(Integer val, EnumStatus def) {
        if (val == null) {
            return def;
        } else {
            EnumStatus[] var2 = values();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                EnumStatus enm = var2[var4];
                if (val.equals(enm.getVal())) {
                    return enm;
                }
            }

            return def;
        }
    }

    public static EnumStatus get(String val) {
        return match((String)val, (EnumStatus)null);
    }

    public static EnumStatus get(Integer val) {
        return match((Integer)val, (EnumStatus)null);
    }

    public boolean eq(String val) {
        return this.name().equalsIgnoreCase(val);
    }

    public boolean eq(EnumStatus val) {
        return val == null ? false : this.eq(val.name());
    }

    @ApiModelProperty(
            value = "Codes",
            allowableValues = "ACTIVE,PASSIVE",
            example = "ACTIVE"
    )
    public String getCode() {
        return this.name();
    }

    private EnumStatus(final int val, final String desc) {
        this.val = val;
        this.desc = desc;
    }

    private EnumStatus() {
    }

    public int getVal() {
        return this.val;
    }

    public String getDesc() {
        return this.desc;
    }
}