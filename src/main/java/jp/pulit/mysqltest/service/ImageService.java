package jp.pulit.mysqltest.service;

import jp.pulit.mysqltest.dto.ImageDTO;
import jp.pulit.mysqltest.mapper.ImageMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

public interface ImageService {
    String getTitle(BigDecimal uid);

    String getImageDTO(BigDecimal uid);
}
