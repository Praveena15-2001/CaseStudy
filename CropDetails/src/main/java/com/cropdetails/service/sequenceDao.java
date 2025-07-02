package com.cropdetails.service;

import com.cropdetails.exception.SequenceException;

public interface sequenceDao 
{
	long getNextSequenceId(String key) throws SequenceException;

}
