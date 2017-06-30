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

        <h1 class="page-title">充电桩</h1>
    </div>

    <ul class="breadcrumb">
        <li><a href="index.html">首页</a> <span class="divider">/</span></li>
        <li class="active">充电桩</li>
    </ul>

    <div class="container-fluid">
        <div class="row-fluid">

            <div class="btn-toolbar">
                <a href="/admin/pole/new">
                    <button class="btn btn-primary"><i class="icon-plus"></i></button>
                </a>

                <form id="search" style="margin: 0px;display: inline" class="form-inline" action="/admin/pole" method="get">
                    <button type="submit" class="btn" id="btn_search"><i class="icon-search"></i></button>
                    <input type="text" name="poleId" class="search-query" id="input_search"/>
                </form>
            </div>
            <div class="well">
                <table class="table">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>充电桩ID</th>
                        <th>名称</th>
                        <th>类型</th>
                        <th>所属站点</th>
                        <th style="width: 26px;"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list poles as pole>
                    <tr>
                        <td>${pole_index+1 + page * size}</td>
                        <td><a href="/admin/pole/details/${pole.id}">${pole.poleId}</a></td>
                        <td>${pole.poleName}</td>
                        <td>
                                <span class="label label-sm label-info">
                                    <#switch pole.poleType>
                                        <#case "DC" >直流<#break>
                                        <#case "AC" >交流<#break>
                                        <#case "DC_AND_AC" >交直流一体<#break>
                                        <#case "WIRELESS" >无线<#break>
                                        <#case "OTHER" >其他<#break>
                                        <#default> 未知<#break>
                                    </#switch>
                                </span>
                        </td>
                        <td>
                            <a href="/admin/stations/details/${pole.station.stationId}">${pole.station.stationName}</a>
                        </td>
                        <td>
                            <a href="/admin/pole/${pole.poleId}"><i class="icon-pencil"></i></a>
                            <a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
                        </td>
                    </tr>
                    </#list>

                    </tbody>
                </table>
            </div>
            <div class="pagination">
                <ul>
                    <li><a href="/admin/pole?page=<#if page == 0> 0 <#elseif (page > 0)>${page - 1}</#if>">Prev</a>
                    </li>
                <#list 1 .. total as  x>
                    <li><a href="/admin/pole?page=${x -1}">
                        <#if x-1 == page>
                            <b>${x}</b>
                        <#else>
                        ${x}
                        </#if>
                    </a></li>
                </#list>
                    <li>
                        <a href="/admin/pole?page=<#if (page >= total -1)>${total -1}<#else >${page + 1}</#if>">Next</a>
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
                    <button class="btn btn-danger" data-dismiss="modal">Delete</button>
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

<#--<script>-->
<#--$(document).ready(function () {-->
<#--$("#btn_search").click(function () {-->
<#--$.get("/admin/stations",-->
<#--{-->
<#--stationName:$("#input_search").val()-->
<#--}, function (data, status) {-->
<#--alert(data);-->
<#--});-->
<#--});-->
<#--});-->
<#--</script>-->

</body>
</html>


