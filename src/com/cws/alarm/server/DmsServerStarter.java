package com.cws.alarm.server;

import com.jfinal.plugin.IPlugin;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by PC on 2017/5/24.
 */
public class DmsServerStarter implements IPlugin {
    static String serverIp = null;
    static int serverPort =  7778;

    @Override
    public boolean start() {
        EventLoopGroup boss=new NioEventLoopGroup();

        EventLoopGroup worker=new NioEventLoopGroup();

        ServerBootstrap bootstrap=new ServerBootstrap();

        bootstrap.group(boss,worker);

        bootstrap.channel(NioServerSocketChannel.class);

        bootstrap.option(ChannelOption.SO_BACKLOG, 128);

        //通过NoDelay禁用Nagle,使消息立即发出去，不用等待到一定的数据量才发出去

        bootstrap.option(ChannelOption.TCP_NODELAY, true);

        //保持长连接状态

        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);

        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {

            @Override

            protected void initChannel(SocketChannel socketChannel) throws Exception {

                ChannelPipeline p = socketChannel.pipeline();
                p.addLast(new DmsServerHandler());

            }

        });

        ChannelFuture f= null;
        try {
            f = bootstrap.bind(serverPort).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(f.isSuccess()){

            System.out.println("server start---------------");
            return true;

        }
        else
            return  false;
    }

    @Override
    public boolean stop() {
        return false;
    }
}
