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

<#--<script src="/lib/jquery-1.7.2.min.js" type="text/javascript"></script>-->
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

        <h1 class="page-title">Edit Station</h1>
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
                <a href="#myModal" data-toggle="modal" class="btn">Delete</a>
                <div class="btn-group">
                </div>
            </div>
            <div class="well">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#home" data-toggle="tab">Profile</a></li>
                    <li><a href="#profile" data-toggle="tab">Password</a></li>
                </ul>
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane active in" id="home">
                        <form id="tab">
                            <label>站点名称</label>
                            <input type="text" class="input-xlarge" id="stationName" value="${station.stationName}">

                            <label>运营商 ID</label>
                            <select name="operatorId" class="input-xlarge" id="operatorId">
                                <option value="MA1MDPK80" <#if station.operatorId == "MA1MDPK80" >
                                        selected="selected"</#if>>思度科技
                                </option>
                                <option value="783840483" <#if station.operatorId == "783840483" >
                                        selected="selected"</#if>>云电科技
                                </option>
                            </select>

                            <label>设备生产商</label>
                            <select name="equipmentOwnerId" class="input-xlarge" id="equipmentOwnerId">
                                <option value="69839643X" <#if station.equipmentOwnerId == "69839643X" > selected="selected"</#if>> 江苏嘉钰新能源技术有限公司</option>
                            </select>

                            <label>地区编码</label>
                            <input type="text" class="input-xlarge" id="areaCode" value="${station.areaCode}">

                            <label>地址</label>
                            <input type="text" class="input-xlarge" id="address" value="${station.address}">

                            <label>站点电话</label>
                            <input type="tel" class="input-xlarge" id="stationTel" value="${station.stationTel}">

                            <label>平台服务电话</label>
                            <input type="tel" class="input-xlarge" id="serviceTel" value="${station.serviceTel}">

                            <label>站点类型</label>
                            <select name="stationType" class="input-xlarge" id="stationType">
                                <option value="1" <#if station.stationType == "1" > selected="selected"</#if> >公共</option>
                                <option value="50" <#if station.stationType == "50" > selected="selected"</#if> >个人</option>
                                <option value="100" <#if station.stationType == "100" > selected="selected"</#if> >公交（专用）</option>
                                <option value="101" <#if station.stationType == "101" > selected="selected"</#if> >环卫（专用）</option>
                                <option value="102" <#if station.stationType == "102" > selected="selected"</#if> >物流（专用）</option>
                                <option value="103" <#if station.stationType == "103" > selected="selected"</#if> >出租车（专用）</option>
                                <option value="255" <#if station.stationType == "255" > selected="selected"</#if> >其他</option>
                            </select>

                            <label>站点状态</label>
                            <select name="stationStatus" class="input-xlarge" id="stationStatus">
                                <option value="1" <#if station.stationStatus == "1" > selected="selected"</#if> >建设中</option>
                                <option value="5" <#if station.stationStatus == "5" > selected="selected"</#if> >关闭下线</option>
                                <option value="6" <#if station.stationStatus == "6" > selected="selected"</#if> >维护中</option>
                                <option value="10" <#if station.stationStatus == "10" > selected="selected"</#if> >正在审核</option>
                                <option value="11" <#if station.stationStatus == "11" > selected="selected"</#if> >审核未通过</option>
                                <option value="12" <#if station.stationStatus == "12" > selected="selected"</#if> >待审核</option>
                                <option value="50" <#if station.stationStatus == "50" > selected="selected"</#if> >正常使用</option>
                            </select>

                            <label>车位数量</label>
                            <input type="number" class="input-xlarge" id="parkNums" value="${station.parkNums}">

                            <label>经度</label>
                            <input type="text" class="input-xlarge" id="stationLng" value="${station.stationLng}">

                            <label>纬度</label>
                            <input type="text" class="input-xlarge" id="stationLat" value="${station.stationLat}">

                            <label>站点引导</label>
                            <input type="text" class="input-xlarge" id="siteGuide" value="${station.siteGuide}">

                            <label>使用车型描述</label>
                            <input type="text" class="input-xlarge" id="matchCarsDesc" value="${station.matchCarsDesc}">

                            <label>建设场所</label>
                            <select name="construction" class="input-xlarge" id="construction">
                                <option value="1" <#if station.construction == 1> selected="selected"</#if>>居民区</option>
                                <option value="2" <#if station.construction == 2> selected="selected"</#if>>公共机构
                                </option>
                                <option value="3" <#if station.construction == 3> selected="selected"</#if>>企事业单位
                                </option>
                                <option value="4"<#if station.construction == 4> selected="selected"</#if>>写字楼</option>
                                <option value="5"<#if station.construction == 5> selected="selected"</#if>>工业园区</option>
                                <option value="6"<#if station.construction == 6> selected="selected"</#if>>交通枢纽</option>
                                <option value="7"<#if station.construction == 7> selected="selected"</#if>>大型文体设施
                                </option>
                                <option value="8"<#if station.construction == 8> selected="selected"</#if>>城市绿地</option>
                                <option value="9"<#if station.construction == 9> selected="selected"</#if>>大型建筑配建停车场
                                </option>
                                <option value="10"<#if station.construction == 10> selected="selected"</#if>>路边停车位
                                </option>
                                <option value="11"<#if station.construction == 11> selected="selected"</#if>>城际高速服务区
                                </option>
                                <option value="255"<#if station.construction == 255> selected="selected"</#if>>其他
                                </option>
                            </select>

                            <label>车位楼层以及数量信息</label>
                            <input type="text" class="input-xlarge" id="parkInfo" value="${station.parkInfo}">

                            <label>营业时间</label>
                            <input type="text" class="input-xlarge" id="busineHours" value="${station.busineHours}">

                            <label>电费描述</label>
                            <input type="text" class="input-xlarge" id="electricityFeeDesc"
                                   value="${station.electricityFeeDesc}">

                            <label>服务费描</label>
                            <input type="text" class="input-xlarge" id="serviceFeeDesc"
                                   value="${station.serviceFeeDesc}">

                            <label>停车费描述</label>
                            <input type="text" class="input-xlarge" id="parkFeeDesc" value="${station.parkFeeDesc}">

                            <label>支付方式</label>
                            <input type="text" class="input-xlarge" id="paymentType" value="${station.paymentType}">

                            <label>备注</label>
                            <input type="text" class="input-xlarge" id="remark" value="${station.remark}">
                        </form>
                    </div>
                    <div class="tab-pane fade" id="profile">
                        <form id="tab2">
                            <label>New Password</label>
                            <input type="password" class="input-xlarge">
                            <div>
                                <button class="btn btn-primary">Update</button>
                            </div>
                        </form>
                    </div>
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
    var station = {
        stationId:${station.stationId},
        stationName: $("#stationName").val(),
        operatorId: $("#operatorId").val(),
        equipmentOwnerId: $("#equipmentOwnerId").val(),
        areaCode: $("#areaCode").val(),
    }

    $(document).ready(function () {
        $("#btn_save").click(function () {
            $.post("/admin/stations", station,
                    function (data, status) {
                        alert("数据: \n" + data);
                    });
        });
    });
</script>

</body>
</html>


