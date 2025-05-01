package com.example.javawebdevelopmentworkbook.service;

import com.example.javawebdevelopmentworkbook.dao.TodoDAO;
import com.example.javawebdevelopmentworkbook.domain.TodoVO;
import com.example.javawebdevelopmentworkbook.dto.TodoDTO;
import com.example.javawebdevelopmentworkbook.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;

@Log4j2
public enum TodoService {

    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO) throws Exception {

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        log.info(todoVO);

        dao.insert(todoVO);
    }

    public void modify(TodoDTO todoDTO) throws Exception {
        log.info(">> todoDTO: " + todoDTO);

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        dao.updateOne(todoVO);
    }

    public void remove(Long tno) throws Exception {
        log.info(">> tno: " + tno);

        dao.deleteOne(tno);
    }

    public TodoDTO get(Long tno) throws Exception {
        log.info(">> tno: " + tno);

        TodoVO todoVO = dao.selectOne(tno);

        return modelMapper.map(todoVO, TodoDTO.class);
    }

    public List<TodoDTO> listAll() throws Exception {

        List<TodoVO> voList = dao.selectAll();

        log.info(">> voList <<");
        log.info(voList);

        return voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .toList();
    }
}
