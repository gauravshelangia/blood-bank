package com.indorse.blood.bank.model.constant;

public enum  ErrorCode {
    NEW_MEMBER_WITH_MEMBER_ID("new.member.with.id"),
    NEW_MEMBER_EMPTY("new.member.empty"),

    RESOURCE_NOT_FOUND("resource.not.found");




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
