package com.dealer.service;

import java.util.List;

import com.dealer.exception.DealerNotFoundException;
import com.dealer.pojo.Dealer;

public interface DealerService 
{
		public List<Dealer> showallDealer();	
		public Dealer showdealerbyId(long id) throws DealerNotFoundException;
		public Dealer addDealer(Dealer dealer) throws DealerNotFoundException;
		public Dealer updateDealer(Dealer dealer)throws DealerNotFoundException;
		public String deleteDealer(long id)throws DealerNotFoundException;
		public Dealer showDealerByName(String name) throws DealerNotFoundException;
		
}
