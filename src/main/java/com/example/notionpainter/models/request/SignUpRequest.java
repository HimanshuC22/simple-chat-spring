package com.example.notionpainter.models.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
