package com.xerotech.funcx.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author XJC-git
 * @since 2023-02-05
 */
@TableName("user_login")
@ApiModel(value = "UserLogin对象", description = "")
public class UserLogin implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private String accountName;

    private String accountPassword;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
            "userId=" + userId +
            ", accountName=" + accountName +
            ", accountPassword=" + accountPassword +
        "}";
    }
}
