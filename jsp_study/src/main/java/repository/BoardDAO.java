package repository;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardDAO {

	

	int insert(BoardVO bvo);

	List<BoardVO> selectList(PagingVO pgvo);

	BoardVO selectOne(int bno);

	int update(BoardVO bvo);

	int delete(int bno);

	int total(PagingVO pgvo);

	String getFilName(int bno);

	int readCount(int bno);

	

}
