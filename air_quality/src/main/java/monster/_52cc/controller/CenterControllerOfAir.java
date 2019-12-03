package monster._52cc.controller;
import java.util.HashMap;
import	java.util.Map;

import monster._52cc.pojo.AirQualityIndex;
import monster._52cc.service.AirQualityIndexService;
import monster._52cc.service.DistrictService;
import monster._52cc.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @BelongsProject: Kh75
 * @BelongsPackage: monster._52cc.controller
 * @Author: 金聖聰
 * @CreateTime: 2019-11-29 17:52
 * @Description: TODO
 */
@RestController
public class CenterControllerOfAir{
    @Autowired
    private AirQualityIndexService airQualityIndexService;
    @Autowired
    private DistrictService districtService;

    @RequestMapping("/deleteByPrimaryKey.do")
    public int deleteByPrimaryKey(Integer id) {
        return airQualityIndexService.deleteByPrimaryKey(id);
    }

    @RequestMapping("/insert.do")
    public int insert(AirQualityIndex airQualityIndex) {
        if(airQualityIndex.getDistrictId()==-1 || airQualityIndex.getMonitoringStation()==null || airQualityIndex.getMonitorTime()==null || airQualityIndex.getPm2_5()==null || airQualityIndex.getPm10()==null){
            return 0;
        }
        return airQualityIndexService.insert(airQualityIndex);
    }

    @RequestMapping("/updateByPrimaryKey.do")
    public int updateByPrimaryKey(AirQualityIndex airQualityIndex) {
        if(airQualityIndex.getDistrictId()==-1 || airQualityIndex.getMonitoringStation()==null || "".equals(airQualityIndex.getMonitoringStation().trim()) || airQualityIndex.getMonitorTime()==null || airQualityIndex.getPm2_5()==null || airQualityIndex.getPm10()==null){
            return 0;
        }
        return airQualityIndexService.updateByPrimaryKey(airQualityIndex);
    }

    @RequestMapping("/selectByPrimaryKey.do")
    public Map<String, Object> selectByPrimaryKey(PageUtils pageUtils) {
        Map<String, Object> map = new HashMap<>(16);
        List<Map<String, Object>> airQualityIndexList = airQualityIndexService.selectByPrimaryKey(pageUtils);
        map.put("airQualityIndexList",airQualityIndexList);
        map.put("pageUtils",pageUtils);
        return map;
    }

    @RequestMapping("/showAllDistrict.do")
    public List<Map<String, Object>> showAllDistrict() {
        return districtService.showAllDistrict();
    }

    @RequestMapping("/info.do")
    public Map<String, Object> info(PageUtils pageUtils) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("airQualityIndex",airQualityIndexService.selectByPrimaryKey(pageUtils).get(0));
        map.put("optionData",districtService.showAllDistrict());
        return map;
    }
}