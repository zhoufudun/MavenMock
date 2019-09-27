<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>主页</title>
<meta name="viewport" content="width=device-width,initial-scale=1" />
<link href="${pageContext.request.contextPath}/static/jquery.mobile-1.4.5/jquery.mobile-1.4.5.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery.mobile-1.4.5/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery.mobile-1.4.5/jquery.mobile-1.4.5.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery-3.1.1.js"></script>
<script src="${pageContext.request.contextPath}/static/jquery/echarts-2.2.7/build/dist/echarts.js"></script>
<title>主页</title>
<script type="text/javascript">
		////
		var orderNumberArray=[];//工单
		var machineArray=[];//机器编号
		$(document).ready(function() {						
			<c:forEach var="order" items="${orderList}">
			    orderNumberArray.push('${order.orderNumber}');					
			</c:forEach>
			<c:forEach var="machine" items="${machineList}">
				machineArray.push('${machine.code}');					
		   </c:forEach>
		   
		});	    
		////
			
        require.config({
            paths: {
                echarts: '${pageContext.request.contextPath}/static/jquery/echarts-2.2.7/build/dist'
            }
        });      
        require(
                [
                    'echarts',
                    'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
                ],
                function (ec) {
                    // 基于准备好的dom，初始化echarts图表
                    var myChart = ec.init(document.getElementById('second')); 
                    var label={
        	                normal: {
        	                    show: true,
        	                    position: 'insideRight'
        	                }
        	        };
                    var type="bar";
                    vat stack="总量";
                    var option = {
                    	    tooltip : {
                    	        trigger: 'axis',
                    	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    	        }
                    	    },
                    	    legend: {
                    	        data: orderNumberArray //工单个数（工单号）
                    	    },
                    	    grid: {
                    	        left: '3%',
                    	        right: '4%',
                    	        bottom: '3%',
                    	        containLabel: true
                    	    },
                    	    xAxis:  {
                    	        type: 'value'
                    	    },
                    	    yAxis: {
                    	        type: 'category',
                    	        data: machineArray //机器台数
                    	    },
                    	    series: [
                    	        {
                    	            name: '直接访问',
                    	            type: type,
                    	            stack: stack,
                    	            label: label,
                    	            data: [100, 0, 0, 0, 0, 0]
                    	        },
                    	        {
                    	            name: '邮件营销',
                    	            type: type,
                    	            stack: stack,
                    	            label: label,
                    	            data: [0, 132, 0, 0, 0, 0]
                    	        },
                    	        {
                    	            name: '联盟广告',
                    	            type: type,
                    	            stack: stack,
                    	            label: label,
                    	            data: [0, 0, 191, 0, 0, 0]
                    	        },
                    	        {
                    	            name: '视频广告',
                    	            type: type,
                    	            stack: stack,
                    	            label: label,
                    	            data: [0, 0, 0, 154, 0, 0]
                    	        },
                    	        {
                    	            name: '搜索引擎',
                    	            type: type,
                    	            stack: stack,
                    	            label: label,
                    	            data: [0, 0, 0, 0,185, 0]
                    	        },
                    	        {
                    	            name: 'dddd',
                    	            type: type,
                    	            stack: stack,
                    	            label: label,
                    	            data: [0, 0, 0, 0, 0, 200]
                    	        },{
                    	            name: 'cccc',
                    	            type: type,
                    	            stack: stack,
                    	            label: label,
                    	            data: [120, 0, 0, 0, 0, 0]
                    	        },{
                    	            name: 'eeee',
                    	            type: type,
                    	            stack: stack,
                    	            label: label,
                    	            data: [0, 120, 0, 0, 0, 0]
                    	        }
                    	    ]
                    	};     
                    // 为echarts对象加载数据 
                    myChart.setOption(option); 
                }
            );
   /*     //第一个图标刷新
        function refreshUp(){			
        	var arr=[];   
        	///ajax获取数据
        	$.ajax({
        		type:"POST",
        		url:"${pageContext.request.contextPath}/totalWorkDetail/getTotalWorkDetail.do",
        		async : false, //同步执行                	            		
        		data:"",//给服务器传数据
        		dataType:"json",//返回数据形式为json
        		success:function(result){          	
        			if(result.success){            	     	            	            	            	            				
            				arr.push({													
    							name:"总计划生产量",
    							value:result.getresult[0].totalPlayProNum
    						});
            				arr.push({													
    							name:"总实际生产量",
    							value:result.getresult[0].totalInfactProNum
    						});
            				           	 	            	            				
    					}else{
    						alert(result.errorMsg);
    					}	
        		},
        		error:function(errorMsg){
        			if(alert_count>2){
        				return ;
        			}
        			alert_count++;
        			alert("不好意思,图表请求数据失败啦!");
        			return false;
        			myChart.hideLoading();
        		}
        	});
        	//更新数据       
        	var option = myChart.getOption();            	
            option.series[0].data =arr;   
            myChart.setOption(option); 
		} 
		////////////////函数30秒执行一次
    	function autoRefresh()
    	{
    		refreshUp();
    	}
    	setInterval('autoRefresh()',6000);	
    	
    	*/
    	
</script>
<style type="text/css">
	#pie{
		box-shadow:-5px 5px 5px white;
	}
    #Equipment-HouseKeeper-images{
   		border-radius:8px 8px 8px 8px;
    }
</style>
</head>
<body>
	<div data-role="page">
		  <div data-role="header"  data-position="fixed">
		    <a href="${pageContext.request.contextPath}/admin/orderManage/productDispatch.do" rel="external" data-role="button" data-icon="arrow-l" data-iconpos="notext"></a>
    			<h1>排产结果</h1>
    		<a href="#" data-role="button" data-icon="grid" data-iconpos="notext"></a>
		  </div>
		
		  <div data-role="content" align="center">
		  		<table  width="100%" height="425" align="center" border="0" cellpadding="0" cellspacing="2" style="border-radius:0px;">
					<tr>
						<td bgcolor="#F6F6F6" align="center" >
							<div style="height:400px; border:solid 1px black; width:94%;border-radius:8px 8px 8px 8px; background-color:white;">	
								<div style="height:20px;">
									<div style="float:left; padding-left:15px;"><img src="${pageContext.request.contextPath}/static/images/15.png"></div>	
									<div style="font-size:16px;font-weight:bold;float:left;margin-top:3px;">甘特图排产结果</div>	
								</div>								
						        <hr style="border:solid 1px #F6F6F6;margin-top:10px;">
								<div id="second" style="height:400px; width:95%; margin-top:-30px;" >
									
								</div>
										
							</div>
						</td>	
					</tr>
					
											
				</table>				
		  </div>	
					
		  <div data-role="footer" data-position="fixed">
		    	<div data-role="navbar">
				   <ul>
				       <li><a href="${pageContext.request.contextPath}/user/zhuye.jsp" rel="external" data-icon="home" data-mini="true">首页</a></li>
				       <li><a href="#" data-icon="search" data-mini="true">搜索</a></li>
				       <li><a href="#" data-icon="info" data-mini="true">消息</a></li>
				   </ul>
			  </div>
		  </div>
	</div>	
	
</body>


</html>