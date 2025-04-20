package com.basic.io.member.impl;

import com.basic.io.member.Member;
import com.basic.io.member.MemberRepository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FilMemberRepository implements MemberRepository {

    private final String FILE_PATH= "temp/members.dat";
    private final String DELIMITER = ",";

    @Override
    public void add(Member member) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, StandardCharsets.UTF_8, true))) {
            bw.write(member.getId() + DELIMITER + member.getName() + DELIMITER + member.getAge());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(DELIMITER);
                members.add(new Member(parts[0], parts[1], Integer.parseInt(parts[2])));
            }
            return members;
        } catch (FileNotFoundException e) {
            // 파일이 없으면 빈 리스트 반환
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
