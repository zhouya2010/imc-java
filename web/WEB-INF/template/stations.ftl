<!DOCTYPE html>
<html lang="en">
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

    <script src="/lib/jquery-1.7.2.min.js" type="text/javascript"></script>

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

        <h1 class="page-title">Station</h1>
    </div>

    <ul class="breadcrumb">
        <li><a href="index.html">首页</a> <span class="divider">/</span></li>
        <li class="active">站点</li>
    </ul>

    <div class="container-fluid">
        <div class="row-fluid">

            <div class="btn-toolbar">
                <a href="/admin/stations/new">
                    <button class="btn btn-primary"><i class="icon-plus"></i></button>
                </a>

                <form id="search" style="margin: 0px;display: inline" class="form-inline" action="/admin/stations"
                      method="get">
                    <button type="submit" class="btn" id="btn_search"><i class="icon-search"></i></button>
                    <input type="text" name="stationName" class="search-query" id="input_search"/>
                </form>
            </div>
            <div class="well">
                <table class="table">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>名称</th>
                        <th>充电桩个数</th>
                        <th>地址</th>
                        <th>类型</th>
                        <th>状态</th>
                        <th style="width: 26px;"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list stations as station>
                    <tr>
                        <td>${station_index+1 + page * size}</td>
                        <td><a href="/admin/stations/details/${station.stationId}">${station.stationName}</a></td>
                        <td>${station.poles?size}</td>
                        <td>${station.address}</td>
                        <td>
                            <#switch station.stationType>
                                <#case "SOCIETY">公共<#break >
                                <#case "INDIVIDUAL" >个人<#break >
                                <#case "BUS">公交（专用）<#break >
                                <#case "SANITATION">环卫（专用）<#break >
                                <#case "LOGISTICS">物流（专用）<#break >
                                <#case "TAXI" >出租车（专用）<#break >
                                <#case "OTHER">物流（专用）<#break >
                                <#default>${station.stationType}
                            </#switch>
                        </td>
                        <td>
                            <#switch station.stationStatus>
                                <#case "UNDER_CONSTRUCT"><span class="label muted">建设中</span><#break >
                                <#case "CLOSE" ><span class="label label-important">关闭下线</span><#break >
                                <#case "MAINTAIN" > 维护中<#break >
                                <#case "REVIEWING" > 正在审核<#break >
                                <#case "REJECT" ><span class="label label-important">审核未通过</span><#break >
                                <#case "PENDING_REVIEW"><span class="label label-warning">待审核</span><#break >
                                <#case "USING" ><span class="label label-success">正常使用</span><#break >
                                <#default><span class="label label-info">未知</span>
                            </#switch>
                        </td>
                        <td>
                            <a href="/admin/stations/${station.stationId}"><i class="icon-pencil"></i></a>
                        <#--<a href="#myModal" role="button"  data-toggle="modal"><i class="icon-remove"></i></a>-->
                            <a stationId="${station.stationId}" class="station-close"><i class="icon-remove"></i></a>
                        </td>
                    </tr>
                    </#list>

                    </tbody>
                </table>
            </div>
            <div class="pagination">
                <ul>
                    <li><a href="/admin/stations?page=<#if page == 0> 0 <#elseif (page > 0)>${page - 1}</#if>">Prev</a>
                    </li>
                <#list 1 .. total as  x>
                    <li><a href="/admin/stations?page=${x -1}">
                        <#if x-1 == page>
                            <b>${x}</b>
                        <#else>
                        ${x}
                        </#if>
                    </a></li>
                </#list>
                    <li>
                        <a href="/admin/stations?page=<#if (page >= total -1)>${total -1}<#else >${page + 1}</#if>">Next</a>
                    </li>
                </ul>
            </div>

            <div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">Delete Confirmation</h3>
                </div>
                <div class="modal-body">
                    <p class="error-text"><i class="icon-warning-sign modal-icon"></i>Are you sure you want to delete
                        the station?</p>
                </div>
                <div class="modal-footer">
                    <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
                <#--<button class="btn btn-danger" data-dismiss="modal">Delete</button>-->
                    <button id="delete" class="btn btn-danger">Delete</button>
                </div>
            </div>
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
    $(function () {

        var temp_station_id;

        $('.station-close').unbind('click').click(function () {
            temp_station_id = $(this).attr('stationId');
            console.log(temp_station_id);
            $('#myModal').modal('show');
        });

        $("#delete").click(function () {
            console.log(temp_station_id);
//            $('#myModal').modal('hide');
            $.ajax({
                url: "/admin/stations/"+temp_station_id,
                type: "DELETE",
                success:function (data, status) {
                    var jsonObj = JSON.parse(data);
                    alert(jsonObj.Msg);
                    if(jsonObj.Ret == 0) {
                        window.location.href="/admin/stations"
                    }
                    $('#myModal').modal('hide');
                }
            });
        })
    });
</script>

</body>
</html>


