package com.xerotech.funcx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value = "Interface对象", description = "")
public class Interface implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "interface_id", type = IdType.AUTO)
    private Integer interfaceId;

    private String interfaceUrl;

    private String interfaceName;

    public Integer getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Integer interfaceId) {
        this.interfaceId = interfaceId;
    }
    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }
    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    @Override
    public String toString() {
        return "Interface{" +
            "interfaceId=" + interfaceId +
            ", interfaceUrl=" + interfaceUrl +
            ", interfaceName=" + interfaceName +
        "}";
    }
}
