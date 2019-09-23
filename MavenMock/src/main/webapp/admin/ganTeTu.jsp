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
        var label;
        var type;
        var stack;
        var name;
        var seriesArray=[];//有几个工单就循环几次
        var orderNumberArray=[];//工单
		var machineArray=[];//机器编号
		var time2Array=[];//数组数组
		$(document).ready(function() {		//文档加载完毕后执行,内部不允许用//注释，不起作用		
			 
			 label={
                 normal: {
                    show: true,
                    position: 'insideRight'
                 }
              };
			 type="bar";
			 stack="总量";
			
			 <c:forEach var="order" items="${orderList}">
		     	orderNumberArray.push('${order.orderNumber}');					
			 </c:forEach>
			 
			 <c:forEach var="macNum" items="${macNumList}">
				 machineArray.push('${macNum.code}');					
		     </c:forEach>
		     
		     <c:forEach var="timeArray" items="${timeArrayList}" >
		     	 var array=[];
			     <c:forEach var="time" items="${timeArray}" >
			     	array.push("${time}");
				 </c:forEach>
				 	time2Array.push(array);
			 </c:forEach>
		    
		     <c:forEach var="order" items="${orderList}" varStatus="status">	     
			        var series={};
			     	series.name='${order.orderNumber}';
			     	series.type=type;
			     	series.stack=stack;
			     	series.label=label;
			     	var data=[];			     	
			     	data=time2Array[${status.index}];
			     	series.data=data;
			     	seriesArray.push(series);				
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
                    
                    var option = {
                    	    tooltip : {
                    	        trigger: 'axis',
                    	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    	        }
                    	    },
                    	    legend: {
                    	    	 x: 'center', // 'center' | 'left' | {number},
                    	         y: 'top', // 'center' | 'bottom' | {number}
                    	         padding: 2,
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
                    	    series: seriesArray
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
    			<h1>甘特图</h1>
    		<a href="#" data-role="button" data-icon="grid" data-iconpos="notext"></a>
		  </div>
		
		  <div data-role="content" align="center">
		  		<table  width="100%" height="440" align="center" border="0" cellpadding="0" cellspacing="2" style="border-radius:0px;">
					<tr>
						<td bgcolor="#F6F6F6" align="center" >
							<div style="height:440px; border:solid 1px black; width:94%;border-radius:8px 8px 8px 8px; background-color:white;">	
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