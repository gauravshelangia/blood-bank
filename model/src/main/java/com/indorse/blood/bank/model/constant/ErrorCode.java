package com.indorse.blood.bank.model.constant;

public enum  ErrorCode {
    NEW_MEMBER_WITH_MEMBER_ID("new.member.with.id.error"),
    CRUD_EMPTY_ENTITY_ERROR("crud.empty.entity.error"),
    BLOOD_BANK_NOT_EXIST("blood.bank.not.exists"),

    RESOURCE_NOT_FOUND("resource.not.found.error");




    private String messageKey;

    ErrorCode(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getCode() {
        return this.name();
    }

    public String getMessageKey() {
        return this.messageKey;
    }
}
