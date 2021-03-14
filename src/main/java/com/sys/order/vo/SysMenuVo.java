package com.sys.order.vo;

import com.sys.order.entity.SysMenu;

public class SysMenuVo extends SysMenu {

    private String nikeName; // 用户昵称

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }
}
