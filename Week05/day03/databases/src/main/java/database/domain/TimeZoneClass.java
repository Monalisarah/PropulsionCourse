package database.domain;

import java.sql.Timestamp;
import java.util.TimeZone;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TimeZoneClass {	
	public int id;
	public TimeZone timeZone;
}
