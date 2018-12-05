/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: LyApiGateway
 * Author:   Song
 * Date:     2018/11/25 19:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Song
 * @create 2018/11/25
 * @since 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class LyApiGateway {
    public static void main(String[] args) {
        SpringApplication.run(LyApiGateway.class,args);
    }
}