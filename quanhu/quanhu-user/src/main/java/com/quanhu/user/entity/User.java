/*create by chens at 2018-04-21  */
package com.quanhu.user.entity;

import com.quanhu.base.entity.BaseEntity;

/**
 * description:User实体类
 */
public class User extends BaseEntity{
    private String  nickName;
    private String  userName;
    private String  passWord;
    private Integer phoneNumber;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
