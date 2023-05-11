package com.example.java_demo_test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.constants.RtnCode;
import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.repository.PersonInfoDao;
import com.example.java_demo_test.service.ifs.PersonInfoService;
import com.example.java_demo_test.vo.GetPersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoResponse;

@Service // ��springboot�U��//�����O�W��//���ѭn����@���e�ҥH��b��@���O����//
public class PersonInfoServiceImpl implements PersonInfoService {

	@Autowired
	private PersonInfoDao personInfoDao;

	@Override
	public PersonInfoResponse addPersonInfo(List<PersonInfo> personInfoList) { // �s�W����k,����w�S����//�~�Ӫ����//list����entity���O
		// ��@���Ѽƪ�ӲĤ@��ƬO���b//�ˬd1.�O�_null
		// if (personInfoList == null) {
		if (CollectionUtils.isEmpty(personInfoList)) {// ��W�@��N��@��
			return new PersonInfoResponse(RtnCode.DATA_ERROR.getMessage());
		}
		// �ˬd2.List �����C����T(PersonInfo)//�qlist�����X�C�@����T��for
		// each//item�ۤv�]���ܼ�//id.name.city����null���ťզr���Ŧr��.age���ର�t��!!!
		List<String> ids = new ArrayList<>();// �ť�list
		for (PersonInfo item : personInfoList) {
			if (!StringUtils.hasText(item.getId()) || !StringUtils.hasText(item.getName())
					|| !StringUtils.hasText(item.getCity()) || item.getAge() < 0) { // �Ҧp�ˬdname�ҥHitem.getname
				return new PersonInfoResponse(RtnCode.DATA_ERROR.getMessage()); // ()���e���@�ˬO��K���ۤv���D�@�~�ɭ��̥X��//��||�O�]�����঳������~
			}
			// ���b���s���Ʈw//�@���`����ֶi��Ʈw�s��,�`��id,�Ϊť�list�h�`��id//id�O�Dkey
			ids.add(item.getId());
		}

		// �ˬd�s�W��ids�O�_�s�b���Ʈw��
		List<PersonInfo> existed = personInfoDao.findAllById(ids); // �O�o���^��
		if (!existed.isEmpty()) {// ���O�Ū��N���P�˸�Ʀb�̭��F//����for�j��]�i�H
			return new PersonInfoResponse(RtnCode.DATA_ERROR.getMessage());
		}
		List<PersonInfo> existe2 = personInfoDao.saveAll(personInfoList);
		return new PersonInfoResponse(RtnCode.SUCCESSFFUL.getMessage(), existe2);
	}

	@Override
	public GetPersonInfoResponse getPersonInfoById(String id) {
		if (!StringUtils.hasText(id)) {
			return new GetPersonInfoResponse(RtnCode.DATA_ERROR.getMessage());
		}
		Optional<PersonInfo> op = personInfoDao.findById(id); // findbyid�|��op
		if (!op.isPresent()) {
			return new GetPersonInfoResponse(RtnCode.DATA_ERROR.getMessage());
		}
		PersonInfo ot = op.get();
		return new GetPersonInfoResponse(op.get(),RtnCode.SUCCESSFFUL.getMessage());

	}

	@Override
	public GetPersonInfoResponse getAllPersonInfo() {
		List<PersonInfo> list = personInfoDao.findAll();
		return new GetPersonInfoResponse(RtnCode.SUCCESSFFUL.getMessage(), list);
	}

	@Override
	public GetPersonInfoResponse getAllPersonInfoByAge(int age) {
		List<PersonInfo> ids = new ArrayList<>();
		List<PersonInfo> list = personInfoDao.findAll();
		for (PersonInfo item : list) {
			if (item.getAge() >= age) {
				ids.add(item);
			}   

		}
		if (ids.isEmpty()) {// �S���
			return new GetPersonInfoResponse(RtnCode.DATA_ERROR.getMessage());

		}
		return new GetPersonInfoResponse(RtnCode.SUCCESSFFUL.getMessage(), ids);

	}

	@Override 
	public GetPersonInfoResponse getAllPersonInfoLessByAge(int age) {
		List<PersonInfo> ids = new ArrayList<>();
		List<PersonInfo> op = personInfoDao.findAllByOrderByAgeAsc();
		for (PersonInfo item : op) {
			if (item.getAge() <= age) {
				ids.add(item);
			}   

		}
		if (ids.isEmpty()) {// �S���
			return new GetPersonInfoResponse(RtnCode.DATA_ERROR.getMessage());

		}
		return new GetPersonInfoResponse(RtnCode.SUCCESSFFUL.getMessage(), ids);
		
	}

	

	@Override
	public GetPersonInfoResponse getAllPersonInfoBetweenByAge(int age, int age2) {
		// TODO Auto-generated method stub
		return null;
	}
	
}