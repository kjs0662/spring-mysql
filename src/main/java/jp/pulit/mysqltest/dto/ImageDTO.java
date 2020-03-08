package jp.pulit.mysqltest.dto;

import java.math.BigDecimal;

public class ImageDTO {
    private BigDecimal uid;
    private String title;

    public String getTitle() {
        return title;
    }

    public BigDecimal getUid() {
        return uid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUid(BigDecimal uid) {
        this.uid = uid;
    }
}
