package com.kh.rr.transaction.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class TransactionDao {
	private Properties prop = new Properties();
	
	public TransactionDao() {
		String fileName = TransactionDao.class
				.getResource("/sql/matching/transaction-query.properties")
				.getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public int insertTransaction(Connection con, String point) {
		
		
		return 0;
	}

}
