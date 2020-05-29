package com.leyou.search.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "item-service")
public interface SpecClient extends com.client.SpecClientService{
}
