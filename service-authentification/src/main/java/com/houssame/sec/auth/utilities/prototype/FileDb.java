package com.houssame.sec.auth.utilities.prototype;

import lombok.Data;

@Data
public class FileDb {
	private String id;
	 private String name;
	 private String type;
	 private Long idMission;
	 private byte[] data;
}
