package monster._52cc.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirQualityIndex {
    /**
	* 记录编号
	*/
    private Integer id;

    /**
	* 区域编号
	*/
    private Integer districtId;

    /**
	* 检测时间
	*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date monitorTime;

    /**
	* pm10值
	*/
    private Integer pm10;

    /**
	* pm2.5值
	*/
    private Integer pm2_5;

    /**
	* 监测站
	*/
    private String monitoringStation;

    /**
	* 最后修改时间
	*/
    private String lastModifyTime;
}