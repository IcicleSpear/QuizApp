package MemberData;

public class Member {
    private int memberId;
    private String name;
    private int age;

    public Member(int memberId, String name, int age) {
        this.memberId = memberId;
        this.name = name;
        this.age = age;
    }

    // Getters
    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId + ", Name: " + name + ", Age: " + age;
    }
}