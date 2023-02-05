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
@TableName("rel_interface_role")
@ApiModel(value = "RelInterfaceRole对象", description = "")
public class RelInterfaceRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer relId;

    private Integer interfaceId;

    private Integer roleId;

    private Integer enable;

    public Integer getRelId() {
        return relId;
    }

    public void setRelId(Integer relId) {
        this.relId = relId;
    }
    public Integer getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Integer interfaceId) {
        this.interfaceId = interfaceId;
    }
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "RelInterfaceRole{" +
            "relId=" + relId +
            ", interfaceId=" + interfaceId +
            ", roleId=" + roleId +
            ", enable=" + enable +
        "}";
    }
}
