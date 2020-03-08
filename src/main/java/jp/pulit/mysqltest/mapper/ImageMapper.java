package jp.pulit.mysqltest.mapper;

import jp.pulit.mysqltest.dto.ImageDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Mapper
@Service("imageMapper")
@CacheNamespaceRef(value = jp.pulit.mysqltest.mapper.ImageMapper.class)
public interface ImageMapper {

    @Select("SELECT title FROM TB_ENCODED_IMAGE WHERE uid = #{uid}")
    @Options(useCache = true)
    String getTitle(@Param("uid") BigDecimal uid);

    @Options(useCache = true)
    String getImageDTO(@Param("uid") BigDecimal uid);

}
