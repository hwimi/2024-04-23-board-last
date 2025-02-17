package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import orm.DatabaseBuilder;

public class CommentDAOImpl implements CommentDAO {
	private static final Logger log = LoggerFactory.getLogger(CommentDAOImpl.class);
	private SqlSession sql;
	
	public CommentDAOImpl() {
		new DatabaseBuilder();
		sql=DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(CommentVO cvo) {
		log.info("post dao check3");
		int isOk=sql.insert("CommentMapper.post",cvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}



	@Override
	public List<CommentVO> getlist(int bno) {
		log.info("comment dao in!!!");
		return sql.selectList("CommentMapper.list",bno);
	}

	@Override
	public int remove(int cno) {
		log.info("delete dao in!!!");
		int isOk = sql.delete("CommentMapper.del", cno);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int modify(CommentVO cvo) {
		log.info("modify dao in!!!");
		int isOk=sql.update("CommentMapper.modify",cvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int removeAll(int bno) {
		int isOk=sql.delete("CommentMapper.all",bno);
		if(isOk>=0) {
			sql.commit();
		}
		return isOk;
	}

	


}
