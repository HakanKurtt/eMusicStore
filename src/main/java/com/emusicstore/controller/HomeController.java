package com.emusicstore.controller;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.*;

@Controller
public class HomeController {


    private Path path;

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/productList")
    public String getProductList(Model model){
        List<Product> products=productDao.getAllProducts();

        model.addAttribute("products",products);


        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) throws IOException {

        Product product = productDao.getProductById(productId);
        model.addAttribute(product);

        return "viewProduct";
    }

    @RequestMapping("/admin")
    public String adminPage(){

        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model){
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);

        return "productInventory";

    }

    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model){
        Product product=new Product();

        product.setProductCategory("instrument");
        product.setProductCondition("new");
        product.setProductStatus("active");

        model.addAttribute(product);

        return "addProduct";
    }

    @RequestMapping(value="/admin/productInventory/addProduct", method= RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product") Product product, HttpServletRequest request){
        productDao.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        //Proje yolunu kaydediyoruz.
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        //resim icin isim olusturup kaydedileceği path'i belirliyoruz.
        path = Paths.get(rootDirectory+ "\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");

        //Eger productImage bos veya null degilse tipini png'ye donustur ardından olusturulan path ve isimle kaydet.
        if(productImage != null && !productImage.isEmpty()){
            try{
                productImage.transferTo(new File(path.toString()));
            }catch(Exception e){
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed.");
            }
        }

        //redirect, springe gönderilenin bir string değil bir path olduğunu söyler.
        return "redirect:/admin/productInventory";

    }


    @RequestMapping("/admin/productInventory/updateProduct/{productId}")
    public String updateProduct(@PathVariable String productId, Model model){
        Product product = productDao.getProductById(productId);

        model.addAttribute(product);

        return "updateProduct";

    }

    @RequestMapping(value = "/admin/productInventory/updateProduct", method = RequestMethod.POST)
    public String updateProductPost(@ModelAttribute("product") Product product, HttpServletRequest request){



        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path  = Paths.get(rootDirectory+"\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");

        if(productImage != null && !productImage.isEmpty()){
            try{
                productImage.transferTo(new File(path.toString()));
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        productDao.updateProduct(product);

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable String productId, Model model, HttpServletRequest request) {

        //Proje yolunu kaydediyoruz.
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        //resim icin isim olusturup kaydedileceği path'i belirliyoruz.
        path = Paths.get(rootDirectory+ "\\WEB-INF\\resources\\images\\"+productId+".png");

        if(Files.exists(path)){
            try{
                Files.delete(path);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        productDao.deleteProduct(productId);

        return "redirect:/admin/productInventory";
    }
}
