package com.progressive.htmlescape.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@NoArgsConstructor
@MappedSuperclass
public class Common {

    private Date createdAt;
    private boolean deleted;
    private String createdBy;

    public Common(String createdBy) {
        this.createdAt = new Date();
        this.deleted = false;
        this.createdBy = createdBy;
    }
}
