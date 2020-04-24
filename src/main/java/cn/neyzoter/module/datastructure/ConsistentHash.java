package cn.neyzoter.module.datastructure;

import java.util.*;

/**
 * consistent hash
 * @author Neyzoter Song
 * @date 2020-2-12
 */
public class ConsistentHash {
    // virtual nodes num
    public final static int VIRTUAL_NODES = 3;
    // servers
    public final static String[] servers = {"127.0.0.2","127.0.0.3","127.0.0.4","127.0.0.5"};

    public static List<String> realNodes = new LinkedList<>();
    /**
     * sorted map
     */
    public static SortedMap<Integer, String> server_map = new TreeMap<>();

    static {
        for (String server : servers) {
            realNodes.add(server);
            for (int i = 0 ; i < VIRTUAL_NODES; i ++) {
                String virtualNodeName = "VN_" + i + "_" + server;
                int hashcode = getHash(virtualNodeName);
                server_map.put(hashcode, virtualNodeName);

            }
        }
        for (Map.Entry<Integer, String> entry : server_map.entrySet()) {
            System.out.println(String.format("%s  Hashcode : %d", entry.getValue(), entry.getKey()));
        }
    }

    // hashcode func is not fit
    // so made this hash func
    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }
    /**
     * get server by data's key
     * @param key
     */
    public static String getServer (String key) {
        int hashcode = getHash(key);
        System.out.print(String.format("Key : %s hash : %d", key, hashcode));
        SortedMap<Integer,String> sortedMap = server_map.tailMap(hashcode);
        int firstHash;
        String firstServer;
        if (sortedMap.isEmpty()) {
            firstHash = server_map.firstKey();
            firstServer = server_map.get(firstHash);
        } else {
            firstHash = sortedMap.firstKey();
            firstServer = sortedMap.get(firstHash);
        }
        System.out.print(String.format(" firstHash : %d firstServer : %s\n", firstHash, firstServer));
        return firstServer;
    }
    public static void main(String[] args) {
        String[] keys = {"name", "value", "age"};
        for (String key : keys) {
            ConsistentHash.getServer(key);
        }
    }
}
