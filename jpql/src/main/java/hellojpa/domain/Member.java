package hellojpa.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@NamedQuery(
        name = "Member.findByUsername",
        query = "select m from Member m where m.username = :username"
)
public class Member {
    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private int age;


    @Enumerated(EnumType.STRING)
    private MemberType memberType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return getAge() == member.getAge() && Objects.equals(getId(), member.getId()) && Objects.equals(getUsername(), member.getUsername()) && getMemberType() == member.getMemberType() && Objects.equals(getTeam(), member.getTeam());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getAge(), getMemberType(), getTeam());
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", memberType=" + memberType +
                ", team=" + team +
                '}';
    }
}
