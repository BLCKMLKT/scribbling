package com.company.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface KinoService {
	public void findKinoProvince(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public void findKinoDistrict(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public void findKino(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public Integer searchKino(HttpServletRequest request) throws Exception;
}
