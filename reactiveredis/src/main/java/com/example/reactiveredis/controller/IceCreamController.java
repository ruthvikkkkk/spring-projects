package com.example.reactiveredis.controller;

import com.example.reactiveredis.entity.IceCream;
import com.example.reactiveredis.service.IceCreamCacheService;
import com.example.reactiveredis.service.IceCreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/iceCream")
public class IceCreamController {

    @Autowired
    IceCreamCacheService iceCreamService;

    @GetMapping("/all")
    public ResponseEntity<Flux<IceCream>> getAll(){
        return new ResponseEntity<>(iceCreamService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/flavor/{flavor}")
    public ResponseEntity<Mono<IceCream>> getoneByFlavor(@PathVariable String flavor){
        return new ResponseEntity<>(iceCreamService.getDetailsByFlavor(flavor), HttpStatus.OK);
    }

//    @PatchMapping("/updateCost/{flavor}/{cost}")
//    public ResponseEntity<Mono<Void>> updateCost(@PathVariable("flavor") String flavor, @PathVariable("cost") Double cost){
//        return new ResponseEntity<>(iceCreamService.updateCost(flavor, cost), HttpStatus.OK);
//    }

//    @PatchMapping("/updateQuantity/{flavor}/{quantity}")
//    public ResponseEntity<Mono<Void>> updateQuantity(@PathVariable("flavor") String flavor, @PathVariable("quantity") Integer quantity){
//        return new ResponseEntity<>(iceCreamService.updateQuantity(flavor, quantity), HttpStatus.OK);
//    }

    @PostMapping("/addOrUpdate")
    public ResponseEntity<Mono<Boolean>> addIceCream(@RequestBody IceCream iceCream){
        return new ResponseEntity<>(iceCreamService.addOrUpdateIceCream(iceCream), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{flavor}")
    public ResponseEntity<Mono<Void>> delete(@PathVariable String flavor){
        return new ResponseEntity<>(iceCreamService.deleteIceCream(flavor), HttpStatus.OK);
    }
}
