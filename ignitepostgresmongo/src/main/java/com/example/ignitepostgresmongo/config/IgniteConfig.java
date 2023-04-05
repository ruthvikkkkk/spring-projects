package com.example.ignitepostgresmongo.config;

import com.example.ignitepostgresmongo.entity.IgniteUser;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.AtomicConfiguration;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.failure.StopNodeOrHaltFailureHandler;
import org.apache.ignite.internal.IgniteProperties;
import org.apache.ignite.logger.slf4j.Slf4jLogger;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.apache.ignite.springdata20.repository.config.EnableIgniteRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Collections;

@Configuration
@EnableIgniteRepositories
public class IgniteConfig {

    @Bean
    public Ignite igniteInstance(@Autowired IgniteConfiguration igniteConfiguration) {
        //log.info("starting ignite node with configuration {}", igniteConfiguration);

        //IgniteConfiguration igniteConfiguration = new IgniteConfiguration();
        igniteConfiguration.setAutoActivationEnabled(true);
        igniteConfiguration.setActiveOnStart(true);

        Ignition.setClientMode(true);
        Ignite ignite = Ignition.getOrStart(igniteConfiguration);
        return ignite;
    }

    @Bean
    public IgniteConfiguration igniteConfiguration(){

        // basic configuration
        //configuration.setClientMode(true);
//        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
//        ipFinder.setAddresses(Collections.singletonList("127.0.0.1:47500..47509"));
//        configuration.setPeerClassLoadingEnabled(true);
//        configuration.setDiscoverySpi(new TcpDiscoverySpi().setIpFinder(ipFinder));

        return new IgniteConfiguration();
    }
}
