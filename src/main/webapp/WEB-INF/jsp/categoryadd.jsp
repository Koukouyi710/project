<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/8/7
  Time: 1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script langauge='javascript'>
        function clock()
        {
            strTime = new Date();
        }
    </script>

</head>
<body>

<h1>添加类别</h1>



<form action="" method="post">

    类别名称<input type="text" name="name"><br/>
    父类id<input type="text" name="parentId"><br/>
    类别状态:<input type="text" name="status"><br/>
    排序编号:<input type="text" name="sort_order"><br/>
    <%--创建时间--%>
    <input type="hidden" name="create_time" value="2019-08-05 23:29:17"><br/>
    <%--最后一次更新时间--%>
    <input type="hidden" name="update_time" value=strTime><br/>
    <input type="submit"  value="添加"><br/>

</form>

</body>
</html>
