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

    <ul class="breadcrumb">
        <li><a href="/admin/login">首页</a> <span class="divider">/</span></li>
        <li><a href="/admin/pole">充电桩</a> <span class="divider">/</span></li>
        <li class="active">充电桩详情</li>
    </ul>

    <div class="header">
        <h1 class="page-title">${pole.poleName}</h1>
    </div>


    <div class="container-fluid">
        <div class="row-fluid">

            <div class="btn-toolbar">
                <a href="/admin/stations/${station.stationId}" class="btn btn-primary" id="btn_edit"><i
                        class="icon-save"></i> Edit</a>
                <a href="#myModal" data-toggle="modal" class="btn">Delete</a>
                <div class="btn-group">
                </div>
            </div>
            <div class="well">

                <p>充电桩名称 : ${pole.poleName}</p>
                <p>生产商 :
                <#switch pole.manufacturer_id>
                    <#case "MA1MDPK80">思度科技<#break >
                    <#case "783840483">云电科技<#break >
                    <#case "69839643X">江苏嘉钰新能源<#break >
                    <#default>${pole.manufacturer_id}
                </#switch>
                </p>


                <p>型号: <#switch pole.poleType>
                    <#case "DC" >直流<#break>
                    <#case "AC" >交流<#break>
                    <#case "DC_AND_AC" >交直流一体<#break>
                    <#case "WIRELESS" >无线<#break>
                    <#case "OTHER" >其他<#break>
                    <#default> 未知<#break>
                </#switch>
                </p>


                <p>功率: ${pole.power}</p>


                <p>经度: ${pole.poleLng}</p>
                <p>纬度: ${pole.poleLat}</p>


                <div class="well">
                    <h3>充电枪</h3>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>ID</th>
                            <th>名称</th>
                            <th>型号</th>
                            <th>标准</th>
                            <th style="width: 26px;"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list pole.connectors as connector>
                        <tr>
                            <td>${connector_index+1}</td>
                            <td>${connector.connectorId}</td>
                            <td><a href="/admin/stations/details/${connector.id}">${connector.connectorName}</a></td>
                            <td>
                                <span class="label label-sm label-info">
                                    <#--<#switch pole.poleType>-->
                                        <#--<#case "DC" >直流<#break>-->
                                        <#--<#case "AC" >交流<#break>-->
                                        <#--<#case "DC_AND_AC" >交直流一体<#break>-->
                                        <#--<#case "WIRELESS" >无线<#break>-->
                                        <#--<#case "OTHER" >其他<#break>-->
                                        <#--<#default> 未知<#break>-->
                                    <#--</#switch>-->
                                    ${connector.connectorType}
                                </span>
                            </td>
                            <td>
                            <#switch connector.nationalStandard>
                                <#case "1"><span class="label label-sm label-warning">2011</span><#break>
                                <#case "2"><span class="label label-sm label-warning">2015</span><#break>
                                <#default> 未知<#break>
                            </#switch>
                            </td>
                            <td>
                                <a href="/admin/stations/${station.stationId}"><i class="icon-pencil"></i></a>
                                <a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
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


