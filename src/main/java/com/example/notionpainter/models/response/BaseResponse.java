package com.example.notionpainter.models.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponse<T> {
    private boolean success;
    private String message;
    private T data;
}