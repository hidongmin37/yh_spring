package com.basic.io.member.impl;

import com.basic.io.member.Member;
import com.basic.io.member.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectMemberRepository implements MemberRepository {
    private static final String FILE_PATH = "temp/members-obj.dat";

    @Override
    public void add(Member member) throws IOException {
        List<Member> members = findAll();
        members.add(member);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(members);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Object findObject = ois.readObject();
            return (List<Member>) findObject;
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // 여기서는 list.of()안됨. immutable해서
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
