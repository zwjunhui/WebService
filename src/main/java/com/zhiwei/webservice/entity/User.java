package com.zhiwei.webservice.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 用户实体
 * @Author: wyjun
 * @UpdateDate: 2019/7/15 15:14
 * @Version: 1.0
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -5833269104205429035L;
    private Integer id;
    private String userName;
    private String password;
    private Date createTime;
    private String status;
}

