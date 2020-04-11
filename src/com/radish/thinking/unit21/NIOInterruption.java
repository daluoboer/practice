package com.radish.thinking.unit21;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/22
 */

class NIOBlocked implements Runnable{
    private final SocketChannel sc;

    public NIOBlocked(SocketChannel sc) {
        this.sc = sc;
    }

    @Override
    public void run() {
        try {
            System.out.println("Waiting for read() in " + this);
            sc.read(ByteBuffer.allocate(1));
        } catch (ClosedByInterruptException e) {
            System.out.println("ClosedByInterruptedException");
        } catch (AsynchronousCloseException e){
            System.out.println("AsynchronousCloseException");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Exiting NIOBlocked.run() " + this);
    }
}
public class NIOInterruption {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        InetSocketAddress isa = new InetSocketAddress("localhost", 8080);
        SocketChannel sc1 = SocketChannel.open(isa);
        SocketChannel sc2 = SocketChannel.open(isa);
        Future<?> f = exec.submit(new NIOBlocked(sc1));
        exec.execute(new NIOBlocked(sc2));
        //上面俩是不一样的，但是我也不知道为啥不一样...因为执行的方法不一样？啊！跟上头的代码没有关系，则两种执行方法应该没有太大区别？除了有一个有返回值
        exec.shutdown();
        TimeUnit.SECONDS.sleep(1);
        //没错！玄机在这里呀！如果把下面改成sc1.close(),那这俩的输出就一样啦。因为有一个是关闭线程，一个是关闭资源嘛~
        f.cancel(true);
        TimeUnit.SECONDS.sleep(1);
        sc2.close();
    }
}
