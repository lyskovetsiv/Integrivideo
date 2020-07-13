package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Project {

    private String projectName;
    private String description;
    private String[] domain;
}
