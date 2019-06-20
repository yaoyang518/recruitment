package com.yaoyang.recruitment.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yaoyang.recruitment.enumeration.EntityStatus;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体父类
 *
 * @author jimlaren
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @ApiModelProperty(value = "id")
    @JsonProperty
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ApiModelProperty(value = "创建日期")
    @JsonProperty
    private Date createDate = new Date();
    @ApiModelProperty(value = "更新日期")
    @JsonProperty
    private Date updateDate = new Date();
    @ApiModelProperty(value = "状态")
    @JsonProperty
    @Column(length = 8)
    @Enumerated(EnumType.STRING)
    private EntityStatus entityStatus = EntityStatus.ENABLE;

    public EntityStatus getEntityStatus() {
        return this.entityStatus;
    }

    public void setEntityStatus(final EntityStatus status) {
        this.entityStatus = status;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(final Date updateDate) {
        this.updateDate = updateDate;
    }

    @Transient
    @JsonProperty
    public boolean isEnable() {
        return entityStatus != null && entityStatus.equals(EntityStatus.ENABLE);
    }

    @Override
    public boolean equals(final Object obj) {

        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (obj instanceof BaseEntity) {
            final BaseEntity other = (BaseEntity) obj;
            if (other.getId() == null) {
                return false;
            } else {
                return other.getId().equals(this.getId());
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        if (getId() == null) {
            return super.hashCode();
        } else {
            return getId().hashCode();
        }
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", entityStatus=" + entityStatus +
                '}';
    }

    @Transient
    public boolean getEnable() {
        return entityStatus != null && entityStatus.equals(EntityStatus.ENABLE);
    }
    @Transient
    public void setEnable(boolean value) {
        entityStatus = value ? EntityStatus.ENABLE : EntityStatus.DISABLE;
    }
}
