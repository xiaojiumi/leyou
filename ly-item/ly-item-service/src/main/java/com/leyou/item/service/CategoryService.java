/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CategoryService
 * Author:   Song
 * Date:     2018/12/2 14:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Song
 * @create 2018/12/2
 * @since 1.0.0
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryByPid(Long pid) {
        Category t=new Category();
        t.setParentId(pid);
        return  this.categoryMapper.select(t);
    }
}