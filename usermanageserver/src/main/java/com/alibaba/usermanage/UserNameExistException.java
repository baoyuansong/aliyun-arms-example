package com.alibaba.usermanage;

public class UserNameExistException extends Exception {
    public String toString(){
        return "UserNameExist";
    }
}
