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
    System.out.println("帳號:" + bank.getAccount()+"餘額:"+ bank.getAmount());
		
	}
	@Test
	public void BankResponse() {
//		Bank bank = new Bank("AA999","AA123456@",2000);
//		Bank oldBank = bankDao.save(bank); 
		//以上的縮寫//創假資料
		Bank oldBank = bankDao.save(new Bank("AA999","AA123456@",2000));
		Bank newBank = new Bank("AA999","AA123456@",3000);
		BankResponse response = bankService.deposit(newBank);
		Bank resBank = response.getBank();
		//確認金額有存進去/因為是金額比錯就用==
		Assert.isTrue(resBank.getAmount() == oldBank.getAmount() + newBank.getAmount() , "金額錯誤");
		Assert.isTrue(response.getMessage().equals("存款成功"),"存款成功");
		//刪除測試的資料
		bankDao.delete(resBank);
	
		
	}
	@Test
	public void withdrawTest() {
//		Bank bank = new Bank("AA999","AA123456@",2000);
//		Bank oldBank = bankDao.save(bank); 
		//以上的縮寫//創假資料
		Bank oldBank = bankDao.save(new Bank("AA999","AA123456@",5000));//存5000假資料
		Bank newBank = new Bank("AA999","AA123456@",6000);//提6000
		BankResponse response = bankService.withdraw(newBank);//提完的金額
		
		Bank resBank = response.getBank();// 存入response 
		
		Assert.isTrue(resBank.getAmount() == oldBank.getAmount() - newBank.getAmount() , "金額錯誤");//assert 是自己想的條件 程式可以跑 但如果不如自己預期會顯示錯誤
		Assert.isTrue(response.getMessage().equals("提款成功"),"提款失敗");
		bankDao.delete(resBank);//刪除測試的資料
	
		
	}

}
