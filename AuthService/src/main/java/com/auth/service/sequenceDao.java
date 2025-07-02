package com.auth.service;

import com.auth.exception.SequenceException;

public interface sequenceDao 
{
	long getNextSequenceId(String key) throws SequenceException;

}
