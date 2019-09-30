package com.gl.jxt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.common.page.Page;
import com.gl.jxt.common.utils.Md5Util;
import com.gl.jxt.common.utils.MemberUtil;
import com.gl.jxt.common.utils.StringUtils;
import com.gl.jxt.dao.IDepartmentDao;
import com.gl.jxt.dao.IMemberDao;
import com.gl.jxt.domain.Department;
import com.gl.jxt.domain.Member;
import com.gl.jxt.domain.Order;
import com.gl.jxt.service.IGroupService;
import com.gl.jxt.service.IMemberService;
import com.gl.jxt.service.IOrderService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements IMemberService {

    @Resource
    private IMemberDao memberDao;

    @Resource
    private IDepartmentDao departmentDao;

    @Resource
    private IGroupService groupService;

    @Resource
    private IOrderService orderService;

    /**
     * 用户登录，校验密码，获取用户，跳转页面
     * @param member
     * @param request
     * @return
     */
    @Override
    public ResultModel login(Member member, HttpServletRequest request){
        String password = member.getPassword();
        member.setPassword(Md5Util.getMD5Code(member.getPassword()));
        Member findMember = memberDao.login(member);
        if(findMember != null){
            findMember = this.findById(findMember.getId());
            MemberUtil.setLoginMember(request,findMember);
            return new ResultModel(3,"登录成功",request.getServletContext().getContextPath()+"/index/");
        }
        return new ResultModel(-1,"用户名或密码错误");
    }

    @Override
    public Member findById(int id) {
        return memberDao.findById(id);
    }

    @Override
    public Member findByNumber (String number) {
        return memberDao.findByNumber(number);
    }

    @Override
    @Transactional
    public ResultModel register (Member member, HttpServletRequest request) {
        if(memberDao.findByNumber(member.getNumber()) != null){
            return new ResultModel(-1,"该用户已被注册");
        }
        Department department = departmentDao.findByName(member.getDepartment().getName());
        if (department == null){
            return new ResultModel(-1,"该系别不存在");
        }else{
            member.getDepartment().setId(department.getId());
        }
        member.setPassword(Md5Util.getMD5Code(member.getPassword()));
        if(memberDao.register(member) == 1){
            return new ResultModel(2,"注册成功",request.getServletContext().getContextPath()+"/login");
        }
        return new ResultModel(-1,"注册失败");
    }

    @Override
    @Transactional
    public ResultModel add (Member member) {
        if(memberDao.findByNumber(member.getNumber()) != null){
            return new ResultModel(-1,"该用户已被注册");
        }
        Department department = departmentDao.findByName(member.getDepartment().getName());
        if (department == null){
            return new ResultModel(-1,"该系别不存在");
        }else{
            member.getDepartment().setId(department.getId());
        }
        member.setPassword(Md5Util.getMD5Code(member.getPassword()));
        if(memberDao.register(member) == 1){
            return new ResultModel(2,"注册成功");
        }
        return new ResultModel(-1,"添加失败");
    }

    @Override
    public ResultModel update (Member member) {
        if(memberDao.update(member) == 1){
            return new ResultModel(1,"更新成功");
        }
        return new ResultModel(-1,"更新失败");
    }

    /**
     * 删除学生，删除学生所在团队中的关系
     * 删除学生相关联的订单
     * @param id
     * @return
     */
    @Override
    @Transactional
    public ResultModel delete (int id) {
        if(groupService.findByMid(id) != null ){
            groupService.deleteGroupMemberByMid(id);
        }
        Order order = orderService.selectOrderByMid(id);
        if(order != null){
            orderService.delete(order.getId());
        }
        if(memberDao.delete(id) == 1){
            return new ResultModel(1,"删除成功");
        }
        return new ResultModel(-1,"删除失败");
    }

    @Override
    public ResultModel<List<Member>> memberList () {
        List<Member> memberList = memberDao.memberList();
        ResultModel resultModel = new ResultModel(0,"操作成功");
        resultModel.setData(memberList);
        return resultModel;
    }

    @Override
    public ResultModel<List<Member>> memberListByPage (Page page) {
        List<Member> memberList = memberDao.listByPage(page);
        ResultModel result = new ResultModel(0,page);
        result.setData(memberList);
        return result;
    }

    @Override
    @Transactional
    public ResultModel changePwd (Member loginMember, String oldPassword, String newPassword) {
        if(StringUtils.isBlank(newPassword)){
            return new ResultModel(-1,"密码不能为空");
        }
        if(newPassword.length() < 6){
            return new ResultModel(-1,"密码不能少于6个字符");
        }
        oldPassword = Md5Util.getMD5Code(oldPassword);
        Member member = memberDao.findById(loginMember.getId());
        if(!oldPassword.equals(member.getPassword())){
            return new ResultModel(-1,"旧密码错误");
        }
        if(memberDao.changepwd(member.getId(),newPassword) == 1){
            return new ResultModel(3,"密码修改成功");
        }
        return new ResultModel(-1,"密码修改失败");
    }

    @Override
    @Transactional
    public ResultModel editInfo (Member loginMember, String departmentName, String className, String contactPhone, String contactEmail) {
        Department department = departmentDao.findByName(departmentName);
        if(department != null){
            loginMember.setDepartment(department);
        }
        loginMember.setClassName(className);
        loginMember.setContactPhone(contactPhone);
        loginMember.setContactEmail(contactEmail);
        if(memberDao.update(loginMember) == 1){
            return new ResultModel(0,"修改成功");
        }
        return new ResultModel(-1,"修改失败");
    }

    /**
     * 更新学生的选取关系
     * @param loginMember
     * @param state 选取关系 0:未选取 1:以选取
     * @return
     */
    @Override
    public ResultModel updateState (Member loginMember, Integer state) {
        if(memberDao.changestate(loginMember.getId(),state) == 1){
            return new ResultModel(0,"更新状态成功");
        }
        return new ResultModel(1,"更新状态失败");
    }
}
