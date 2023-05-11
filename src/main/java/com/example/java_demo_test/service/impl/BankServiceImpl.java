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
		// �ˬd�b��
		checkAccount(bank);
		// �ˬd�K��
		checkPassword(bank);

		if (bank.getAmount() < 0) {
			System.out.println("amount is error!");
			return;

		}

		bankDao.save(bank);

	}

	private void checkAccount(Bank bank) {
		// �ˬd�b��
		if (bank == null) {
			System.out.println("bank is null");
			return;
		}
		String account = bank.getAccount();
		if (account == null) {
			System.out.println("account is null");
			return;
		}
		// �ˬd�b������/���঳�ť�/���঳�S��Ÿ�
		if (!account.matches(pattern)) {
			System.out.println("�b����!");
			return;
		}
	}

	// �ˬd�K�X
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
			// return new Bank(); �o�O�H�W2�檺²��

		}
		Optional<Bank> op = bankDao.findById(id); // �]optional�O�]��jpa�O�O�H�g�n��
//		Bank bank = op.orElse(new Bank());
//		return bank;
		return op.orElse(new Bank()); // �H�W2�檺²��

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
//		=========================================== // �H�U�O�W�����Y�g
		if (bank == null || !StringUtils.hasText(bank.getAccount()) || !StringUtils.hasText(bank.getPwd())
				|| bank.getAmount() <= 0) {
			return new BankResponse ();
		}

//		Optional<Bank> op = bankDao.findById(bank.getAccount());
//		if(!op.isPresent()) {
//			return new Bank();
//		}
//		Bank resBank = op.get();
		// �q��Ʈw���X�b�K
		Bank resBank = bankDao.findByAccountAndPassword(bank.getAccount(), bank.getPwd());
		if (resBank == null) {
			return new BankResponse();
		}
		// ���X��Ʈw���l�B
		int oldAmount = resBank.getAmount();
		// �H�U�O�Ȧ�n�s�ڪ����B 
		int depositAmount = bank.getAmount();
		// �H�U�O�̷s�l�B�n�A�s�J��Ʈw
		int newAmount = oldAmount + depositAmount;
		resBank.setAmount(newAmount);
		return new BankResponse(bankDao.save(resBank),"�s�ڦ��\");

//      Bank newBank = bankDao.save(resBank);  �H�W���檺�Y�g
//		return newBank;

	}

	@Override
	public BankResponse withdraw(Bank bank) {
		if (bank == null || !StringUtils.hasText(bank.getAccount()) || !StringUtils.hasText(bank.getPwd())
				|| bank.getAmount() <= 0) {
			return new BankResponse(new Bank(),"�b���αK�X���~");//���p�S���b�K�N�^��
		}
		Bank resBank = bankDao.findByAccountAndPassword(bank.getAccount(), bank.getPwd());
		if (resBank == null) {
			return new BankResponse(new Bank(),"��Ƥ��s�b");//���p�i��Ʈw�䤣��b�K�N�^��
		}
		int oldAmount = resBank.getAmount();

		int withdraw = bank.getAmount();
		if (withdraw > oldAmount) {
			System.out.println("��");
			return new BankResponse(new Bank(),"�l�B������");
			
		}
		int newAmount = oldAmount - withdraw; 
		resBank.setAmount(newAmount);
//	    bankDao.save(resBank);
	    return new BankResponse(bankDao.save(resBank),"���ڦ��\");
	    
	}

	
	
	
	
}