<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <title>Bootstrap Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="/lib/bootstrap/css/bootstrap.css">

    <link rel="stylesheet" type="text/css" href="/stylesheets/theme.css">
    <link rel="stylesheet" href="/lib/font-awesome/css/font-awesome.css">

    <script src="/lib/jquery-3.2.1.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height: 300px;
            width: 800px;
            margin: 0px auto;
            margin-top: 1em;
        }

        .brand {
            font-family: georgia, serif;
        }

        .brand .first {
            color: #ccc;
            font-style: italic;
        }

        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
</head>

<!--[if lt IE 7 ]>
<body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]>
<body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]>
<body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]>
<body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="">
<!--<![endif]-->

<#include "navbar.ftl">

<#include "sidebar-nav.html">


<div class="content">

    <div class="header">

        <h1 class="page-title">New Station</h1>
    </div>

    <ul class="breadcrumb">
        <li><a href="/admin/login">Home</a> <span class="divider">/</span></li>
        <li><a href="/admin/stations">Stations</a> <span class="divider">/</span></li>
        <li class="active">Station</li>
    </ul>

    <div class="container-fluid">
        <div class="row-fluid">

            <div class="btn-toolbar">
                <button class="btn btn-primary" id="btn_save"><i class="icon-save"></i> Save</button>
                <a href="/admin/stations" data-toggle="modal" class="btn">Delete</a>
                <div class="btn-group">
                </div>
            </div>
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane active in" id="home">
                    <form id="tab">
                        <div class="form-body">
                            <label>站点名称</label>
                            <input type="text" class="input-xlarge" id="stationName">

                            <label>运营商 ID</label>
                            <select name="operatorId" class="input-xlarge" id="operatorId">
                                <option value="MA1MDPK80">思度科技</option>
                                <option value="783840483">云电科技</option>
                            </select>

                            <label>设备生产商</label>
                            <select name="equipmentOwnerId" class="input-xlarge" id="equipmentOwnerId">
                                <option value="69839643X">江苏嘉钰新能源技术有限公司</option>
                            </select>

                            <label>地区编码</label>
                            <input type="text" class="input-xlarge" id="areaCode">

                            <label>地址</label>
                            <input type="text" class="input-xlarge" id="address">

                            <label>站点电话</label>
                            <input type="tel" class="input-xlarge" id="stationTel">

                            <label>平台服务电话</label>
                            <input type="tel" class="input-xlarge" id="serviceTel">

                            <label>站点类型</label>
                            <select name="stationType" class="input-xlarge" id="stationType">
                                <option value="1">公共</option>
                                <option value="50">个人</option>
                                <option value="100">公交（专用）</option>
                                <option value="101">环卫（专用）</option>
                                <option value="102">物流（专用）</option>
                                <option value="103">出租车（专用）</option>
                                <option value="255">其他</option>
                            </select>

                            <label>站点状态</label>
                            <select name="stationStatus" class="input-xlarge" id="stationStatus">
                                <option value="1">建设中</option>
                                <option value="5">关闭下线</option>
                                <option value="6">维护中</option>
                                <option value="10">正在审核</option>
                                <option value="11">审核未通过</option>
                                <option value="12">待审核</option>
                                <option value="50">正常使用</option>
                            </select>

                            <label>车位数量</label>
                            <input type="number" class="input-xlarge" id="parkNums">

                            <label>经度</label>
                            <input type="text" class="input-xlarge" id="stationLng">

                            <label>纬度</label>
                            <input type="text" class="input-xlarge" id="stationLat">

                            <label>站点引导</label>
                            <input type="text" class="input-xlarge" id="siteGuide">

                            <label>使用车型描述</label>
                            <input type="text" class="input-xlarge" id="matchCarsDesc">

                            <label>建设场所</label>
                            <select name="construction" class="input-xlarge" id="construction">
                                <option value="1">居民区</option>
                                <option value="2">公共机构</option>
                                <option value="3">企事业单位</option>
                                <option value="4">写字楼</option>
                                <option value="5">工业园区</option>
                                <option value="6">交通枢纽</option>
                                <option value="7">大型文体设施</option>
                                <option value="8">城市绿地</option>
                                <option value="9">大型建筑配建停车场</option>
                                <option value="10">路边停车位</option>
                                <option value="11">城际高速服务区</option>
                                <option value="255">其他</option>
                            </select>

                            <label>车位楼层以及数量信息</label>
                            <input type="text" class="input-xlarge" id="parkInfo">

                            <label>营业时间</label>
                            <input type="text" class="input-xlarge" id="busineHours">

                            <label>电费描述</label>
                            <input type="text" class="input-xlarge" id="electricityFeeDesc">

                            <label>服务费描</label>
                            <input type="text" class="input-xlarge" id="serviceFeeDesc">

                            <label>停车费描述</label>
                            <input type="text" class="input-xlarge" id="parkFeeDesc">

                            <label>支付方式</label>
                            <input type="text" class="input-xlarge" id="paymentType">

                            <label>备注</label>
                            <input type="text" class="input-xlarge" id="remark">

                        </div>
                    </form>
                </div>
            </div>

            <div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">Delete Confirmation</h3>
                </div>
                <div class="modal-body">

                    <p class="error-text"><i class="icon-warning-sign modal-icon"></i>Are you sure you want to delete
                        the user?</p>
                </div>
                <div class="modal-footer">
                    <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
                    <button class="btn btn-danger" data-dismiss="modal">Delete</button>
                </div>
            </div>


            <footer>
                <hr>
                <!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
                <p class="pull-right">A <a href="http://www.portnine.com/bootstrap-themes" target="_blank">Free
                    Bootstrap Theme</a> by <a href="http://www.portnine.com" target="_blank">Portnine</a></p>


                <p>&copy; 2012 <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
            </footer>

        </div>
    </div>
</div>


<script src="/lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
    $("[rel=tooltip]").tooltip();
    $(function () {
        $('.demo-cancel-click').click(function () {
            return false;
        });
    });
</script>

<script>
    $(document).ready(function () {
        $("#btn_save").click(function () {
            $.post("/admin/stations",
                    {
                        stationName: $("#stationName").val(),
                        operatorId: $("#operatorId").val(),
                        equipmentOwnerId: $("#equipmentOwnerId").val(),
                        countryCode: "cn",
                        areaCode: $("#areaCode").val(),
                        address: $("#address").val(),
                        stationTel: $("#stationTel").val(),
                        serviceTel: $("#serviceTel").val(),
                        stationType: $("#stationType").val(),
                        stationStatus: $("#stationStatus").val(),
                        construction: $("#construction").val(),
                        parkNums: $("#parkNums").val(),
                        stationLng: $("#stationLng").val(),
                        stationLat: $("#stationLat").val(),
                        siteGuide: $("#siteGuide").val(),
                        parkInfo: $("#parkInfo").val(),
                        matchCarsDesc: $("#matchCarsDesc").val(),
                        busineHours: $("#busineHours").val(),
                        electricityFeeDesc: $("#electricityFeeDesc").val(),
                        serviceFeeDesc: $("#serviceFeeDesc").val(),
                        parkFeeDesc: $("#parkFeeDesc").val(),
                        paymentType: $("#paymentType").val(),
                        supportOrder: false,
                        remark: $("#remark").val()
                    }, function (data, status) {
                        var res = $.parseJSON(data);
                        if (res.Ret != 0) {
                            alert(res.Msg);
                        }
                        else {
                            alert("界面跳转");
                            window.location.href = "/admin/stations";
                        }
                    });
        });
    });
</script>

</body>
</html>


