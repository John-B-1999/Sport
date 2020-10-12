package com.example.sportApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    private String  cityGeoKey = "city";

    @Test
    void testZset() {
        String s = redisTemplate.opsForZSet().range("myset",0,10).toString();
        System.out.println(s);
        //排行榜前十
        List<String> list = new ArrayList<>();
        int begin = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ','){
                begin = end;
                end = i;
                list.add(s.substring(begin+1,end).trim());
            }
        }
        list.add(s.substring(end+2,s.length()-1));
        for (String str:list) {
            System.out.println(str);
        }
        redisTemplate.opsForZSet().incrementScore("myset","courseOne",1);
    }

    @Test
    public void testAdd(){
        Long addedNum = redisTemplate.opsForGeo()
                .add(cityGeoKey,new Point(116.405285,39.904989),"北京");
        System.out.println(addedNum);
    }

    @Test
    public void testGeoGet(){
        List<Point> points = redisTemplate.opsForGeo().position(cityGeoKey,"北京","上海","深圳");
        System.out.println(points);
    }

    @Test
    public void testDist(){
        Distance distance = redisTemplate.opsForGeo()
                .distance(cityGeoKey,"北京","上海", RedisGeoCommands.DistanceUnit.KILOMETERS);
        System.out.println(distance);
    }

    @Test
    public void testNearByXY(){
        //longitude,latitude
        Circle circle = new Circle(116.405285,39.904989, Metrics.KILOMETERS.getMultiplier());
        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance().includeCoordinates().sortAscending().limit(5);
        GeoResults<RedisGeoCommands.GeoLocation<String>> results = redisTemplate.opsForGeo()
                .radius(cityGeoKey,circle,args);
        System.out.println(results);
    }

    @Test
    public void testNearByPlace(){
        Distance distance = new Distance(5,Metrics.KILOMETERS);
        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance().includeCoordinates().sortAscending().limit(5);
        GeoResults<RedisGeoCommands.GeoLocation<String>>  results = redisTemplate.opsForGeo()
                .radius(cityGeoKey,"北京",distance,args);
        System.out.println(results);
    }

    @Test
    public void testGeoHash(){
        List<String> results = redisTemplate.opsForGeo()
                .hash(cityGeoKey,"北京","上海","深圳");
        System.out.println(results);
    }
}
