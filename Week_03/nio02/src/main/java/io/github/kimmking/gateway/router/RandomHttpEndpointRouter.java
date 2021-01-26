package io.github.kimmking.gateway.router;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomHttpEndpointRouter implements HttpEndpointRouter {
    String algorithm = System.getProperty("algorithm", "random");
    String proxyServers = System.getProperty("proxyServers","http://localhost:8801,http://localhost:8802,http://localhost:8803");
    List<String> urls = Arrays.asList(proxyServers.split(",")).stream().map(this::formatUrl).collect(Collectors.toList());
    List<Integer> weights = Arrays.asList(1, 2, 3);
    private static Integer pos = 0;

    private String formatUrl(String backend) {
        return backend.endsWith("/")?backend.substring(0,backend.length()-1):backend;
    }

    @Override
    public String route() {
        int size = urls.size();
        int index = 0;
        if (algorithm.equals("random")) {
            index = random(size);
        }else if (algorithm.equals("round")) {
            index = round(size);
        }else if (algorithm.equals("weight")) {
            return weight(size);
        }
        return urls.get(index);
    }

    @Override
    public int random(int size) {
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt(size);
    }

    @Override
    public int round(int size) {
        synchronized (pos) {
            if (pos >= size) {
                pos = 0;
            } else {
                pos++;
            }
        }
        return pos;
    }

    @Override
    public String weight(int size) {
        List<String> urlList = new ArrayList<>();
        for (int i = 0; i < urls.size(); i++) {
            for (int j = 0; j < weights.get(i); j++) {
                urlList.add(urls.get(i));
            }
        }
        return urlList.get(random(urlList.size()));
    }
}
