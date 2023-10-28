package com.example.notionpainter.models.response;

import com.example.notionpainter.models.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    private boolean valid;
    private User user;
    private String accessToken;
    private String refreshToken;
}
