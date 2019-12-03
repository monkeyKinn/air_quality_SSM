package monster._52cc.service.impl;

import monster._52cc.mapper.AirQualityIndexMapper;
import monster._52cc.pojo.AirQualityIndex;
import monster._52cc.service.AirQualityIndexService;

import monster._52cc.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * @BelongsProject: Kh75
 * @BelongsPackage: monster._52cc.service.impl
 * @Author: 金聖聰
 * @CreateTime: 2019-11-29 17:46
 * @Description: TODO
 */
@Service
@Transactional
public class AirQualityIndexServiceImpl implements AirQualityIndexService {
    @Autowired
    private AirQualityIndexMapper airQualityIndexMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return airQualityIndexMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AirQualityIndex airQualityIndex) {
        //todo获取当前系统时间
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //2019-10-23 10:31:37
        airQualityIndex.setLastModifyTime(sdf.format(d));
        if (airQualityIndex.getDistrictId() == -1) {
            return 0;
        }
        return airQualityIndexMapper.insert(airQualityIndex);
    }

    @Override
    public int updateByPrimaryKey(AirQualityIndex airQualityIndex) {
        //todo获取当前系统时间
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //2019-10-23 10:31:37
        //设置时区
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        airQualityIndex.setLastModifyTime(sdf.format(d));
        if (airQualityIndex.getDistrictId() == -1) {
            return 0;
        }
        System.out.println(airQualityIndex);
        return airQualityIndexMapper.updateByPrimaryKey(airQualityIndex);
    }

    @Override
    public List<Map<String, Object>> selectByPrimaryKey(PageUtils pageUtils) {
        if(pageUtils.getPageNo()==null){
            return airQualityIndexMapper.selectByPrimaryKey(pageUtils);
        }
        pageUtils.setTotalCount(airQualityIndexMapper.getTotalCount(pageUtils.getAirQualityIndex()));
        pageUtils.setPageSize(5);
        pageUtils.setTotalPages(pageUtils.getPageSize(), pageUtils.getTotalCount());
        pageUtils.setStartRow(pageUtils.getPageSize(), pageUtils.getPageNo());
        return airQualityIndexMapper.selectByPrimaryKey(pageUtils);
    }
}
