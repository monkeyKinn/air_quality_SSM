package monster._52cc.mapper;

import monster._52cc.pojo.AirQualityIndex;
import monster._52cc.util.PageUtils;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface AirQualityIndexMapper {

    @Delete("DELETE FROM air_quality_index where id = #{id}")
    int deleteByPrimaryKey(Integer id);

    @Insert("INSERT INTO air_quality_index VALUES (NULL,#{districtId}, #{monitorTime}, #{pm10}, #{pm2_5}, #{monitoringStation}, #{lastModifyTime})")
    int insert(AirQualityIndex airQualityIndex);

    @Update("UPDATE air_quality_index SET districtId = #{districtId},monitorTime = #{monitorTime},pm10 = #{pm10},pm2_5 = #{pm2_5},monitoringStation = #{monitoringStation},lastModifyTime = #{lastModifyTime} WHERE id = #{id}")
    int updateByPrimaryKey(AirQualityIndex airQualityIndex);

    @Select("<script>" +
            "SELECT a.*,d.name FROM air_quality_index a,district d WHERE a.districtId = d.id" +
            "<if test='airQualityIndex != null and airQualityIndex.id != null'>" +
            "  AND a.id=#{airQualityIndex.id}" +
            "</if>" +
            "<if test='airQualityIndex != null and airQualityIndex.districtId != -1 and airQualityIndex.districtId != null'>" +
            "  AND a.districtId=#{airQualityIndex.districtId}" +
            "</if>" +
            "<if test='pageSize != null and startRow != null'>" +
            "  LIMIT #{startRow},#{pageSize}" +
            "</if>" +
            "</script>")
    List<Map<String,Object>> selectByPrimaryKey(PageUtils pageUtils);

    @Select("<script>" +
            "  SELECT count(0) FROM air_quality_index" +
            "  <where>" +
            "    <if test='districtId != null and districtId != -1'>" +
            "        AND districtId=#{districtId}" +
            "    </if>" +
            "  </where>" +
            "</script>")
    int getTotalCount(AirQualityIndex airQualityIndex);
}