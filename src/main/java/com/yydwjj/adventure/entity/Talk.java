package com.yydwjj.adventure.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class Talk {
    private int msgId;
    private int userNameId;
    private int toNameId;
    private String userName;
    private String ToName;
    private String msg;
    private String createTime;


}