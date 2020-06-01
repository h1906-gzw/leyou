package com.leyou.search.controller;

import com.leyou.common.PageResult;
import com.leyou.search.Item.Goods;
import com.leyou.search.pojo.SearchRequest;
import com.leyou.search.repository.GoodsRepository;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {

     @Autowired
    GoodsRepository goodsRepository;

    @RequestMapping("/page")
    public PageResult<Goods> page(@RequestBody SearchRequest searchRequest){

         //es中查询
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        //构造添加
        builder.withQuery(QueryBuilders.matchQuery("all",searchRequest.getKey()).operator(Operator.AND));
        //构造分页
        builder.withPageable(PageRequest.of(searchRequest.getPage()-1,searchRequest.getSize()));

        Page<Goods> search= goodsRepository.search(builder.build());
        //org.springframework.data.domain.Page<Goods> search = goodsRepository.search(builder.build());

        return new PageResult<Goods>(search.getTotalElements(),search.getContent(),search.getTotalPages());
    }
}
