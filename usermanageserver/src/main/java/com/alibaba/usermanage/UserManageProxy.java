package com.alibaba.usermanage;


import java.util.concurrent.ConcurrentHashMap;

public class UserManageProxy {
    private ConcurrentHashMap userMap = new ConcurrentHashMap<String, String>();
    public void Login(String userName, String password) throws UserNotExistException, UserNamePasswordError{
        if (userMap.get(userName) == null){
            throw new UserNotExistException();
        }

        if (!userMap.get(userName).equals(password)){
            throw new UserNamePasswordError();
        }
    }

    public void Register(String userName, String password) throws UserNameExistException{
        if (userMap.get(userName) != null){
            throw new UserNameExistException();
        }
        userMap.put(userName, password);
    }
}
