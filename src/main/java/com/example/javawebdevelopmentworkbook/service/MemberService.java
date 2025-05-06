package com.example.javawebdevelopmentworkbook.service;

import com.example.javawebdevelopmentworkbook.dao.MemberDAO;
import com.example.javawebdevelopmentworkbook.domain.MemberVO;
import com.example.javawebdevelopmentworkbook.dto.MemberDTO;
import com.example.javawebdevelopmentworkbook.util.MapperUtil;
import org.modelmapper.ModelMapper;

public enum MemberService {

    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {
        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public MemberDTO login(String mid, String mpw) throws Exception {
        MemberVO vo = dao.getWithPassword(mid, mpw);

        return modelMapper.map(vo, MemberDTO.class);
    }

    public void updateUuid(String mid, String uuid) throws Exception {
        dao.updateUuid(mid, uuid);
    }

    public MemberDTO getByUUID(String uuid) throws Exception {
        MemberVO vo = dao.selectUUID(uuid);

        return modelMapper.map(vo, MemberDTO.class);
    }
}
