package db;
import models.Member;

import java.util.ArrayList;
public class DBManager {
    private static ArrayList<Member> members = new ArrayList<>();
    private static long id = 3l;

    static{
        members.add(new Member(1l, "Dean","Winchester","Human", "Hunter"));
        members.add(new Member(2l,"Sam","Winchester","Human", "Hunter"));
    }

    public static ArrayList<Member> getMembers(){
        return members;
    }

    public static void addMember(Member member){

        member.setId(id);
        members.add(member);
        id++;
    }
    public static Member getMember(Long id){
        for(Member m : members){
            if(m.getId()==id){
                return m;
            }
        }
        return null;
    }
}
