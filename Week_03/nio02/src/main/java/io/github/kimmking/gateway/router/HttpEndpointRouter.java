package io.github.kimmking.gateway.router;

public interface HttpEndpointRouter {
    
    String route();

    int random(int size);

    int round(int size);

    String weight(int size);

    // Load Balance
    // Random
    // RoundRibbon 
    // Weight
    // - server01,20
    // - server02,30
    // - server03,50
    
}
