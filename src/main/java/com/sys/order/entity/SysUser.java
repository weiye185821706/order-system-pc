package com.sys.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sys.order.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 *  用户表
 * </p>
 *
 * @author yewei
 * @since 2021-03-11
 */
@TableName("SYS_USER")
@ApiModel(value="SysUser对象", description="用户表")
public class SysUser extends BaseEntity {

    private static final long serialVersionUID=1L;

    @TableField("USER_NAME")
    @ApiModelProperty(value = "用户名")
    private String userName;

    @TableField("PASSWORD")
    @ApiModelProperty(value = "用户密码")
    private String password;

    @TableField("NIKE_NAME")
    @ApiModelProperty(value = "用户昵称")
    private String nikeName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}
