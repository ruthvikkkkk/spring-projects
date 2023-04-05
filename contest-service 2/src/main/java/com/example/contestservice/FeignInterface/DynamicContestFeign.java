package com.example.contestservice.FeignInterface;
import com.example.contestservice.dto.ContestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "dynamicContest", url="http://10.20.5.27:9471")
public interface DynamicContestFeign {
    @PostMapping("/addDynamicContest")
    ContestDTO addDynamicContest(@RequestBody ContestDTO contestDTO);

}
