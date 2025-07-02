package com.farmer.service;

import com.farmer.exception.SequenceException;

public interface sequenceDao 
{
	long getNextSequenceId(String key) throws SequenceException;

}
