package com.leyou.controller;

import com.leyou.service.SpecGroupService;
import com.pojo.SpecGroup;
import com.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spec")
public class SpecController {
    @Autowired
    private SpecGroupService specGroupService;

    /**
     * 查询规格参数组列表
     * @return
     */
    @RequestMapping("groups/{cid}")
    public List<SpecGroup> findSpecGroupList(@PathVariable("cid") Long cateGoryId){
        return specGroupService.findSpecGroupList(cateGoryId);
    }

    /**
     * 保存或修改商品规格组
     * @param specGroup
     */
    @RequestMapping("group")
    public void saveSpecGroup(@RequestBody SpecGroup specGroup){
        //判断是修改还是新增
        if(specGroup.getId()==null){
            specGroupService.saveSpecGroup(specGroup);
        }else {
            specGroupService.updateSpecGroup(specGroup);
        }
    }

    @RequestMapping("group/{id}")
    public void deleteBySpecGroupId(@PathVariable("id") Long id){
        specGroupService.deleteBySpecGroupId(id);
    }

    /**
     * 根据组id查询组参数列表
     * @param gid
     * @return
     */
    @RequestMapping("params")
    public List<SpecParam> findSpecParam(@RequestParam("gid") Long gid){

        return specGroupService.findSpecParam(gid);
    }

}
