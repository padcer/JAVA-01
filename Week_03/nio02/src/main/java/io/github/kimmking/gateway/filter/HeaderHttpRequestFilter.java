package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;

import java.util.Arrays;
import java.util.List;

import static io.netty.handler.codec.http.HttpResponseStatus.METHOD_NOT_ALLOWED;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

public class HeaderHttpRequestFilter implements HttpRequestFilter {

    private static List<String> blockUris = Arrays.asList("/test/", "/admin/");

    public static boolean block(String uri) {
        for (String pattern : blockUris) {
            if (uri.startsWith(pattern)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().set("mao", "soul");
        fullRequest.headers().set("traceId", "xxxxxx");
        if (block(fullRequest.uri())) {
            FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, METHOD_NOT_ALLOWED);
            ctx.write(response);
            ctx.flush();
            return false;
        }
        return true;
    }
}
