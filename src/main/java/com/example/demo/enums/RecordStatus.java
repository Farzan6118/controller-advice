package com.example.demo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RecordStatus {
    CREATED,
    UPDATED,
    DISABLED,
    DELETED,
}
