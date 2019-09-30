package com.gl.jxt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gl.jxt.common.annotation.*;
import com.gl.jxt.common.base.BaseController;
import com.gl.jxt.common.core.Const;
import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.common.page.Page;
import com.gl.jxt.common.utils.MemberUtil;
import com.gl.jxt.common.utils.StringUtils;
import com.gl.jxt.domain.Category;
import com.gl.jxt.domain.Item;
import com.gl.jxt.domain.Member;
import com.gl.jxt.domain.Order;
import com.gl.jxt.service.*;
import com.gl.jxt.web.interceptor.AdminLoginInterceptor;
import com.gl.jxt.web.interceptor.MemberLoginInterceptor;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/member")
public class MemberController extends BaseController {

    @Resource
    private IMemberService memberService;

    @Resource
    private IConfigService configService;

    @Resource
    private IItemService itemService;

    @Resource
    private ICategoryService categoryService;

    @Resource
    private IOrderService orderService;


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        Member loginMember = MemberUtil.getLoginMember(request);
        if(loginMember != null){
            return "redirect:/index/";
        }
        return "/login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "/register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ResultModel register(Member member, String repassword){
        Map<String,String> config = configService.getConfigToMap();
        if("1".equals(config.get(Const.IS_OPEN_REGISTER))){
            return new ResultModel(-1,"注册功能已关闭");
        }
        if(member == null){
            return new ResultModel(-1,"参数错误");
        }
        if (memberService.findByNumber(member.getNumber()) != null){
            return new ResultModel(-1,"改学号的用户已被注册");
        }
        if(member.getName().length() < 1){
            return new ResultModel(-1,"用户名长度最少1位");
        }
        if(!StringUtils.checkNickname(member.getName())){
            return new ResultModel(-1,"用户名只能由中文、字母、数字、下划线(_)或者短横线(-)组成");
        }
        if(!StringUtils.isEmail(member.getContactEmail())){
            return new ResultModel(-1,"邮箱格式错误");
        }
        if(member.getPassword().length() < 6){
            return new ResultModel(-1,"密码长度最少6位");
        }
        if(!member.getPassword().equals(repassword)){
            return new ResultModel(-1,"两次密码输入不一致");
        }
        return memberService.register(member,request);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResultModel login(Member member){
        ResultModel result = memberService.login(member,request);
        return result;
    }


    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @Before(MemberLoginInterceptor.class)
    public String logout(){
        MemberUtil.setLoginMember(request,null);
        return "redirect:/member/login";
    }

    @Before(AdminLoginInterceptor.class)
    @RequestMapping(value = "/index" ,method = RequestMethod.GET)
    public String index (Model model){
        Page page = new Page(request);
        ResultModel<List<Member>> result = memberService.memberListByPage(page);
        Integer count = result.getData().size();
        model.addAttribute("result",result);
        model.addAttribute("count",count);
        return "/member";
    }

    @Before(AdminLoginInterceptor.class)
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String add (){
        return "/member-add";
    }

    @Before(AdminLoginInterceptor.class)
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    @ResponseBody
    public ResultModel add (Member member, String repassword){
        if(member == null){
            return new ResultModel(-1,"参数错误");
        }
        if (memberService.findByNumber(member.getNumber()) != null){
            return new ResultModel(-1,"该学号的用户已被注册");
        }
        if(member.getName().length() < 1){
            return new ResultModel(-1,"用户名长度最少1位");
        }
        if(!StringUtils.checkNickname(member.getName())){
            return new ResultModel(-1,"用户名只能由中文、字母、数字、下划线(_)或者短横线(-)组成");
        }
        if(!StringUtils.isEmail(member.getContactEmail())){
            return new ResultModel(-1,"邮箱格式错误");
        }
        if(member.getPassword().length() < 6){
            return new ResultModel(-1,"密码长度最少6位");
        }
        if(!member.getPassword().equals(repassword)){
            return new ResultModel(-1,"两次密码输入不一致");
        }
        return memberService.add(member);
    }

    @Before(AdminLoginInterceptor.class)
    @RequestMapping(value = "/edit/{id}" ,method = RequestMethod.GET)
    public String editMember (@PathVariable("id") int id,Model model){
        Member member = memberService.findById(id);
        model.addAttribute("member",member);
        return "/member-edit";
    }

    @Before(AdminLoginInterceptor.class)
    @RequestMapping(value = "/edit/{id}" ,method = RequestMethod.POST)
    public ResultModel editMember (Member member){
        return memberService.update(member);
    }

    @Before(AdminLoginInterceptor.class)
    @RequestMapping(value = "/delete/{id}" ,method = RequestMethod.GET)
    @ResponseBody
    public ResultModel delete (@PathVariable("id") int id){
        ResultModel result = memberService.delete(id);
        return result;
    }


    @Before(MemberLoginInterceptor.class)
    @RequestMapping(value = "/item" ,method = RequestMethod.GET)
    public String itemList (Model model){
        Page page = new Page(request);
        ResultModel<List<Item>> result = itemService.itemListByPage(page);
        Integer count = result.getData().size();
        model.addAttribute("result",result);
        model.addAttribute("count",count);
        return "/member-item";
    }

    @Before(MemberLoginInterceptor.class)
    @RequestMapping(value = "/order" ,method = RequestMethod.GET)
    public String orderInfo (Model model){
        Member member = MemberUtil.getLoginMember(request);
        if (member == null){
            return "/login";
        }
        Order order = orderService.selectOrderByMid(member.getId());
        if (order == null){
            return null;
        }
        if(Integer.parseInt(configService.getValue(Const.MEMBER_ORDER_DELETE)) == 1){
            model.addAttribute("canDel",1);
        }else {
            model.addAttribute("canDel",0);
        }
        model.addAttribute("order",order);
        return "/member-order-info";
    }

    @Before(MemberLoginInterceptor.class)
    @RequestMapping(value = "/order/add" ,method = RequestMethod.GET)
    public String addOrder (Model model){
        int iid = Integer.parseInt(request.getParameter("iid"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        Item item = itemService.findById(iid);
        Category category = categoryService.findByid(cid);
        model.addAttribute("item",item);
        model.addAttribute("category",category);
        return "/member-item-order-add";
    }

    @Before(MemberLoginInterceptor.class)
    @RequestMapping(value = "/order/add" ,method = RequestMethod.POST)
    @ResponseBody
    public ResultModel addOrder  (Order order){
        ResultModel result = orderService.save(order);
        return result;
    }

    @Before(MemberLoginInterceptor.class)
    @RequestMapping(value = "/order/delete/{id}" ,method = RequestMethod.GET)
    @ResponseBody
    public ResultModel delOrder  (@PathVariable("id") int id){
        if (Integer.parseInt(configService.getValue(Const.MEMBER_ORDER_DELETE)) == 1){
            ResultModel result = new ResultModel(-1,"删除功能已关闭");
        }
        Member member = MemberUtil.getLoginMember(request);
        Order order = orderService.selectOrderByMid(member.getId());
         if(order != null && order.getId() == id){
             ResultModel result = orderService.delete(id);
             return result;
         }
        ResultModel result = new ResultModel(-1,"删除出错");
        return result;
    }

    @Before(MemberLoginInterceptor.class)
    @RequestMapping(value = "/info" ,method = RequestMethod.GET)
    public String memberInfo (Model model){
        Member member = MemberUtil.getLoginMember(request);
        model.addAttribute("member",memberService.findById(member.getId()));
        return "/member-info";
    }

    @Before(MemberLoginInterceptor.class)
    @RequestMapping(value = "/info/edit/" ,method = RequestMethod.GET)
    public String editLoginMember (Model model){
        Member loginMember = MemberUtil.getLoginMember(request);
        Member member = memberService.findById(loginMember.getId());
        model.addAttribute("member",member);
        return "/member-edit";
    }

    @Before(MemberLoginInterceptor.class)
    @RequestMapping(value = "/info/edit/{id}" ,method = RequestMethod.POST)
    @ResponseBody
    public ResultModel editLoginMember (Member member){
        if(member.getId() == MemberUtil.getLoginMember(request).getId()){
            ResultModel result = new ResultModel(-1,"更改出错");
        }
        return memberService.update(member);
    }

}
