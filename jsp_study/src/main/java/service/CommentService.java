package service;

import java.util.List;

import domain.CommentVO;

public interface CommentService {

	int post(CommentVO cvo);

	List<CommentVO> getlist(int bno);

	int remove(int cno);

	int modify(CommentVO cvo);

	

}
