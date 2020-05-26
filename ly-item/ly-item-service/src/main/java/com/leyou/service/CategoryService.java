package com.leyou.service;

import com.leyou.dao.CategoryMapper;
import com.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    public List<Category> findcategory(Category category){
        return    categoryMapper.select(category);
    }

    //测试
    public Category findCate(int id){
        return categoryMapper.findCate(id);
    }

    //添加商品分类
    public void cateGoryAdd(Category category) {
        categoryMapper.insertSelective(category);

    }
    //修改商品分类
    public void updateCategory(Category category){
        categoryMapper.updateByPrimaryKey(category);
    }

    public void deleteById(int id) {
        categoryMapper.deleteByPrimaryKey(id);
    }
}
