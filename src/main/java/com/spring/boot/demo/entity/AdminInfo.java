package com.spring.boot.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by caigen on 2018/1/30.
 */
@Data
public class AdminInfo {
    private Integer id;
    private String email;
    private String name;
    private Integer type;
    @JsonIgnore
    private String lastSessionKey;
    @JsonIgnore
    private LocalDateTime lastLoginTime;

}
