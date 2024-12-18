package com.java_basic.collection.deque.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MemberRepository {

    private static Map<String, Member> map = new HashMap<>();

    public void save(Member member) {
        map.put(member.getId(), member);
    }

    public Member findById(String id) {
        Set<String> strings = map.keySet();
        if (!strings.contains(id)) {
            return null;
        }
        return map.get(id);
    }

    public Member findByName(String name) {
        Set<Map.Entry<String, Member>> entries = map.entrySet();

        for (Map.Entry<String, Member> entry : entries) {
            if (entry.getValue().getName().equals(name)) {
                return map.get(entry.getKey());
            }
        }
        return null;
    }


    public void remove(String id) {
        map.remove(id);
    }
}
