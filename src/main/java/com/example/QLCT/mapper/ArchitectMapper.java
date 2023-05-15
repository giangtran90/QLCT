package com.example.QLCT.mapper;

import com.example.QLCT.entity.Architect;
import com.example.QLCT.entityDto.ArchitectDto;

public class ArchitectMapper {

	public ArchitectDto toArchitectDto(Architect architect) {
        ArchitectDto architectDto = new ArchitectDto();
        architectDto.setId(architect.getId());
        architectDto.setName(architect.getName());
        architectDto.setBirthday(architect.getBirthday());
        architectDto.setSex(architect.getSex());
        architectDto.setPlace(architect.getPlace());
        architectDto.setAddress(architect.getAddress());

        return architectDto;
    }
	
	public Architect toArchitect(ArchitectDto architectDto) {
        Architect architect = new Architect();
        architect.setId(architectDto.getId());
        architect.setName("sdfsdfsdf");
        architect.setBirthday(architectDto.getBirthday());
        architect.setSex(architectDto.getSex());
        architect.setPlace(architectDto.getPlace());
        architect.setAddress(architectDto.getAddress());

        return architect;
    }
}
