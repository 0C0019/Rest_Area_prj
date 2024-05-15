package prj2.mgt.manageMember.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StarRateMemVO {
	private String raName;
	private String raNum;
	private String memId;
	private int star;
	private Date inputDate;
}
