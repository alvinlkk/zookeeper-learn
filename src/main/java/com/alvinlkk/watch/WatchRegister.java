package com.alvinlkk.watch;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * watcher 的重复注册
 * watcher设置后，一旦触发一次即会失效，如果需要一直监听，就需要再次注册
 * @author alvinkk
 * @create 2018-08-24 10:54
 **/
public class WatchRegister {

    private ZooKeeper zooKeeper;

    public WatchRegister(WatchExample watchExample) {
        try {
            zooKeeper = new ZooKeeper("localhost:2181", 10000, watchExample);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testWatchDisabled() throws KeeperException, InterruptedException {
        WatchExample1 we1 = new WatchExample1();
        we1.setZk(zooKeeper);
        zooKeeper.getData("/zktest", we1, null);
    }

    public static void main(String[] args) throws KeeperException, InterruptedException {
        WatchExample we = new WatchExample();
        WatchRegister register = new WatchRegister(we);
        register.testWatchDisabled();
        Thread.sleep(1000000);
    }
}
