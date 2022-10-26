package member.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("memberDao") //프로젝트 내에서 공통으로 사용할 참조변수
public class MemberDao {
	
	private String namespace = "member.model.MemberDao";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate; //root-context.xml

	public List<MemberBean> getAllMembers() {
		List<MemberBean> lists = new ArrayList<MemberBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetAllMembers");
		return lists;
	}

	public MemberBean getMemberByNum(String num) {
		MemberBean member = sqlSessionTemplate.selectOne(namespace+".GetMemberByNum", num);
		return member;
	}

	public void updateMember(MemberBean member) {
		sqlSessionTemplate.update(namespace+".UpdateMember", member);
		
	}

	public void registerMember(MemberBean member) {
		sqlSessionTemplate.insert(namespace+".RegisterMember", member);
		
	}

	public void deleteMember(String num) {
		sqlSessionTemplate.delete(namespace+".DeleteMember", num);
		
	}

	
	/* 로그인 */
	public int loginIdCheck(MemberBean member) {
		int result = sqlSessionTemplate.selectOne(namespace+".LoginIdCheck", member);
		return result;
	}

	public int login(MemberBean member) {
		int result = sqlSessionTemplate.selectOne(namespace+".Login", member);
		return result;
	}

	/* 회원가입 */
	public int checkDuplId(String inputid) {
		int result = sqlSessionTemplate.selectOne(namespace+".CheckDuplId", inputid);
		return result;
	}
	
	/* 아이디/비번 찾기 */
	public MemberBean findId(MemberBean member) {
		MemberBean memberBean = sqlSessionTemplate.selectOne(namespace+".FindId", member);
		return memberBean;
	}
	
	

}
