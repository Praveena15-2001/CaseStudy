package com.cropdetails.service;

import java.util.List;

import com.cropdetails.exception.CropNotFoundException;
import com.cropdetails.pojo.CropDetails;

public interface CropDetailsService 
{
	public List<CropDetails> showallCrops();
	public CropDetails showcropbyId(long id)throws CropNotFoundException;
	public CropDetails addCrop(CropDetails cropdetails)throws CropNotFoundException;
	public CropDetails updateCrop(CropDetails cropdetails)throws CropNotFoundException;
	public String deleteCrop(long id)throws CropNotFoundException;
	

}
