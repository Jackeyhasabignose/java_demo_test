package com.example.java_demo_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.repository.BankDao;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.vo.BankResponse;

@SpringBootTest(classes = JavaDemoTestApplication.class)
public class BankTest {
	
	
	
	@Autowired
	private BankDao bankDao;
	@Autowired
	private BankService bankService;

	@Test
	public void addBankInfo() {
		Bank bank = new Bank("aa","abc",50);
		bankDao.save(bank); 
		
		
	}
	@Test
	public void addInfoTest() {
		Bank bank = new Bank("AA999","AA123456@",2000);
		bankService.addInfo(bank);
	}
	@Test
	public void getAmountByIdTest() {
	Bank bank = bankService.getAmountById("a01");
    System.out.println("�b��:" + bank.getAccount()+"�l�B:"+ bank.getAmount());
		
	}
	@Test
	public void BankResponse() {
//		Bank bank = new Bank("AA999","AA123456@",2000);
//		Bank oldBank = bankDao.save(bank); 
		//�H�W���Y�g//�а����
		Bank oldBank = bankDao.save(new Bank("AA999","AA123456@",2000));
		Bank newBank = new Bank("AA999","AA123456@",3000);
		BankResponse response = bankService.deposit(newBank);
		Bank resBank = response.getBank();
		//�T�{���B���s�i�h/�]���O���B����N��==
		Assert.isTrue(resBank.getAmount() == oldBank.getAmount() + newBank.getAmount() , "���B���~");
		Assert.isTrue(response.getMessage().equals("�s�ڦ��\"),"�s�ڦ��\");
		//�R�����ժ����
		bankDao.delete(resBank);
	
		
	}
	@Test
	public void withdrawTest() {
//		Bank bank = new Bank("AA999","AA123456@",2000);
//		Bank oldBank = bankDao.save(bank); 
		//�H�W���Y�g//�а����
		Bank oldBank = bankDao.save(new Bank("AA999","AA123456@",5000));//�s5000�����
		Bank newBank = new Bank("AA999","AA123456@",6000);//��6000
		BankResponse response = bankService.withdraw(newBank);//���������B
		
		Bank resBank = response.getBank();// �s�Jresponse 
		
		Assert.isTrue(resBank.getAmount() == oldBank.getAmount() - newBank.getAmount() , "���B���~");//assert �O�ۤv�Q������ �{���i�H�] ���p�G���p�ۤv�w���|��ܿ��~
		Assert.isTrue(response.getMessage().equals("���ڦ��\"),"���ڥ���");
		bankDao.delete(resBank);//�R�����ժ����
	
		
	}

}
