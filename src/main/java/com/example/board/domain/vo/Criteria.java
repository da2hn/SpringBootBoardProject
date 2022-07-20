package com.example.board.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
//@RequiredArgsConstructor //기본 생성자보다 우선순위가 낮다.
@AllArgsConstructor
public class Criteria {
    private Integer pageNum;
    private Integer amount;
    private String type;
    private String keyword;

    public Criteria() {
        this(1, 10);
    }

    public Criteria(Integer pageNum, Integer amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    public String[] getTypes(){
        return type == null ? new String[]{} : type.split("");
    }

    public String getListLink() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("pageNum", this.pageNum)
                .queryParam("amount", this.amount)
                .queryParam("keyword", this.keyword)
                .queryParam("type", type);

        return builder.toUriString();
    }
}
