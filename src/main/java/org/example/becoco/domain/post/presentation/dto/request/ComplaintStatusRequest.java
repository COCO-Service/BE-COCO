package org.example.becoco.domain.post.presentation.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ComplaintStatusRequest {
    private boolean status;
}
