package monster._52cc.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface DistrictMapper {
    @Select("SELECT * FROM district")
    List<Map<String, Object>> selectAllDistrict();
}