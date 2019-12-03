package monster._52cc.service;

import monster._52cc.pojo.AirQualityIndex;
import monster._52cc.util.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: Kh75
 * @BelongsPackage: monster._52cc.service
 * @Author: 金聖聰
 * @CreateTime: 2019-11-29 17:45
 * @Description: TODO
 */
public interface AirQualityIndexService {
    int deleteByPrimaryKey(Integer id);
    int insert(AirQualityIndex airQualityIndex);
    int updateByPrimaryKey(AirQualityIndex airQualityIndex);
    List<Map<String,Object>> selectByPrimaryKey(PageUtils pageUtils);
}
