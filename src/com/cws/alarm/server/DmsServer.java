package com.cws.alarm.server;

/**
 * **************************************************************************
 *
 * @说明:
 * @项目名称:
 * @author: tangweibin
 * @创建时间: 2017/6/2.
 * <p>
 * **************************************************************************
 */
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * **************************************************************************
 *
 * @说明:
 * @项目名称:
 * @author: tangweibin
 * @创建时间: 2017/6/1.
 * <p>
 * **************************************************************************
 */
public class DmsServer {
    private static int port = 6668;
    public static void main(String[] args) throws InterruptedException {
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

        ChannelFuture f= bootstrap.bind(port).sync();

        if(f.isSuccess()){

            System.out.println("server start---------------");

        }
    }
}
