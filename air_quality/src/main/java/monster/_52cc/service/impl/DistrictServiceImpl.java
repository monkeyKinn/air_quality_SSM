package monster._52cc.service.impl;
import	java.awt.Desktop.Action;

import monster._52cc.mapper.DistrictMapper;
import monster._52cc.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: Kh75
 * @BelongsPackage: monster._52cc.service.impl
 * @Author: 金聖聰
 * @CreateTime: 2019-11-29 17:43
 * @Description: TODO
 */
@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Override
    public List<Map<String, Object>> showAllDistrict() {
        return districtMapper.selectAllDistrict();
    }
}