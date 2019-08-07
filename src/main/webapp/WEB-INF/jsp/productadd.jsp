<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/8/7
  Time: 1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"  language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<h1>添加类别</h1>



<form action="" method="post">


    类别Id:
    <%--<input type="text" name="categoryId">--%>
    <select name="categoryId">
        <option value="" style="display: none"></option>
        <option value="0">0</option>
        <option value="1">1</option>
        <option value="2">2</option>
    </select>
    <br/>
    商品名称:<input type="text" name="name"><br/>
    商品副标题:<input type="text" name="subtitle"><br/>
    商品主图:<input type="text" name="mainImage"><br/>
    图片地址:<input type="text" name="subImages"><br/>
    商品详情:<input type="text" name="detail"><br/>
    价格:<input type="text" name="price"><br/>
    库存数量:<input type="text" name="stock"><br/>
    商品状态:
   <%-- <input type="text" name="status">--%>
    <select name="status">
        <option value="1">1-在售</option>
        <option value="2">2-下架</option>
        <option value="3">3-删除</option>
    </select>
    <br/>
    <input type="submit"  value="添加"><br/>

</form>

</body>
</html>
