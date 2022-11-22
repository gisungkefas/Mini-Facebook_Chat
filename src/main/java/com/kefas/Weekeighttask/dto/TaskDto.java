package com.kefas.Weekeighttask.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Data
@Getter
@Setter
@NoArgsConstructor
public class TaskDto{

    @NotBlank(message = "Title should not be blank")
    private String title;

    @NotBlank(message = "Description should not be blank")
    private String description;

    @NotBlank(message = "Status should not be blank" )
    private String status;

    private Instant createdDate;

    private Instant updatedDate;

    private Instant completedDate;
}
