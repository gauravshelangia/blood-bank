package com.indorse.blood.bank.model.constant;

public enum BloodSubType {
    WHOLE("WHOLE", "whole"),
    RBC("RBC", "Red Blood Cells"),
    FFP("FFP", "Red Blood Cells"),
    PC("PC", "Platelet concentrate");

    private String type;
    private String description;

    BloodSubType(String type, String description) {
        this.type= type;
        this.description = description;
    }
}
