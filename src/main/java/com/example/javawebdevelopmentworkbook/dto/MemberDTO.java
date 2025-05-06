package com.example.javawebdevelopmentworkbook.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MemberDTO {
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;
}
