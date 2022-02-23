package com.webservice.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor // 기본 생성사 자동 추가
@Entity // 테이블과 링크될 클래스 임을 의미 / 카멜 케이스의 이름을 언더 스코어(_)의 네이밍으로 매칭
public class Posts {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 가능
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 칼럼을 나타내며 굳이 선언 안해도 해당클래스의 필드는 모두 칼럼임
    private String title; // 쓰는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있을때

    @Column(columnDefinition = "Text", nullable = false)
    private String content;

    private String author;

    @Builder //생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;

    }
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
