package com.alvinlkk.watch;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * watcher
 *
 * @author alvinkk
 * @create 2018-08-24 11:02
 **/
public class WatchExample1 implements Watcher {

    private ZooKeeper zk;

    @Override
    public void process(WatchedEvent event) {
        System.out.println("watchClass" + this.getClass());
        System.out.println("path:" + event.getPath());
        System.out.println("state:" + event.getState());
        System.out.println("type:" + event.getType());

        WatchExample1 we1 = new WatchExample1();
        we1.setZk(zk);
        try {
            zk.getData(event.getPath(), we1, null);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ZooKeeper getZk() {
        return zk;
    }

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }
}
