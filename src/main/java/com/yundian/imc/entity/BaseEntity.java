package com.yundian.imc.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BaseEntity<ID extends Serializable> implements Serializable, Cloneable {

//    //总共页数
//    private int pageTotal;
//
//    //页长
//    private int pageLength;
//
//    //当前页码，从0开始
//    private int pagination;
    private ID id;

    @NotNull(message = "是否删除不能为空")
    private boolean delFlag;

    private Date createAt;

    private Date updateAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Column(name = "del_flag")
    public boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(boolean delFlag) {
        this.delFlag = delFlag;
    }

    @Column(name = "create_at")
    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Column(name = "update_at")
    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
