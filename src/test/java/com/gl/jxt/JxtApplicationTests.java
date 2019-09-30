package com.gl.jxt;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gl.jxt.common.page.Page;
import com.gl.jxt.dao.*;
import com.gl.jxt.domain.*;
import com.gl.jxt.service.IConfigService;
import com.gl.jxt.service.IGroupService;
import com.gl.jxt.service.ITeacherService;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JxtApplicationTests {

    @Test
    public void contextLoads () {


    }

    @Resource
    IMemberDao memberDao;

    @Resource
    IDepartmentDao departmentDao;

    @Resource
    ITeacherDao teacherDao;

    @Resource
    ICategoryDao categoryDao;

    @Resource
    ICategoryTeacherDao categoryTeacherDao;

    @Resource
    IItemDao itemDao;

    @Resource
    ICategoryItemDao categoryItemDao;

    @Resource
    IGroupDao groupDao;

    @Resource
    IOrderDao orderDao;

    @Resource
    ITeacherService teacherService;

    @Resource
    IGroupService groupService;

    @Resource
    IConfigService configService;

    @Test
    public void test2(){
//        Member m1 = memberDao.findByNumber(10086);
//        Member m2 = memberDao.findByNumber(13123);
//        Category c1 = new Category();
//        Category c2 = new Category();
//        c1.setId(1);
//        c2.setId(2);
//        Item i1 = new Item();
//        Item i2 = new Item();
//        i1.setId(1);
//        i2.setId(2);
//        Teacher t1 = new Teacher();
//        Teacher t2 = new Teacher();
//        t1.setId(1);
//        t2.setId(2);
//        MemberOrder mo1 = new MemberOrder();
//        MemberOrder mo2 = new MemberOrder();
//        mo1.setCategory(c1);
//        mo2.setCategory(c2);
//        mo1.setItem(i1);
//        mo2.setItem(i1);
//        mo1.setTeacher(t1);
//        mo2.setTeacher(t2);
//        mo1.setMember(m1);
//        mo2.setMember(m2);
//        Group group = new Group();
//        group.setId(1);
//        mo2.setGroup(group);
//        System.out.println(mo2);
//        orderDao.saveMember(mo2);
    }




    @Test
    public void mybatisMemberTest () {
        CategoryItem categoryItem = categoryItemDao.selectCategoryItemByIidAndCid(12,4);
        System.out.println(categoryItem);
    }

    @Test
    public void test3(){
//        memberDao.register(member);
//        department.setName("土木工程");
//        departmentDao.update(department);
//        memberDao.update(member);
//        memberDao.changestate(2,"1");
//        memberDao.changepwd(2,"123");
//        Member mt1 = memberDao.findById(2);
//        List<Member> mt2 = memberDao.listMemberByDid(2);
//        List<Member> mt1 = memberDao.listMember();
//        Department department1 = departmentDao.findDepartmentByName("土木工程");
//        Teacher teacher = new Teacher();
//        teacher.setId(1);
//        teacher.setName("rew");
//        System.out.println(teacherDao.update(teacher));
//        System.out.println(teacherDao.listTeachers());
//        System.out.println(categoryDao.listCategory());
//        teacherCategory.saveTeacherCategory(1,1);
//        System.out.println(itemDao.listItems());
//        List<Item> items = categoryItemDao.getItemsByCid(1);
//        System.out.println(items);
//        List<Item> list = itemDao.listItems();
//        System.out.println(list);
//       System.out.println(itemDao.listItems());
//        System.out.println(categoryDao.listCategory());
//        System.out.println(groupDao.listGroup());
//         Group d = groupDao.findById(1);
//        System.out.println(d.getCaptain());
//        System.out.println(orderDao.selectOrderByMid(2));
//        System.out.println(itemDao.listItems());
//
//        Teacher teacher = new Teacher();
//        teacher.setId(8);
//        teacher.setName("ffff");
//        teacher.setCapacity(20);
//        teacher.setContent("777");
//        Category category = new Category();
//        category.setName("结构设计");
//        List<Category> categories = new ArrayList<>();
//        categories.add(category);
//        teacher.setCategory(categories);
////        System.out.println(teacherService.save(teacher));
////        teacherService.delect(4);
//
//        System.out.println(teacherService.update(teacher));

//     Category c1 =  new Category();
//     c1.setName("BIM");
//     ArrayList arrayList = new ArrayList();
//     arrayList.add(c1);
//     new ItemServiceImpl().forCategory(arrayList);
//        System.out.println(categoryDao.listCategory());
//        System.out.println(orderDao.selectOrderByMid(2));
//        Member m1 = new Member();
//        m1.setNumber(10086);
//        Member m2 = new Member();
//        m2.setNumber(13123);
//        ArrayList<Member> members = new ArrayList<Member>();
//        members.add(m1);
//        members.add(m2);
//        System.out.println(memberDao.findByNumberList(members));
//        Member m1 = memberDao.findByNumber(10086);
        Member m2 = memberDao.findByNumber("11111");
        System.out.println(m2);
//        Category c1 = new Category();
//        Category c2 = new Category();
//        c1.setId(1);
//        c2.setId(2);
//        Item i1 = new Item();
//        Item i2 = new Item();
//        i1.setId(1);
//        i2.setId(2);
//        Teacher t1 = new Teacher();
//        Teacher t2 = new Teacher();
//        t1.setId(1);
//        t2.setId(2);
//        MemberOrder mo1 = new MemberOrder();
//        MemberOrder mo2 = new MemberOrder();
//        mo1.setCategory(c1);
//        mo2.setCategory(c2);
//        mo1.setItem(i1);
//        mo2.setItem(i1);
//        mo1.setTeacher(t1);
//        mo2.setTeacher(t2);
//        mo1.setMember(m1);
//        mo2.setMember(m2);
//        Group group = new Group();
//        ArrayList<MemberOrder> memberOrders =  new ArrayList<>();
//        memberOrders.add(mo1);
//        memberOrders.add(mo2);
//        group.setMembers(memberOrders);
//        group.setName("666");
//        System.out.println(groupService.saveGroupOrder(group));
    }


    @Test
    public void test4(){
//       IItemService itemService =  SpringContextHolder.getBean("itemService");
//        Page page = new Page(1,5);
//        System.out.println(itemService.itemListByPage(page));
//        Map<String,String> config = configService.getConfigToMap();
//        if("0".equals(config.get(Const.IS_OPEN_CHOOSE))){
//            System.out.println("开启");
//        }
    }


}
