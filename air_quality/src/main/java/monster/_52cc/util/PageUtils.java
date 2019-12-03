package monster._52cc.util;

import lombok.ToString;
import monster._52cc.pojo.AirQualityIndex;

/**
 * @BelongsProject: Kh75
 * @BelongsPackage: monster._52cc.util
 * @Author: 金聖聰
 * @CreateTime: 2019-11-29 16:53
 * @Description: TODO
 */
@ToString
public class PageUtils {
    private Integer pageSize;
    private Integer pageNo;
    private Integer totalCount;
    private Integer totalPages;
    private Integer startRow;
    /**
     * 需要分页的对象
     */
    private AirQualityIndex airQualityIndex;

    public PageUtils() {
    }

    public PageUtils(Integer pageSize, Integer pageNo, Integer totalCount, AirQualityIndex airQualityIndex) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.totalCount = totalCount;
        this.airQualityIndex = airQualityIndex;

        setStartRow(pageSize,pageNo);
        setTotalPages(pageSize,totalCount);
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer pageSize,Integer totalCount) {
        this.totalPages = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer pageSize,Integer pageNo) {
        this.startRow = (pageNo-1)*pageSize;
    }

    public AirQualityIndex getAirQualityIndex() {
        return airQualityIndex;
    }

    public void setAirQualityIndex(AirQualityIndex airQualityIndex) {
        this.airQualityIndex = airQualityIndex;
    }
}
