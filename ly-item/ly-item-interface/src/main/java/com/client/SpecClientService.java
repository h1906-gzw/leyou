package com.client;

import com.pojo.SpecParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@RequestMapping("specParm")
public interface SpecClientService {
    @RequestMapping("paramsByCid")
    public List<SpecParam> findSpecParamBycidAndSearching(@RequestParam("cid") Long cid);
}
