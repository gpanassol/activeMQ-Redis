package br.com.cadmus.processing.redis;

import redis.clients.jedis.Jedis;

public class CacheRedis {

    public final String KEY_CACHE_LIST = "lista.pedidos.processados";

    public void sendCacheRedis(String json){
        Jedis jedis = new Jedis();
        jedis.lpush(KEY_CACHE_LIST, json);
        jedis.close();
    }

    public void showListCacheAll(){
        Jedis jedis = new Jedis();
        System.out.println( jedis.lrange(KEY_CACHE_LIST, 0, -1) );
        jedis.close();
    }

    public void showListCache(int start, int stop){
        Jedis jedis = new Jedis();
        jedis.lrange(KEY_CACHE_LIST, start , stop);
        jedis.close();
    }
}
