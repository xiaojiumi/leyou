/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: LyItemService
 * Author:   Song
 * Date:     2018/11/25 20:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

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
@MapperScan("com.leyou.item.mapper")
public class LyItemService {
    public static void main(String[] args) {
        SpringApplication.run(LyItemService.class,args);
    }
}