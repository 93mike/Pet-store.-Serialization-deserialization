package com.swagger.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetDto {

    @JsonProperty("photoUrls")
    private List<String> photoUrls;

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private long id;

    @JsonProperty("category")
    private Category category;

    @JsonProperty("tags")
    private List<TagsItem> tags;

    @JsonProperty("status")
    private String status;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Category {

        @JsonProperty("name")
        private String name;

        @JsonProperty("id")
        private int id;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class TagsItem {

        @JsonProperty("name")
        private String name;

        @JsonProperty("id")
        private int id;
    }
}