package com.neuedu.controller;

import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

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
    public  String  update(@RequestParam("picfile")MultipartFile uploadFile,Product product, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("GBK");
        if(uploadFile!=null){

            String uuid = UUID.randomUUID().toString();
            //获取扩展名
            String fileName = uploadFile.getOriginalFilename();
            product.setMainImage(fileName);
            System.out.println("===filename="+fileName+"===");
            String extraName = fileName.substring(fileName.lastIndexOf("."));

            String newFileName = uuid+extraName;
            System.out.println("===新名="+newFileName+"===");

            product.setSubImages("D:\\upload\\"+newFileName);
            File file = new File("D:\\upload");
            if(!file.exists()){
                file.mkdir();
            }
            File newFile = new File(file,newFileName);

            try {
                uploadFile.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
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
    public  String  addProduct(@RequestParam("pic")MultipartFile uploadFile,Product product, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("GBK");

        if(uploadFile!=null){

            String uuid = UUID.randomUUID().toString();
            //获取扩展名
            String fileName = uploadFile.getOriginalFilename();
            product.setMainImage(fileName);
            System.out.println("===filename="+fileName+"===");
            String extraName = fileName.substring(fileName.lastIndexOf("."));

            String newFileName = uuid+extraName;
            System.out.println("===新名="+newFileName+"===");

            product.setSubImages("D:\\upload\\"+newFileName);
            File file = new File("D:\\upload");
            if(!file.exists()){
                file.mkdir();
            }
            File newFile = new File(file,newFileName);

            try {
                uploadFile.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        int count= productService.addProduct(product);

        if(count>0){
            //添加成功
            return "redirect:/user/product/findproduct";
        }

        return "productadd";
    }
}
