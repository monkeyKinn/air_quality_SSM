package monster._52cc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {
    /**
	* 区域编号
	*/
    private Integer id;

    /**
	* 区域名称
	*/
    private String name;
}