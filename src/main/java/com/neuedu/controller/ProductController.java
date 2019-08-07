package com.neuedu.controller;

import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/user/product/")
public class ProductController {
    @Autowired
    IProductService productService;

    @RequestMapping("findproduct")
    public  String  findAll(HttpSession session){

        List<Product> productList=productService.findAll();

        session.setAttribute("productlist",productList);
        return "productlist";
    }


    @RequestMapping(value = "productupdate/{id}",method = RequestMethod.GET)
    public  String  update(@PathVariable("id") Integer productId, HttpServletRequest request){


        Product product=productService.findProductById(productId);

        request.setAttribute("product",product);

        return "productupdate";
    }

    @RequestMapping(value = "productupdate/{id}",method = RequestMethod.POST)
    public  String  update(Product product, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("GBK");

        //
        int count= productService.updateProduct(product);

        if(count>0){
            //修改成功
            return "redirect:/user/product/findproduct";
        }

        return "productupdate";
    }

    //删除类别
    @RequestMapping(value = "productdelete/{id}",method = RequestMethod.GET)
    public  String  delete(@PathVariable("id") Integer productId, HttpServletRequest request){


        int product_result = productService.deleteProduct(productId);

        return "redirect:/user/product/findproduct";
    }

    //添加类别
    @RequestMapping(value = "productadd",method = RequestMethod.GET)
    public String addProduct(){
        return "productadd";
    }

    @RequestMapping(value = "productadd",method = RequestMethod.POST)
    public  String  addProduct(Product product, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("GBK");
        int count= productService.addProduct(product);

        if(count>0){
            //添加成功
            return "redirect:/user/product/findproduct";
        }

        return "productadd";
    }
}
