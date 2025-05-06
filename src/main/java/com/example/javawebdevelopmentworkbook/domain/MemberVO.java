package com.example.javawebdevelopmentworkbook.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
public class MemberVO {
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;
}
