package com.yydwjj.adventure.entity;

import lombok.Getter;
import lombok.Setter;

public class Talk {
    @Setter
    @Getter
    private int msgId;
    @Setter
    @Getter
    private int userNameId;
    @Setter
    @Getter
    private int toNameId;
    @Setter
    @Getter
    private String userName;
    @Setter
    @Getter
    private String toName;
    @Setter
    @Getter
    private String msg;
    @Setter
    @Getter
    private String createTime;
}
