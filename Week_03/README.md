## Netty-gateway增强
#### Route负载均衡
实现支持random、round、weight三种算法。

#### Filter增强
增加block uri列表，禁止转发某些请求，同理提前IP可以实现类似黑名单机制。
```java
    private static List<String> blockUris = Arrays.asList("/test/", "/admin/");
```


## Netty启动注释
```java
    public void run() throws Exception {

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);  //初始化用于Acceptor的主"线程池"；
        EventLoopGroup workerGroup = new NioEventLoopGroup(16);  //初始化用于连接及I/O工作的从"线程池"；

        try {
            ServerBootstrap b = new ServerBootstrap();  //初始化ServerBootstrap实例，此实例是netty服务端应用开的入口
            b.option(ChannelOption.SO_BACKLOG, 128)  //配置 ServerSocketChannel 的选项
                    .childOption(ChannelOption.TCP_NODELAY, true)  //配置子通道也就是SocketChannel的选项
                    .childOption(ChannelOption.SO_KEEPALIVE, true) 
                    .childOption(ChannelOption.SO_REUSEADDR, true)
                    .childOption(ChannelOption.SO_RCVBUF, 32 * 1024)  //缓冲区优化
                    .childOption(ChannelOption.SO_SNDBUF, 32 * 1024)
                    .childOption(EpollChannelOption.SO_REUSEPORT, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);

            b.group(bossGroup, workerGroup)  //通过ServerBootstrap的group方法，设置主从"线程池"；
                    .channel(NioServerSocketChannel.class)  //指定通道channel的类型，由于是服务端，故而是NioServerSocketChannel；
                    .handler(new LoggingHandler(LogLevel.DEBUG))  //设置ServerSocketChannel的处理器
                    .childHandler(new HttpInboundInitializer(this.proxyServers));  //设置子通道

            Channel ch = b.bind(port).sync().channel();  //绑定并侦听某个端口
            System.out.println("开启netty http服务器，监听地址和端口为 http://127.0.0.1:" + port + '/');
            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
```
