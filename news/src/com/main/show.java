package com.main;

import com.date.art;
import com.date.nav;
import com.date.user;
import com.service.INewsArtService;
import com.service.INewsNavService;
import com.service.INewsUserService;
import com.serviceimpl.NewsArtServiceimpl;
import com.serviceimpl.NewsNavServiceimpl;
import com.serviceimpl.NewsUserServiceimpl;

import java.util.List;
import java.util.Scanner;

public class show {
    //子登录界面(简易管理员登录界面)
    public static boolean adminLoginUI(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----管理员登录界面-----");
        System.out.println("请输入管理员账号:");
        String adminName = sc.next();
        System.out.println("请输入管理员密码:");
        String adminPassword = sc.next();
        if (adminName.equals("adminstrator")&&adminPassword.equals("2511880"))
            return true;
        else
            return false;
    }


    //主登录界面
    public static void loginUI(){
        Scanner sc = new Scanner(System.in);
        INewsUserService userService = new NewsUserServiceimpl();
        System.out.println("-----欢迎来到新闻发布系统-----");
        for (int i=3 ; i>=0 ;i --){
            System.out.print("请输入您的账号:"+"\n");
            String userName = sc.next();
            System.out.print("请输入您的密码:"+"\n");
            String userPassword = sc.next();
            if (userService.loginUserQuery(userName,userPassword) == true){
                System.out.println("---欢迎用户"+userName+"进入新闻管理系统界面---");
                break;
            }
            else{
                if (i == 0){
                    System.out.println("次数用完，退出系统，再次登录请联系管理员");
                    System.exit(0);
                }
                System.out.println("用户名密码错误，请重新输入还剩"+i+"次机会");
            }
        }
    }

