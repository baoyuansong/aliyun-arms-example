package com.alibaba.usermanage;

public class UserNotExistException extends  Exception {
    public String toString(){
        return "UserNotExist";
    }
}
