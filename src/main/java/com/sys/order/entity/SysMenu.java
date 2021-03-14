package com.sys.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sys.order.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author yewei
 * @since 2021-03-11
 */
@TableName("SYS_MENU")
@ApiModel(value="SysMenu对象", description="菜单表")
public class SysMenu extends BaseEntity {

    private static final long serialVersionUID=1L;

    @TableField("MENU_NAME")
    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @TableField("MENU_HREF")
    @ApiModelProperty(value = "路由地址")
    private String menuHref;

    @TableField("MENU_LEVEL")
    @ApiModelProperty(value = "菜单层级")
    private String menuLevel;

    @TableField("MENU_ICON")
    @ApiModelProperty(value = "菜单icon")
    private String menuIcon;

    @TableField("PRENT_ID")
    @ApiModelProperty(value = "父级菜单id")
    private Long prentId;

    public Long getPrentId() {
        return prentId;
    }

    public void setPrentId(Long prentId) {
        this.prentId = prentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuHref() {
        return menuHref;
    }

    public void setMenuHref(String menuHref) {
        this.menuHref = menuHref;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "menuName='" + menuName + '\'' +
                ", menuHref='" + menuHref + '\'' +
                ", menuLevel='" + menuLevel + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", prentId='" + prentId + '\'' +
                '}';
    }
}
