package com.example.java_demo_test.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.repository.BankDao;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.vo.BankResponse;

@Service
public class BankServiceImpl implements BankService {

	private String pattern = "\\w{3,8}";
	private String pattern1 = "[\\S]{8,16}";

	@Autowired
	private BankDao bankDao;

	@Override
	public void addInfo(Bank bank) {
		// 檢查帳號
		checkAccount(bank);
		// 檢查密馬
		checkPassword(bank);

		if (bank.getAmount() < 0) {
			System.out.println("amount is error!");
			return;

		}

		bankDao.save(bank);

	}

	private void checkAccount(Bank bank) {
		// 檢查帳號
		if (bank == null) {
			System.out.println("bank is null");
			return;
		}
		String account = bank.getAccount();
		if (account == null) {
			System.out.println("account is null");
			return;
		}
		// 檢查帳號長度/不能有空白/不能有特殊符號
		if (!account.matches(pattern)) {
			System.out.println("帳號錯!");
			return;
		}
	}

	// 檢查密碼
	private void checkPassword(Bank bank) {
		String password = bank.getPwd();
		if (password == null || !password.matches(pattern1)) {
			System.out.println("password is error");
			return;

		}

	}

	@Override
	public Bank getAmountById(String id) {
		if (!StringUtils.hasText(id)) {
			Bank bank = new Bank();
			return bank;
			// return new Bank(); 這是以上2行的簡化

		}
		Optional<Bank> op = bankDao.findById(id); // 包optional是因為jpa是別人寫好的
//		Bank bank = op.orElse(new Bank());
//		return bank;
		return op.orElse(new Bank()); // 以上2行的簡化

	}

	@Override
	public BankResponse deposit(Bank bank) {
//		if (bank == null) {
//			return new Bank();
//		}
//		if (!StringUtils.hasText(bank.getAccount())) {
//			return new Bank();
//		}
//		if (!StringUtils.hasText(bank.getPwd())) {
//			return new Bank();
//		}
//		if (bank.getAmount() <= 0) {
//			return new Bank();
//
//		}
//		=========================================== // 以下是上面的縮寫
		if (bank == null || !StringUtils.hasText(bank.getAccount()) || !StringUtils.hasText(bank.getPwd())
				|| bank.getAmount() <= 0) {
			return new BankResponse ();
		}

//		Optional<Bank> op = bankDao.findById(bank.getAccount());
//		if(!op.isPresent()) {
//			return new Bank();
//		}
//		Bank resBank = op.get();
		// 從資料庫取出帳密
		Bank resBank = bankDao.findByAccountAndPassword(bank.getAccount(), bank.getPwd());
		if (resBank == null) {
			return new BankResponse();
		}
		// 提出資料庫的餘額
		int oldAmount = resBank.getAmount();
		// 以下是銀行要存款的金額 
		int depositAmount = bank.getAmount();
		// 以下是最新餘額要再存入資料庫
		int newAmount = oldAmount + depositAmount;
		resBank.setAmount(newAmount);
		return new BankResponse(bankDao.save(resBank),"存款成功");

//      Bank newBank = bankDao.save(resBank);  以上那行的縮寫
//		return newBank;

	}

	@Override
	public BankResponse withdraw(Bank bank) {
		if (bank == null || !StringUtils.hasText(bank.getAccount()) || !StringUtils.hasText(bank.getPwd())
				|| bank.getAmount() <= 0) {
			return new BankResponse(new Bank(),"帳號或密碼錯誤");//假如沒有帳密就回傳
		}
		Bank resBank = bankDao.findByAccountAndPassword(bank.getAccount(), bank.getPwd());
		if (resBank == null) {
			return new BankResponse(new Bank(),"資料不存在");//假如進資料庫找不到帳密就回傳
		}
		int oldAmount = resBank.getAmount();

		int withdraw = bank.getAmount();
		if (withdraw > oldAmount) {
			System.out.println("錯");
			return new BankResponse(new Bank(),"餘額不足喔");
			
		}
		int newAmount = oldAmount - withdraw; 
		resBank.setAmount(newAmount);
//	    bankDao.save(resBank);
	    return new BankResponse(bankDao.save(resBank),"提款成功");
	    
	}

	
	
	
	
}