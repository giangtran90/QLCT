package com.example.QLCT.entityDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArchitectDto {

	private Integer id;
	private String name;
	private Integer birthday;
	private Integer sex;
	private String place;
	private String address;
}
