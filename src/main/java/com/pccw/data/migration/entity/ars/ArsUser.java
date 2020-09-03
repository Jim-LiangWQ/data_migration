package com.pccw.data.migration.entity.ars;

import com.pccw.data.migration.constants.DataSourceSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
/**
 * @author: Created by Jim@80992399 on 2020-08-06 15:24
 **/
@Entity
@Table(name = "SYSTEM_USER", schema = DataSourceSchema.SCHEMA_GOLD_ARS)
public class ArsUser {

    public static final String STATUS_ACTIVE = "A";
    public static final String STATUS_DISABLED = "N";

    @Id
    //@SequenceGenerator(name = "SystemUserIdGenerator", sequenceName = "SYSTEM_USER_ID_SEQ", initialValue = 1, allocationSize = 1)
    //@GeneratedValue(generator = "SystemUserIdGenerator", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DISPLAY_NAME", nullable = false)
    private String displayName;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "HASHED_PASSWORD", nullable = false)
    private String hashedPassword;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "CREATE_TIMESTAMP", nullable = false)
    private Date createTimestamp;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Date updateTimestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public String toString(){
        return "id:" + this.getId() + "\n"
                + "display name:" + this.getDisplayName() + "\n"
                + "id:" + this.getUsername() + "\n"
                + "id:" + this.getStatus() + "\n";
    }
}
