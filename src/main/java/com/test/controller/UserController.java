package com.test.controller;

import com.test.bean.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author admin
 */
@Controller
public class UserController {
    @Autowired
    private UserService service;
    private List<User> listAll = new ArrayList<>();
    @ResponseBody
    @RequestMapping("/cong")
    public String cong(String email){
        if(service.selectName(email) != null){
            return "1";
        }
        return "0";
    }

    @RequestMapping("/add")
    public String add(Model model,User user,String email, HttpServletRequest request){
        if(user != null){
            if(service.selectName(user.getEmail()) == null){
                if(service.add(user)){
                    return "login";
                }
            }
        }
        request.setAttribute("cong","邮箱名重复");
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model,User user, HttpServletRequest request){
        if(service.select(user) != null){
//            System.out.println(service.select(user));
            request.getSession().setAttribute("login",service.select(user));
            return "update";
        }
        request.setAttribute("cw","邮箱或密码错误！");
        return "login";
    }

    @RequestMapping("/update")
    public String update(Model model,User user, HttpServletRequest request, @RequestParam("img") MultipartFile file) throws IOException {
        String path = request.getServletContext().getRealPath("/image/")+file.getOriginalFilename();
        String path1 = "C:/Users/admin/Desktop/test/src/main/webapp/image/"+file.getOriginalFilename();
        file.transferTo(new File(path));
        file.transferTo(new File((path1)));
        user.setImage(file.getOriginalFilename());
        User u = (User) request.getSession().getAttribute("login");
        user.setId(u.getId());
        if(service.update(user)){
            return "redirect:/list";
        }
        return "update";
    }

    @RequestMapping("/list")
    public String list(Model model,HttpServletRequest request){
        User u = (User)request.getSession().getAttribute("login");
        model.addAttribute("user",service.selectName(u.getEmail()));
        return "list";
    }

    @RequestMapping("/list2")
    public String list2(Model model,HttpServletRequest request){
        model.addAttribute("user",service.selectAll2());
        service.selectAll2().forEach(System.out::println);
        return "list2";
    }

    @RequestMapping("/delete2")
    public String delete2(Model model,HttpServletRequest request,String id){
        service.delete2(id);
        return "redirect:/list2";
    }

    @RequestMapping("/u")
    public String u(Model model,HttpServletRequest request,String id){
        User user = service.selectId(id);
        model.addAttribute("user",user);
        return "update2";
    }

    @RequestMapping("/update2")
    public String update2(Model model,User user,HttpServletRequest request){
        if(service.update2(user)){
            return "redirect:/list2";
        }
        return "update2";
    }

    @RequestMapping("/add2")
    public String add2(Model model,User user,HttpServletRequest request){
        if(service.add2(user)){
            return "redirect:/list2";
        }
        return "add2";
    }

    @RequestMapping("/list3")
    public String list3(Model model,String shang,String page1,String name, HttpSession session){
        if(name == null){
            if((String)session.getAttribute("name") != null){
                name = (String)session.getAttribute("name");
            }else{
                name = "";
            }
        }
        int sum = service.selectLikeAll(name).size();
        int num = (sum - sum%3)/3;
        if(sum%3!=0){
            num++;
        }
        if(page1 == null){
            page1 = "1";
        }
        int page = Integer.parseInt(page1);
        if("s".equals(shang) && page != 1){
            page--;
        }else if("x".equals(shang) && page != num && num != 0){
            page++;
        }
        if(name == null && shang == null){
            this.listAll = service.selectLike(name,0,3);
            page = 1;
        }
        int min = (page - 1) * 3;
        int max = 3;
        if(name==null && shang != null){
            name = (String)session.getAttribute("name");
            this.listAll = service.selectLike(name,min,max);
        }else if(name != null && shang == null){
            session.setAttribute("name",name);
            this.listAll = service.selectLike(name,0,3);
            page = 1;
        }else{
            this.listAll = service.selectLike(name,min,max);
            session.setAttribute("name",name);
        }
        model.addAttribute("page",this.listAll);
        model.addAttribute("name",name);
        model.addAttribute("shu",page);
        return "list3";
    }
}
