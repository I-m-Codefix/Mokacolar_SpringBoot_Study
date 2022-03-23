package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("Jinyong");

        repository.save(member);
        Member result =  repository.findbyId(member.getId()).get(); //.get 으로 꺼내는 것은 좋은 방법은 아님.
        //Assertions.assertEquals(result, member);
        assertThat(member).isEqualTo(result); //요즘은 이렇게 많이 사용함.
    }

    @Test
    public void findByName(){ //shift + F6 하면 변수 전체 바꾸기 가능
        Member member1 = new Member();
        member1.setName("Jinyong1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Jinyong2");
        repository.save(member2);

        Member result = repository.findbyName("Jinyong1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("Jinyong1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Jinyong2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }



}
