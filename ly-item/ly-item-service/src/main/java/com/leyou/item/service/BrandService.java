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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.Category;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

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
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;

    public PageResult<Brand> queryBrandByPage(
            Integer page, Integer rows, String sortBy, Boolean desc, String key) {
       //分页
        PageHelper.startPage(page,rows);

        Example example=new Example(Brand.class);
        //排序
        if(StringUtils.isNoneBlank(sortBy)){
            example.setOrderByClause(sortBy +  (desc ? " DESC " : " ASC "));
        }
        //查询
        if(StringUtils.isNotBlank(key)) {
            example.createCriteria().orLike("name",  "%" + key + "%")
                    .orEqualTo("letter", key.toUpperCase());
        }
        List<Brand> list=this.brandMapper.selectByExample(example);
        PageInfo<Brand> info = new PageInfo<>(list);
        //返回分页结果
        return  new PageResult<>(info.getTotal(),info.getList());

    }
    @Transactional
    public void save(Brand brand, List<Long> ids) {
        this.brandMapper.insert(brand);
        for (long cid : ids) {
            this.brandMapper.insertCategoryBrand(cid,brand.getId() );
        }

    }
}