package com.mb.moviecatalogservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This is utility to have deal with services programatically
 *
 */
@Component
public class DiscoveryClientComponent {

    @Autowired
    private DiscoveryClient discoveryClient;

    public List<ServiceInstance> getServiceInstances(String serviceId) {
        return discoveryClient.getInstances(serviceId);
    }

}
