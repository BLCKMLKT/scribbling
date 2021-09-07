package com.company.mapper;

import java.util.List;

public interface KinoMapper {
	public List<String> findKinoProvince(String kbrand);
	public List<String> findKinoDistrict(String kbrand, String kprovince);
	public List<String> findKino(String kbrand, String kprovince, String kdistrict);
	public Integer searchKino(String kname);
}
