<%--
  Created by IntelliJ IDEA.
  User: Neuedu
  Date: 2019/8/6
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"  language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>修改类别</h1>



<form action="" method="post">

    <input type="hidden" name="id" value="${product.id}"><br/>
    类别Id:<input type="text" name="categoryId" value="${product.categoryId}"><br/>
    商品名称:<input type="text" name="name" value="${product.name}"><br/>
    商品副标题:<input type="text" name="subtitle" value="${product.subtitle}"><br/>
    商品主图:<input type="text" name="mainImage" value="${product.mainImage}"><br/>
    图片地址:<input type="text" name="subImages" value="${product.subImages}"><br/>
    商品详情:<input type="text" name="detail" value="${product.detail}"><br/>
    价格:<input type="text" name="price" value="${product.price}"><br/>
    库存数量:<input type="text" name="stock" value="${product.stock}"><br/>
    商品状态:<input type="text" name="status" value="${product.status}"><br/>
    <input type="submit"  value="确认"><br/>

</form>


</body>
</html>