    //登陆后主界面
    public static void mainShow(){
        try {
            while (true) {
                Scanner sc = new Scanner(System.in);
                System.out.println("--1.用户管理");
                System.out.println("--2.类别管理");
                System.out.println("--3.文章管理");
                System.out.println("--4.退出系统(注意:输入操作序号以外的字符将自动退出系统!!!)");
                System.out.print("请输入操作序号:");
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        userMa();
                        break;
                    case 2:
                        navUI();
                        break;
                    case 3:
                        artUI();
                        break;
                    case 4:
                        System.out.println("即将推出系统,欢迎下次使用!");
                        System.exit(0);
                        break;
                    default:
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println("&&&&&&&&------WARNING:即将退出系统!!!");
            System.out.println("异常信息:"+e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
    }

    //子界面:用户管理界面
    public static void userMa(){
        INewsUserService userService = new NewsUserServiceimpl();
        user user = null;
        boolean flag = true;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("--1.注册用户");
            System.out.println("--2.修改用户信息(管理员权限)");
            System.out.println("--3.删除用户信息(管理员权限)");
            System.out.println("--4.查询所有用户信息(管理员权限)");
            System.out.println("--5.返回");
            System.out.println("----------注意:输入操作序号以外的字符将退出系统!!!");
            System.out.print("请输入操作序号:");
            try {

                int num = sc.nextInt();
                switch (num) {
                    case 1:
//                        System.out.println("请输入注册id值(熟记:id值用来删除，修改，查询用户):");
//                        int id = sc.nextInt();
                        System.out.println();
                        System.out.println("请输入注册的用户名:");
                        String uname = sc.next();
                        System.out.println("请输入注册密码:");
                        String pwd = sc.next();
                        System.out.println("请输入真实姓名(请用英文):");
                        String rname = sc.next();
                        user = new user(uname, pwd, rname);
                        flag = userService.addUser(user);
                        if (flag == true) {
                            System.out.println("注册成功!");
                            System.out.println("----------------");
                        }
                        else {
                            System.out.println("注册失败!");
                            System.out.println("----------------");
                        }
                        break;

                    //可以修改真实姓名
                    case 2:
                        flag = adminLoginUI();
                        if (flag == true){
                            System.out.println("已获得管理员权限!");
                            System.out.println("请输入所要修改账户的id:");
                            int id = sc.nextInt();
                            System.out.println("请输入修改后的密码:");
                            String cPwd = sc.next();
                            System.out.println("请输入修改后的真实姓名:");
                            String cRname = sc.next();
                            user = new user(cPwd,cRname);
                            flag = userService.updateUser(id,user);
                            if (flag == true) {
                                System.out.println("修改成功!");
                                System.out.println("----------------");
                            }
                            else{
                                System.out.println("修改失败!");
                                System.out.println("----------------");
                            }
                        }
                        else{
                            System.out.println("账号或密码不正确,未获得管理员权限------>注意:由于安全问题系统即将关闭!");
                            System.exit(0);
                        }
                        break;

                    case 3:
                        flag = adminLoginUI();
                        if (flag == true){
                            System.out.println("已获得管理员权限!");
                            System.out.println("请输入所要删除账户的id号:");
                            int id = sc.nextInt();
                            flag = userService.deleteUser(id);
                            if (flag == true) {
                                System.out.println("删除成功!");
                                System.out.println("----------------");
                            }
                            else{
                                System.out.println("删除失败!");
                                System.out.println("----------------");
                            }
                        }
                        else{
                            System.out.println("账号或密码不正确,未获得管理员权限------>注意:由于安全问题系统即将关闭!");
                            System.exit(0);
                        }
                        break;

                    case 4:
                        List<user> users = null;
                        flag = adminLoginUI();
                        if (flag == true){
                            System.out.println("已获得管理员权限!");
                            System.out.println("-----全部用户信息显示-----");
                            users = userService.queryAllUser();

                            for(int i = 0;i < users.size();i++) {
                                System.out.println();
                                user users1 = (user)users.get(i);
                                System.out.println("id:"+users1.getId()+" "+"用户名:"+users1.getU_uname()+"　"+"密码:"+users1.getU_pwd()+" "+"真实姓名:"+users1.getU_rname());
                            }
                        }
                        else{
                            System.out.println("账号或密码不正确,未获得管理员权限------>注意:由于安全问题系统即将关闭!");
                            System.exit(0);
                        }
                        break;

                    case 5:
                        mainShow();
                        break;
                    default:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("&&&&&&&&------WARNING:即将退出系统!!!");
                System.exit(0);
                e.printStackTrace();
            }
        }
    }

    //子界面:类别管理界面
    public static void navUI(){
        INewsNavService navService = new NewsNavServiceimpl();
        nav nav = null;
        boolean flag = true;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("--1.增加类别");
            System.out.println("--2.修改类别(管理员权限)");
            System.out.println("--3.删除类别(管理员权限)");
            System.out.println("--4.查询所有类别");
            System.out.println("--5.返回");
            System.out.println("----------注意:输入操作序号以外的字符将退出系统!!!");
            System.out.print("请输入操作序号:");
            try {

                int num = sc.nextInt();
                switch (num) {
                    case 1:
//                        System.out.println("请输入注册id值(熟记:id值用来删除，修改，查询用户):");
//                        int id = sc.nextInt();
                        System.out.println();
                        System.out.println("添加类别:");
                        String nNav = sc.next();
                        System.out.println("添加权重:");
                        String nHeavy = sc.next();
                        nav = new nav(nNav, nHeavy);
                        flag = navService.addNav(nav);
                        if (flag == true) {
                            System.out.println("添加成功!");
                            System.out.println("----------------");
                        }
                        else {
                            System.out.println("添加失败!");
                            System.out.println("----------------");
                        }
                        break;

                    case 2:
                        flag = adminLoginUI();
                        if (flag == true){
                            System.out.println("已获得管理员权限!");
                            System.out.println("请输入所要修改类别的id:");
                            int id = sc.nextInt();
                            System.out.println("请输入修改后的类别:");
                            String cNav = sc.next();
                            System.out.println("请输入修改后的权重:");
                            String cHeavy = sc.next();
                            nav = new nav(cNav,cHeavy);
                            flag = navService.updateNav(id,nav);
                            if (flag == true) {
                                System.out.println("修改成功!");
                                System.out.println("----------------");
                            }
                            else{
                                System.out.println("修改失败!");
                                System.out.println("----------------");
                            }
                        }
                        else{
                            System.out.println("账号或密码不正确,未获得管理员权限------>注意:由于安全问题系统即将关闭!");
                            System.exit(0);
                        }
                        break;

                    case 3:
                        flag = adminLoginUI();
                        if (flag == true){
                            System.out.println("已获得管理员权限!");
                            System.out.println("请输入所要删除账户的id号:");
                            int id = sc.nextInt();
                            flag = navService.deleteNav(id);
                            if (flag == true) {
                                System.out.println("删除成功!");
                                System.out.println("----------------");
                            }
                            else{
                                System.out.println("删除失败!");
                                System.out.println("----------------");
                            }
                        }
                        else{
                            System.out.println("账号或密码不正确,未获得管理员权限------>注意:由于安全问题系统即将关闭!");
                            System.exit(0);
                        }
                        break;

                    case 4:
                        List<nav> navs = null;
                            navs = navService.queryAllNavs();
                            for(int i = 0;i < navs.size();i++) {
                                System.out.println();
                                nav navs1 = (nav)navs.get(i);
                                System.out.println("id:"+navs1.getId()+" "+"类别名:"+navs1.getN_name()+"　"+"权重:"+navs1.getN_heavy());
                            }
                        break;

                    case 5:
                        mainShow();
                        break;
                    default:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("&&&&&&&&------WARNING:即将退出系统!!!");
                System.exit(0);
                e.printStackTrace();
            }
        }
    }

    public static void artUI(){
        INewsArtService artService = new NewsArtServiceimpl();
        art art = null;
        boolean flag = true;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("--1.增加文章信息");
            System.out.println("--2.修改文章信息(管理员权限)");
            System.out.println("--3.删除文章(管理员权限)");
            System.out.println("--4.查询所有文章");
            System.out.println("--5.返回");
            System.out.println("----------注意:输入操作序号以外的字符将退出系统!!!");
            System.out.print("请输入操作序号:");
            try {

                int num = sc.nextInt();
                switch (num) {
                    case 1:
//                        System.out.println("请输入注册id值(熟记:id值用来删除，修改，查询用户):");
//                        int id = sc.nextInt();
                        System.out.println();
                        System.out.println("添加文章标题:");
                        String aArt = sc.next();
                        System.out.println("添加文章类别:");
                        String aNav = sc.next();
                        System.out.println("添加文章发布时间:");
                        String aTime = sc.next();
                        art = new art(aArt, aNav,aTime);
                        flag = artService.addArt(art);
                        if (flag == true) {
                            System.out.println("添加成功!");
                            System.out.println("----------------");
                        }
                        else {
                            System.out.println("添加失败!");
                            System.out.println("----------------");
                        }
                        break;

                    case 2:
                        flag = adminLoginUI();
                        if (flag == true){
                            System.out.println("已获得管理员权限!");
                            System.out.println("请输入所要修改文章的id:");
                            int id = sc.nextInt();
                            System.out.println("请输入修改后的文章的标题:");
                            String cTitle = sc.next();
                            System.out.println("请输入修改后的文章的类别:");
                            String cNav = sc.next();
                            art = new art(cTitle,cNav);
                            flag = artService.updateArt(id,art);
                            if (flag == true) {
                                System.out.println("修改成功!");
                                System.out.println("----------------");
                            }
                            else{
                                System.out.println("修改失败!");
                                System.out.println("----------------");
                            }
                        }
                        else{
                            System.out.println("账号或密码不正确,未获得管理员权限------>注意:由于安全问题系统即将关闭!");
                            System.exit(0);
                        }
                        break;

                    case 3:
                        flag = adminLoginUI();
                        if (flag == true){
                            System.out.println("已获得管理员权限!");
                            System.out.println("请输入所要删除账户的id号:");
                            int id = sc.nextInt();
                            flag = artService.deleteArt(id);
                            if (flag == true) {
                                System.out.println("删除成功!");
                                System.out.println("----------------");
                            }
                            else{
                                System.out.println("删除失败!");
                                System.out.println("----------------");
                            }
                        }
                        else{
                            System.out.println("账号或密码不正确,未获得管理员权限------>注意:由于安全问题系统即将关闭!");
                            System.exit(0);
                        }
                        break;

                    case 4:
                        List<art> arts = null;
                        arts = artService.queryAllArts();
                        for(int i = 0;i < arts.size();i++) {
                            System.out.println();
                            art arts1 = (art)arts.get(i);
                            System.out.println("id:"+arts1.getId()+" "+"标题:"+arts1.getA_title()+"　"+"类别:"+arts1.getA_nav()+" "+"发布时间:"+arts1.getA_time());
                        }
                        break;

                    case 5:
                        mainShow();
                        break;
                    default:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("&&&&&&&&------WARNING:即将退出系统!!!");
                System.exit(0);
                e.printStackTrace();
            }
        }
    }

}

