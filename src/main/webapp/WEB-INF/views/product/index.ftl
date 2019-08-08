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
                    <form role="form" method="post" action="" enctype="multipart/form-data">

                        <div class="form-group">
                            <label>类别Id</label>
                            <select name="categoryId" class="form-control">
                                <option value="" style="display: none"></option>
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>商品名称</label>
                            <input type="text" name="name" class="form-control"  value="${product.name}"/>
                        </div>

                        <div class="form-group">
                            <label>商品副标题</label>
                            <input type="text" name="subtitle" class="form-control"  value="${product.subtitle}"/>
                        </div>

                        <div class="form-group">
                            <label>商品详情</label>
                            <input type="text" name="detail" class="form-control"  value="${product.detail}"/>
                        </div>

                        <div class="form-group">
                            <label>价格</label>
                            <input type="text" name="price" class="form-control"  value="${product.price}"/>
                        </div>

                        <div class="form-group">
                            <label>库存</label>
                            <input name="stock" type="text" class="form-control" value="${product.stock}"/>
                        </div>

                        <div class="form-group">
                            <label>商品状态</label>
                            <select name="status" class="form-control">
                                <option value="" style="display: none"></option>
                                <option value="1">1-在售</option>
                                <option value="2">2-下架</option>
                                <option value="3">3-删除</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>图片上传</label>
                            <input id="productIcon" name="productIcon" type="text" hidden="hidden" value="${(productInfo.productIcon)!''}"/>

                            <div class="file-loading">
                                <input id="input-id" type="file"  name="picfile">
                                <p class="help-block">支持jpg、jpeg、png、gif格式，大小不超过1M</p>
                            </div>
                        </div>
                        <input type="hidden" name="mainImage" value="${product.mainImage}"><br/>
                        <input type="hidden" name="subImages" value="${product.subImages}"><br/>
                        <input type="hidden" name="id" value="${product.id}"><br/>
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/fileinput.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/locales/zh.min.js"></script>
<script>

    $(function () {
        var initialPreview = [];
        if ('${(productInfo.productIcon)!""}' != '') {
            initialPreview = "<img class='kv-preview-data file-preview-image' src='${(productInfo.productIcon)!""}'>"
        }

        $("#input-id").fileinput({
            uploadUrl: '/sell/image/upload',
            language: 'zh',
            browseClass: "btn btn-primary btn-block",
            showCaption: false,
            showRemove: false,
            showUpload: false,
            allowedFileExtensions: [ 'jpg', 'jpeg', 'png', 'gif' ],
            maxFileSize: 1024,
            autoReplace: true,
            overwriteInitial: true,
            maxFileCount: 1,
            initialPreview: initialPreview,
        });
    });
    //上传完成设置表单内容
    $('#input-id').on('fileuploaded', function(event, data, previewId, index) {
        if (data.response.code != 0) {
            alert(data.response.msg)
            return
        }
        $('#productIcon').val(data.response.data.fileName)
    });
</script>
</body>
</html>