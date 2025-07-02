package com.dealer.service;

import com.dealer.exception.SequenceException;

public interface sequenceDao 
{
	long getNextSequenceId(String key) throws SequenceException;

}
