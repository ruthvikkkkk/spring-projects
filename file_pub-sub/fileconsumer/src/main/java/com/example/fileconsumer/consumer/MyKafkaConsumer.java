package com.example.fileconsumer.consumer;

import com.example.fileconsumer.entity.OrderDto;
import com.example.fileconsumer.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

@Component
@KafkaListener(id = "myConsumer", topics = "OrderTopic", groupId = "group_id")
public class MyKafkaConsumer {

    @Autowired
    OrderRepository orderRepository;

    int count;
    int numberOfMessagesReceived;

    int messagesToReceive;

    @Autowired
    KafkaListenerEndpointRegistry registry;

    public MyKafkaConsumer(){
        //this.count = orderRepository.findAll().size();
        this.numberOfMessagesReceived = 0;
        this.messagesToReceive = 0;
    }
    @PostConstruct
    void init(){
        this.count = getRepoCount();
        //this.i = 0;
    }

    private int getRepoCount(){
        return orderRepository.findAll().size();
    }

    @KafkaHandler
    public void handleOrder(OrderDto order){

        System.out.println(this.numberOfMessagesReceived++);

        ObjectMapper mapper = new ObjectMapper();
        synchronized (MyKafkaConsumer.class) {
            OrderDto orderEntity = null;
            orderRepository.save(order);

            if((getRepoCount()) == (this.messagesToReceive + this.count)){
                    System.out.println("prev - " + this.count + "\nnow -" + orderRepository.count());
                    System.out.println("Finished");
            }


//            try {
//                //orderEntity = mapper.readValue(order, OrderDto.class);
//
//
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }finally {
//                if((getRepoCount()) == (this.numberOfMessagesReceived + this.count)){
//                    System.out.println("prev - " + this.count + "\nnow -" + orderRepository.count());
//                    System.out.println("Finished");
//                }
//            }
        }
    }

//    @KafkaListener(topics = "__consumer_offsets")
//    public void consumeOffset(){
//
//    }

    @KafkaHandler
    public void handleInteger(Integer count){
        this.messagesToReceive = count;
    }
    public String addToPG(File file){

        try {
            synchronized (MyKafkaConsumer.class) {
                CSVReader csvReader = new CSVReader(new FileReader(file));
                List<String[]> values = csvReader.readAll().stream().skip(1).collect(Collectors.toList());
                return orderRepository.saveAll(values.stream()
                        .map(strings ->
                                new OrderDto(Long.parseLong(strings[0]), Integer.parseInt(strings[1]), Integer.parseInt(strings[2])))
                        .collect(Collectors.toList()))
                        .toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
