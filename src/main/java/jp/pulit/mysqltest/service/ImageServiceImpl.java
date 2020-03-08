package jp.pulit.mysqltest.service;

import jp.pulit.mysqltest.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageMapper imageMapper;

//    @Cacheable(value="findTitleCache", key="#uid")
    public String getTitle(BigDecimal uid) {
        return imageMapper.getTitle(uid);
    }

    @Override
    public String getImageDTO(BigDecimal uid) {
        return imageMapper.getImageDTO(uid);
    }
}
