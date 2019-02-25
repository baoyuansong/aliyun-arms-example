package com.aliyun.sdk.hitsdb;

import java.io.IOException;

import com.aliyun.hitsdb.client.HiTSDB;
import com.aliyun.hitsdb.client.HiTSDBClientFactory;
import com.aliyun.hitsdb.client.HiTSDBConfig;
import com.aliyun.hitsdb.client.value.request.Point;

public class example {
    public static void main(String[] args) throws InterruptedException, IOException {
        // 创建 HiTSDB 对象
        HiTSDBConfig config = HiTSDBConfig.address("ts-uf6fm312kg56jo5v5.hitsdb.tsdb.aliyuncs.com", 8242).config();
        HiTSDB tsdb = HiTSDBClientFactory.connect(config);
        // 构造数据并写入 HiTSDB
        for (int i = 0; i < 3600; i++) {
            long currentTime = System.currentTimeMillis();
            Point point = Point.metric("test").tag("V", "1").value(currentTime, 1).build();
            Point point1 = Point.metric("test").tag("V1", "2").value(currentTime + 1, 2).build();
            Point point2 = Point.metric("test").tag("V", "3").value(currentTime, 3).build();
            Point point3 = Point.metric("test").tag("V1", "4").value(currentTime, 4).build();
            Thread.sleep(1000);  // 1秒提交1次
            tsdb.put(point);
            tsdb.put(point1);
            tsdb.put(point2);
            tsdb.put(point3);
        }
        // 安全关闭客户端，以防数据丢失。
        System.out.println("关闭");
        tsdb.close();
    }
}
