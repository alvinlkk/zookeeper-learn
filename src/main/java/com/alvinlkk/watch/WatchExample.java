package com.alvinlkk.watch;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Watch的例子
 *
 * @author alvinkk
 * @create 2018-08-24 10:22
 **/
public class WatchExample implements Watcher{

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("watchClass" + this.getClass());
        System.out.println("path:" + watchedEvent.getPath());
        System.out.println("state:" + watchedEvent.getState());
        System.out.println("type:" + watchedEvent.getType());
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        WatchExample wx = new WatchExample();
        ZooKeeper zk = new ZooKeeper("localhost:2181", 10000, wx);
        zk.getChildren("/zktest", true);    //false表示不使用watch监听, true表示使用默认的监听， zk的watcher注册一次之后就会失效，如还要监听，需要重新注册
        Thread.sleep(3000000);
    }
}
