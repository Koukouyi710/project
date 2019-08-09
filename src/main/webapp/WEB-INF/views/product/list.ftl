<html>
<#include "common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "common/nav.ftl">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <label>在架商品</label>
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>商品Id</th>
                            <th>类别Id</th>
                            <th>商品名称</th>
                            <th>商品副标题</th>
                            <th>商品主图</th>
                            <th>图片地址</th>
                            <th>商品详情</th>
                            <th>价格</th>
                            <th>库存数量</th>
                            <th>商品状态</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list productlist as product>
                        <#if "${product.status}"==1>
                            <tr>
                                <td width="80">${product.id}</td>
                            <#assign checkcategoryId="${product.categoryId}"/>
                            <#if checkcategoryId==0>
                                    <td width="100">${product.categoryId}-无父类</td>
                            </#if>
                            <#list categorylist as category>
                                <#if checkcategoryId==category.id>
                                    <td width="100">${product.categoryId}-${category.name}</td>
                                </#if>
                            </#list>
                            <#--<td>${product.categoryId}</td>-->
                                <td width="100">${product.name}</td>
                                <td width="100">${product.subtitle}</td>
                            <#--<td>${product.mainImage}</td>-->
                                <td><img height="100" width="100" src="${product.mainImage}" alt=""></td>
                                <td>${product.subImages}</td>
                                <td width="200">${product.detail}</td>
                                <td width="100">${product.price}</td>
                                <td width="100">${product.stock}</td>
                            <#assign checkstatus="${product.status}"/>
                             <#if checkstatus==1>
                                    <td width="120">${product.status}-在售</td>
                             </#if>
                            <#if checkstatus==2>
                                    <td width="120">${product.status}-下架</td>
                            </#if>
                            <#if checkstatus==3>
                                    <td width="120">${product.status}-删除</td>
                            </#if>
                            <#--<td>${product.status}</td>-->
                                <td width="200">${product.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                <td width="200">${product.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                <td width="50"><a href="/user/product/productupdate/${product.id}">修改</a>
                                    <a href="productdown/${product.id}" >下架</a>
                                </td>
                            </tr>
                        </#if>
                        </#list>
                        </tbody>
                    </table>

                <#--分页-->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="list.ftl?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..productInfoPage.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="list.ftl?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte productInfoPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="list.ftl?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                        </ul>
                    </div>


                    <label>未上架商品</label>
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>商品Id</th>
                            <th>类别Id</th>
                            <th>商品名称</th>
                            <th>商品副标题</th>
                            <th>商品主图</th>
                            <th>图片地址</th>
                            <th>商品详情</th>
                            <th>价格</th>
                            <th>库存数量</th>
                            <th>商品状态</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list productlist as product>
                        <#if "${product.status}"==2>
                            <tr>
                                <td width="80">${product.id}</td>
                            <#assign checkcategoryId="${product.categoryId}"/>
                            <#if checkcategoryId==0>
                                    <td width="100">${product.categoryId}-无父类</td>
                            </#if>
                            <#list categorylist as category>
                                <#if checkcategoryId==category.id>
                                    <td width="100">${product.categoryId}-${category.name}</td>
                                </#if>
                            </#list>
                            <#--<td>${product.categoryId}</td>-->
                                <td width="100">${product.name}</td>
                                <td width="100">${product.subtitle}</td>
                            <#--<td>${product.mainImage}</td>-->
                                <td><img height="100" width="100" src="${product.mainImage}" alt=""></td>
                                <td>${product.subImages}</td>
                                <td width="200">${product.detail}</td>
                                <td width="100">${product.price}</td>
                                <td width="100">${product.stock}</td>
                            <#assign checkstatus="${product.status}"/>
                             <#if checkstatus==1>
                                    <td width="120">${product.status}-在售</td>
                             </#if>
                            <#if checkstatus==2>
                                    <td width="120">${product.status}-下架</td>
                            </#if>
                            <#if checkstatus==3>
                                    <td width="120">${product.status}-删除</td>
                            </#if>
                            <#--<td>${product.status}</td>-->
                                <td width="200">${product.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                <td width="200">${product.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                <td width="50"><a href="/user/product/productupdate/${product.id}">修改</a>
                                    <a href="productup/${product.id}" >上架</a>
                                    <a href="productdelete/${product.id}" >删除</a>
                                </td>
                            </tr>
                        </#if>
                        </#list>
                        </tbody>
                    </table>
                </div>

            <#--分页-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="list.ftl?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..productInfoPage.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="list.ftl?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte productInfoPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="list.ftl?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>